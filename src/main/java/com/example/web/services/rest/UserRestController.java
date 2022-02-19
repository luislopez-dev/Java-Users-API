package com.example.web.services.rest;

import com.example.web.services.entity.UserEntity;
import com.example.web.services.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService theUserService){
        userService = theUserService;
    }

    /* List all users */
    @GetMapping("/users")
    public List findAll(){
        return userService.findAll();
    }

    /* Find User */
    @GetMapping("/{userId}")
    public UserEntity getUser(@PathVariable int userId){
        UserEntity theUser = userService.findById(userId);
        if (theUser == null){
            throw new RuntimeException("Employee id not found - " + userId);
        }
        return theUser;
    }

    /* Create user */
    @PostMapping("/")
    public UserEntity addUser(@RequestBody UserEntity theUser){
        theUser.setId(0);
        userService.save(theUser);
        return theUser;
    }

    /* Update user */
    @PutMapping("/")
    public UserEntity updateUser(@RequestBody UserEntity theUser){
        userService.save(theUser);
        return theUser;
    }
    /* Delete user */
    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId){
       UserEntity tempUser = userService.findById(userId);
       if (tempUser == null){
           throw new RuntimeException("User id not found - " + userId);
       }
       userService.deleteById(userId);
       return "User deleted id - " + userId;
    }

}
