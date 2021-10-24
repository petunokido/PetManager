package com.pet.manager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface AuthorRepository extends MongoRepository<Author, String> {
    Optional<Author> findAuthorByFirstName(String firstName);
}
