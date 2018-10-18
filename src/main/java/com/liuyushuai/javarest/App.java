package com.liuyushuai.javarest;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@EnableJpaRepositories("com.liuyushuai.javarest.repositories")
@EntityScan("com.liuyushuai.javarest.model")
@SpringBootApplication
public class App
{
    public static void main( String[] args ) {
        System.out.println("springboot-------------------开始启动");
        SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);

        app.run(args);
        //SpringApplication.run(TestController.class, args);
        System.out.println("springboot-------------------启动完成");
    }
}
