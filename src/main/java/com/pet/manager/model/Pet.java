package com.pet.manager.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder

public class Pet {

    @Id
    private String id;
    @Indexed(unique = true)
    private String name;
    private PetType type;
    private Feed feed;
}
