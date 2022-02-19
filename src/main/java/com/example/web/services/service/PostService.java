package com.example.web.services.service;

import com.example.web.services.entity.PostEntity;
import com.example.web.services.repository.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    private PostDAO postDAO;

    @Autowired
    public PostService(PostDAO thePostDAO){
        postDAO = thePostDAO;
    }

    @Transactional
    public List findAll(){
        return postDAO.findAll();
    }

    @Transactional
    public void deleteById(int theId){
        postDAO.deleteById(theId);
    }

    @Transactional
    public PostEntity findById(int theId){
        return postDAO.findById(theId);
    }

    @Transactional
    public void save(PostEntity thePost){
         postDAO.save(thePost);
    }
}
