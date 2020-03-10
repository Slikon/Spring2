package com.example.epam_springboot.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "firstname_eng")
    private String nameEng;

    @Column(name = "firstname_ru")
    private String nameRu;

    @Column(name = "lastname_eng")
    private String lastNameEng;

    @Column(name = "lastname_ru")
    private String lastNameRu;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;
}