package com.ing.vacancy.codingchallenge.data.services;

import com.ing.vacancy.codingchallenge.dto.UserCredentialsDto;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import lombok.NonNull;

public interface IUserService {
    UserDto retrieve(@NonNull long id);

    UserDto update(@NonNull UserDto userDto, long id);

    UserCredentialsDto getByUsername(String username);
}
