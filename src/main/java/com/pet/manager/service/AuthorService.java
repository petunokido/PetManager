package com.pet.manager.service;

import com.pet.manager.model.Author;
import com.pet.manager.repository.AuthorRepository;
import com.pet.manager.service.BookService;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookService bookService;

    public AuthorService(AuthorRepository authorRepository, BookService bookService) {
        this.authorRepository = authorRepository;
        this.bookService = bookService;
    }

    public Author getByFirstName(String firstName) {
        final var optionalAuthor = authorRepository.findAuthorByFirstName(firstName);
        if (optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        }
        throw new IllegalArgumentException("");
    }

    @Transactional
    public void createAuthor(String firstName, String lastName, int age) {
        try {
            authorRepository.insert(Author.builder().age(age).firstName(firstName).lastName(lastName).build());
            final Author author = getByFirstName(firstName); // if this throws an exception, this will rollback the transaction
            bookService.createBook(author.getId(), "first book");
        } catch (DuplicateKeyException exception) {
            throw new IllegalArgumentException("Duplicated firstName is not allowed");
        }
    }
}
