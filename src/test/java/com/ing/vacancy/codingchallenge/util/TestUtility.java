package com.ing.vacancy.codingchallenge.util;

import com.ing.vacancy.codingchallenge.data.entities.Address;
import com.ing.vacancy.codingchallenge.data.entities.User;
import com.ing.vacancy.codingchallenge.dto.AddressDto;
import com.ing.vacancy.codingchallenge.dto.UserDto;

public class TestUtility {

    public static User createUser(long userId){
        User user = new User();
        user.setId(userId);
        user.setAddress(new Address());
        user.setFirstName("John");
        user.setLastName("Doe");
        user.getAddress().setCity("Sydney");
        return user;
    }

    public static UserDto createUserDto(){
        UserDto userDto = new UserDto();
        userDto.setAddress(new AddressDto());
        userDto.setTitle("Ms");
        return userDto;
    }
}
