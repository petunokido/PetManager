package com.pet.manager.controller;


import com.pet.manager.service.AuthorService;
import com.pet.manager.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Validated
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService, BookService bookService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public ResponseEntity<AuthorResponse> getAuthorByFirstName(@RequestParam String firstName) {
        final var author = authorService.getByFirstName(firstName);
        final var response = AuthorResponse.builder()
                .age(author.getAge())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .build();

        return ResponseEntity.ok(response);
    }

    @PostMapping("/authors")
    public ResponseEntity<AuthorResponse> getAuthorByFirstName(@RequestBody @Valid AuthorCreationRequest request) {

        authorService.createAuthor(request.getFirstName(), request.getLastName(), request.getAge());
        return ResponseEntity.created(URI.create("/authors/")).build();
    }
}
