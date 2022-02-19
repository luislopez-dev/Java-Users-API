package com.example.web.services.service;

import com.example.web.services.entity.UserEntity;
import com.example.web.services.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {

    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO theUserDAO){
        userDAO = theUserDAO;
    }

    @Transactional
    public List findAll(){
        return userDAO.findAll();
    }

    @Transactional
    public void deleteById(int theId){
        userDAO.deleteById(theId);
    }

    @Transactional
    public UserEntity findById(int theId){
        return userDAO.findById(theId);
    }

    @Transactional
    public void save(UserEntity theUser){
         userDAO.save(theUser);
    }
}
