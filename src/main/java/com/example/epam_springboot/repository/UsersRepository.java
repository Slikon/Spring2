package com.example.epam_springboot.repository;

import com.example.epam_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsersRepository extends JpaRepository<User, Long> {
    public List<User> findAllByNameEng(String name);
}