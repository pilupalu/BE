package com.group.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTeamLeaderException extends RuntimeException {
    public InvalidTeamLeaderException(String message) {
        super(message);
    }
}
