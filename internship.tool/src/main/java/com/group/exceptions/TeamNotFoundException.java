package com.group.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class TeamNotFoundException extends RuntimeException{

    @Getter
    private final HttpStatus httpStatus;

    public TeamNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public TeamNotFoundException(HttpStatus httpStatus) {
        this(httpStatus, "Team not found");
    }
}
