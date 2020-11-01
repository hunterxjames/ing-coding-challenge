package com.ing.vacancy.codingchallenge.dto;

import lombok.Data;

@Data
public class UserDto {

    private String firstName;

    private String lastName;

    private String gender;

    private String title;

    private AddressDto address;

}
