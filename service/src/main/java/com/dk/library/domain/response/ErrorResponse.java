package com.dk.library.domain.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.Collections;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ErrorResponse {

    @JsonProperty ("ts")
    private DateTime timeStamp = new DateTime().toDateTimeISO();
    private int httpStatus;
    private List<ErrorMessage> errors;

    public ErrorResponse(int httpStatus, String code, String message) {
        this.httpStatus = httpStatus;
        this.errors =
                Collections.singletonList(new ErrorMessage(code, message));
    }
}
