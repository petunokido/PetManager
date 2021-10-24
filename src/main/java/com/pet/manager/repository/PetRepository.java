package com.pet.manager.repository;

import com.pet.manager.model.Pet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends MongoRepository <Pet, String>
{

    Optional<Object> getPetByName(String name);
}
