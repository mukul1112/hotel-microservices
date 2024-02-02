package com.lcwd.user.service.Userservice.controller;

import com.lcwd.user.service.Userservice.Services.UserServices;
import com.lcwd.user.service.Userservice.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class Usercontroller {
    @Autowired
    private UserServices userServices;

    // create
     @PostMapping()
    public ResponseEntity<User> CreateUSer(@RequestBody User user){
         User user1=userServices.saveUser(user);
         return ResponseEntity.status(HttpStatus.CREATED).body(user1);
     }
     @GetMapping("/{UserId}")
     public ResponseEntity<User> getSingleUser(@PathVariable String UserId){
         User user=userServices.getUser(UserId);
         return  ResponseEntity.ok(user);

     }
     @GetMapping()
     public  ResponseEntity<List<User>>  getalluser(){
         List<User> user=userServices.getAllUser();

         return ResponseEntity.ok(user);
     }
     @DeleteMapping("/{userId}")
     public ResponseEntity<User> DeleteHotel(@PathVariable  String userId){
         userServices.deletebyid(userId);

         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

     }




}
