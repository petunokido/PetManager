package com.pet.manager.service;

import com.pet.manager.controller.request.PetRequest;
import com.pet.manager.exception.PetConflict;
import com.pet.manager.exception.PetNotFound;
import com.pet.manager.model.Pet;
import com.pet.manager.repository.PetRepository;
import org.springframework.stereotype.Service;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }


    public Pet findById(String id) {
        return petRepository.findById(id).orElseThrow(PetConflict::new);
    }

    public Pet save(Pet createPet) {
        return petRepository.save(createPet);
    }

    public void deleteById(String id) {

        this.findById(id);
        petRepository.deleteById(id);
    }

    public Pet update(String id, PetRequest petRequest) {
        Pet pet = this.findById(id);
        pet.setName(petRequest.getName());
        pet.setType(petRequest.getType());
        pet.setFeed(petRequest.getFeed());

        return petRepository.save(pet);
        //Missing 409 Conflict Exception
    }

    public Pet findByName(String name) {
        return (Pet) petRepository.getPetByName(name).orElseThrow(PetNotFound::new);

    }

}
