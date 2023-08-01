package com.group.exceptions;

import org.springframework.http.HttpStatus;

public class TeamNotFoundException extends RuntimeException{

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public TeamNotFoundException(HttpStatus httpStatus) {
        this(httpStatus, "There is no team with this id");
    }

    public TeamNotFoundException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
