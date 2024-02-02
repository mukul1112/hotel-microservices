package com.lcwd.user.service.Userservice.Services;

import com.lcwd.user.service.Userservice.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserServices {
    //create
    User saveUser(User user);
    //get user by id
    User getUser(String UserId);
    //get user all
    List<User> getAllUser();

    User getbyName(String Name);

    void deletebyid(String userId);
}
