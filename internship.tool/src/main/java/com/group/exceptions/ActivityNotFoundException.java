package com.group.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class ActivityNotFoundException extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ActivityNotFoundException(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public ActivityNotFoundException(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no activity with this ID",cause);
        this.httpStatus=httpStatus;
    }
}
