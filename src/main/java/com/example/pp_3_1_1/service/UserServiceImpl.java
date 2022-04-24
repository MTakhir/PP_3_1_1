package com.example.pp_3_1_1.service;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl() {
    }

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findUser(int id) {
        return userRepository.getById(id);
    }

    @Override
    public void update(User user, int id) {
        user.setId(id);
        userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(int id) {
        userRepository.deleteById(id);
    }
}
