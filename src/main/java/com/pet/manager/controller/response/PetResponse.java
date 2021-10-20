package com.pet.manager.controller.response;

import com.pet.manager.model.Feed;
import com.pet.manager.model.Pet;
import com.pet.manager.model.PetType;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
@Document
@Data

public class PetResponse {

    private String id;
    private String name;
    private PetType type;
    private Feed feed;

    public PetResponse petResponseResponse(Pet pet)
    {
        this.id = pet.getId();
        this.name = pet.getName();
        this.type = pet.getType();
        this.feed = pet.getFeed();
        return this;
    }
}
