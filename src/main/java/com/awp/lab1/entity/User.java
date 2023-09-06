package com.awp.lab1.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Data
public class User {
    @Setter(AccessLevel.PROTECTED)
    private Integer id;
    private String login;
    private String password;
}
