package com.personal.shop.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter @Setter
public class NewUserForm {

    // Spring validation
    @NotBlank(message = "This field can't be empty")
    private String username;

    @NotBlank(message = "This field can't be empty")
    private String password;

    @NotBlank(message = "This field can't be empty")
    private String name;


}
