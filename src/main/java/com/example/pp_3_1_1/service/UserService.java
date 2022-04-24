package com.example.pp_3_1_1.service;

import com.example.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void save(User user);
    User findUser(int id);
    void update(User user, int id);
    void delete(int id);
}
