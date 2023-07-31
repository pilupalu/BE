package com.group.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException{

    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public UserNotFound(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public UserNotFound(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no user!",cause);
        this.httpStatus=httpStatus;
    }
}
