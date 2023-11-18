package com.example.proyectocomponentes.Exceptions;

import lombok.Data;

@Data
public class CustomException extends RuntimeException {
    private String message;

    public CustomException(String message) {
        super(message);
        this.message = message;
    }

}