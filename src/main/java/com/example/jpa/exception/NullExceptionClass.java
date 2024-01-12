package com.example.jpa.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NullExceptionClass extends RuntimeException{

    private final String title;

    public NullExceptionClass(String message, String title) {
        this.title = title;
    }
}
