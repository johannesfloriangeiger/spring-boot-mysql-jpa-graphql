package org.example.controller;

public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException(final Class<?> clazz, final Integer id) {
        this.message = "%s with ID %d not found.".formatted(clazz.getSimpleName(), id);
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}