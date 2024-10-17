package com.ucentral.secmgmt.service;

import com.ucentral.secmgmt.model.User;

import java.util.List;

public interface UserService {
    public List<User> listUsers();
    public User saveUsers(User user);

    public User findUserbyId(Long id);
    public void  deleteUser(Long id);
}
