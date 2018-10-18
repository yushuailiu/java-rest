package com.liuyushuai.javarest.controller;

import com.liuyushuai.javarest.model.Person;
import com.liuyushuai.javarest.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path="/")
public class PersonController {

    private PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @GetMapping(path="/test")
    public @ResponseBody String test() {
        return "hello world!";
    }

    @PostMapping(path="/person")
    public @ResponseBody String addPerson(@RequestParam("firstName") String firstName,
                                          @RequestParam("lastName") String lastName) {
        System.out.println(firstName);
        Person person = new Person();

        person.setFirstName(firstName);
        person.setLastName(lastName);
        personRepository.save(person);
        return "success";
    }

    @DeleteMapping(path="/person/{id}")
    public @ResponseBody String deletePerson(@PathVariable("id") int id) {
        Optional<Person> optionalPerson= personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return "not found";
        }
        Person person = optionalPerson.get();
        personRepository.delete(person);
        return "success";
    }

    @PutMapping(path="/person/{id}")
    public @ResponseBody String updatePerson(@PathVariable("id") int id, @RequestParam String firstName, @RequestParam String lastName) {
        Optional<Person> optionalPerson= personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return "not found";
        }
        Person person = optionalPerson.get();
        person.setFirstName(firstName);
        person.setLastName(lastName);
        personRepository.save(person);
        return "success";
    }

    @GetMapping(path="/person/{id}")
    public @ResponseBody Person getPerson(@PathVariable("id") int id) {
        Optional<Person> optionalPerson= personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            return null;
        }
        Person person = optionalPerson.get();
        return person;
    }

    @GetMapping(path = "/persons/{page}/{size}")
    public @ResponseBody Iterable<Person> listPerson(@PathVariable("page") int page,
                                                     @PathVariable("size") int size) {
        if (page <= 0) {
            page = 1;
        }
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = PageRequest.of(page - 1, size);
        return personRepository.findAll(pageable);
    }
}
