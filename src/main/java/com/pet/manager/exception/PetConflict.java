package com.pet.manager.exception;

public class PetConflict extends RuntimeException {

    public PetConflict(String message) {
        super(message);
    }

    public PetConflict() {
        super("Pet not found.");
    }

}
