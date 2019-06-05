package com.gyt.fittrainer.dto;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private Long userId;

    private String userName;

    private String password;

    private String telephone;

    private String email;

    private String type;
}