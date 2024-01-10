package com.example.jpa.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public interface GenericEnum<T, E> {

    @JsonValue
    E getValue();
    String getLabel();

}
