package com.ing.vacancy.codingchallenge.api;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

@Data
@Builder
public class ErrorResponse {
    private String message;
    private Map<String, Object> details;
}
