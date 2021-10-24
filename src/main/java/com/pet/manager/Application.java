package com.pet.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//    public CommandLineRunner createMongoDbIndex(
//            AuthorRepository repository
//    ) {
//        return args -> {
//            //repository.findAuthorByFirstName(author.getFirstName());
//            //Create indexes
//        };
//    }
}
