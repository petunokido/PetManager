package com.pet.manager.exception;

public class DuplicatePetException extends RuntimeException{

    public DuplicatePetException()
    {
        super("Book with this address already exists");
    }

    public DuplicatePetException(String message)
    {
        super (message);
    }
}
