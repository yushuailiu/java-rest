package com.liuyushuai.javarest.repositories;

import com.liuyushuai.javarest.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
}
