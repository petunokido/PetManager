package com.pet.manager.controller;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorCreationRequest {
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    private int age;
}
