package com.ing.vacancy.codingchallenge.api.user;

import com.ing.vacancy.codingchallenge.api.ErrorResponse;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import com.ing.vacancy.codingchallenge.data.services.IUserService;
import com.ing.vacancy.codingchallenge.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("api/userdetails")
@Slf4j
public class UserDetailsController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDto> retrieve(@PathVariable(required = true) long id){
        return ResponseEntity.ok(userService.retrieve(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto, @PathVariable(required = true) long id){
        UserDto updatedUserDto = userService.update(userDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest){
        Map<String, Object> details = Map.of(
                "id", exception.getId()
        );
        final ErrorResponse errorResponse = ErrorResponse.builder().message(exception.getMessage()).build();
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleInvalidInput(MethodArgumentTypeMismatchException exception, WebRequest webRequest){
        Map<String, Object> details = Map.of(
                "name", exception.getName(),
                "value",exception.getValue()
        );
        final ErrorResponse errorResponse = ErrorResponse.builder()
                .message(exception.getMessage())
                .details(details)
                .build();
        return new ResponseEntity(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
