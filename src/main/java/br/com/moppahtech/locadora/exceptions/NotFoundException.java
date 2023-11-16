package br.com.moppahtech.locadora.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException (String message) {
        super(String.format(message));
    }
}
