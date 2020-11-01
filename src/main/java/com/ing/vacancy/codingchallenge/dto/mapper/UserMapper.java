package com.ing.vacancy.codingchallenge.dto.mapper;

import com.ing.vacancy.codingchallenge.data.entities.User;
import com.ing.vacancy.codingchallenge.dto.UserDto;
import lombok.NonNull;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class UserMapper {

    @Resource
    private ModelMapper modelMapper;

    @SneakyThrows
    public UserDto convertToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    public void copyProperties(@NonNull UserDto userDto, @NonNull User user) {
        modelMapper.map(userDto, user);
    }
}
