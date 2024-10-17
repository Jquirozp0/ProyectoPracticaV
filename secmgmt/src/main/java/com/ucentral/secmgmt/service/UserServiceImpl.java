package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.User;
import com.ucentral.secmgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUsers(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findUserbyId(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
