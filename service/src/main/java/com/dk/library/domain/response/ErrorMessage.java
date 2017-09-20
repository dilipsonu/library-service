package com.dk.library.domain.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorMessage {

    public static final String ERROR_CODE_99 = "99";
    public static final String SERVICE_UNAVAILABLE = "Service Unavailable";
    public static final String DATABASE_ERROR = "Error querying database";
    private String code;
    private String message;
}
