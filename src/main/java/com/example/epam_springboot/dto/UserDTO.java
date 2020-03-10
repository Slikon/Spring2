package com.example.epam_springboot.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserDTO {
    private String first_name_eng;
    private String first_name_ru;
    private String last_name_eng;
    private String last_name_ru;
    private String email;
    private String password;
}