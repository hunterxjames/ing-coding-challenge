package com.ing.vacancy.codingchallenge.exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
@Getter
public class UserNotFoundException extends RuntimeException {
    private long id;
    public UserNotFoundException(long id) {
        super("User id: "+ id + " doesn't exist");
    }
}
