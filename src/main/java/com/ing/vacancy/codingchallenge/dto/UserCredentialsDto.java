package com.ing.vacancy.codingchallenge.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.function.Supplier;

@Data
@Builder
public class UserCredentialsDto {
    private String username;

    private Supplier<String> passwordSupplier;

    private List<String> roles;
}
