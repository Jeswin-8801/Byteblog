package com.jeswin8801.byteBlog.entities.dto.auth.requests;

import lombok.Data;

@Data
public class LoginRequestDto {

    private String email;

    private String password;
}