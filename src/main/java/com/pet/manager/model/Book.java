package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Book {
    @Id
    private String id;
    @Indexed(unique = true)
    private String title;
    private String authorId;
}
