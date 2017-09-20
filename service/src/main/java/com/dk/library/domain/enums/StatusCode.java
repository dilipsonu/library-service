package com.dk.library.domain.enums;


public enum StatusCode {
    PENDING("PENDING"), SUCCESS("SUCCESS"), ERROR("ERROR");
    private String value;

    StatusCode(String value) {
        this.value = value;
    }

    public String getStatusCode()
    {
        return this.value;
    }
}
