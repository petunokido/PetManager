package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.awt.print.Book;
import java.util.List;

@Document
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Author {
    @Id
    private String id;
    @Indexed
    private int age;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    private List<Book> books;
}
