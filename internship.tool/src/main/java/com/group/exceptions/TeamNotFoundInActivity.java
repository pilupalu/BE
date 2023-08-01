package com.group.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeamNotFoundInActivity extends RuntimeException{
    private final HttpStatus httpStatus;

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public TeamNotFoundInActivity(HttpStatus httpStatus)
    {
        this(httpStatus,null);
    }

    public TeamNotFoundInActivity(HttpStatus httpStatus,Throwable cause)
    {
        super("There is no team in this activity",cause);
        this.httpStatus=httpStatus;
    }
}
