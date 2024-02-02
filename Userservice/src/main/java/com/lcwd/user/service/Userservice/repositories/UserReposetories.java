package com.lcwd.user.service.Userservice.repositories;

import com.lcwd.user.service.Userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserReposetories extends JpaRepository<User,String> {

    // any custom method

}
