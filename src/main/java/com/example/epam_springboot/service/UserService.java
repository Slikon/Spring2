package com.example.epam_springboot.service;

import com.example.epam_springboot.dto.UsersDTO;
import com.example.epam_springboot.entity.User;
import com.example.epam_springboot.repository.UsersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public void createUsers(User user) {
        usersRepository.save(user);
    }

    public List<User> findAll(){
        return usersRepository.findAll();
    }

    public User findById(Long userId){
        return usersRepository.findById(userId).orElse(null);
    }

    public List<User> findAllByName(String name){
        return usersRepository.findAllByNameEng(name);
    }

    public UsersDTO getAllUsers() {
        //TODO checking for an empty user list
        return new UsersDTO(usersRepository.findAll());
    }

    public void saveNewUser (User user){
        //TODO inform the user about the replay email
        // TODO exception to endpoint
        try {
            usersRepository.save(user);
        } catch (Exception ex){
            log.info("{Почтовый адрес уже существует}");
        }

    }
}