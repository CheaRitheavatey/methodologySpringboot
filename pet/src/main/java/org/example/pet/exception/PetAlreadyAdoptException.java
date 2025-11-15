package org.example.pet.exception;

public class PetAlreadyAdoptException extends RuntimeException {
    public PetAlreadyAdoptException(String message, Throwable cause) {
        super(message,cause);
    }
    public PetAlreadyAdoptException(String message) {
        super(message);
    }
}
