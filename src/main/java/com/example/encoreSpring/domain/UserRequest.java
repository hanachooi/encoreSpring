package com.example.encoreSpring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter @Getter @ToString
@NoArgsConstructor
public class UserRequest {

    private String id;
    private String pwd;

}
