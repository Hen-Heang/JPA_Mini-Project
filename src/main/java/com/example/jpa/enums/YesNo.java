package com.example.jpa.enums;

public enum YesNo implements GenericEnum<YesNo, String>{

    YES("Y"),
    NO("N")
    ;

    final String value;

    YesNo(String value) {
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public String getLabel() {

        if("Y".equals(value)){
            return "test";
        }

        return null;
    }
}
