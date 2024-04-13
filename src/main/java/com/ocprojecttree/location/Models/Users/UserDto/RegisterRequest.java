package com.ocprojecttree.location.Models.Users.UserDto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterRequest {
    private String email;
    private String name;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private  String password;
}
