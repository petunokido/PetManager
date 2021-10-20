package com.pet.manager.controller;


import com.pet.manager.controller.request.PetRequest;
import com.pet.manager.controller.response.PetResponse;
import com.pet.manager.model.Pet;
import com.pet.manager.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated

public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/pets")
    public ResponseEntity<List<Object>> getPets(@RequestParam String type) {

        System.out.println(type);
        return ResponseEntity.ok(Collections.emptyList());
    }

    @GetMapping("/get-pet-by-id/{id}")
    public PetResponse getPetById (@PathVariable (value = "id") String id)
    {
        Pet pet = petService.findById(id);
        return new PetResponse().petResponseResponse(pet);
    }

    @GetMapping("/get/{name}")
    public PetResponse getPetName (@PathVariable(value = "name") String name)
    {
        Pet pet = petService.findByName(name);
        return new PetResponse().petResponseResponse(pet);
        //Missing 404 NotFound Exception
    }

    @PostMapping(value = "/add-pet", consumes = "application/json", produces = "application/json")

    public PetResponse createNewPet(@RequestBody PetRequest petRequest) {
        Pet addPet = petService.save(
                Pet.builder()
                .name(petRequest.getName())
                .type(petRequest.getType())
                .build());


        return new PetResponse().petResponseResponse(addPet);

    }
    @PutMapping(value = "/update-pet/{id}")

    public PetResponse updatePet(@PathVariable(value = "id") String id, @RequestBody PetRequest petRequest) {
        Pet pet= petService.update(
                id,
                petRequest);
        return new PetResponse().petResponseResponse(pet);
        //Missing 409 Conflict Exception
    }

    @DeleteMapping(value="/deletepet/{id}")

    public void deletePet (@PathVariable(value = "id") String id)
    {
        petService.deleteById(id);
    }
}
