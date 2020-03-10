package com.example.epam_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String firstname_eng;
    private String firstname_ru;
    private String lastname_eng;
    private String lastname_ru;
    private String login;
    private String password;
}