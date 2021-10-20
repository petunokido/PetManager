package com.pet.manager.controller.request;

import com.pet.manager.model.Feed;
import com.pet.manager.model.PetType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class PetRequest {

    private String name;
    private PetType type;
    private Feed feed;
}
