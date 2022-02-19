package com.example.web.services.rest;

import com.example.web.services.entity.PostEntity;
import com.example.web.services.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class PostRestController {

    private PostService postService;

    @Autowired
    public PostRestController(PostService thePostService){
        postService = thePostService;
    }

    /* List all posts */
    @GetMapping("/posts")
    public List findAll(){
        return postService.findAll();
    }

    /* Find Post */
    @GetMapping("/{postId}")
    public PostEntity getPost(@PathVariable int postId){
        PostEntity thePost = postService.findById(postId);
        if (thePost == null){
            throw new RuntimeException("Employee id not found - " + postId);
        }
        return thePost;
    }

    /* Create post */
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/")
    public PostEntity addPost(@RequestBody PostEntity thePost){
        thePost.setId(0);
        postService.save(thePost);
        return thePost;
    }

    /* Update post */
    @PutMapping("/")
    public PostEntity updatePost(@RequestBody PostEntity thePost){
        postService.save(thePost);
        return thePost;
    }
    /* Delete post */
    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable int postId){
       PostEntity tempPost = postService.findById(postId);
       if (tempPost == null){
           throw new RuntimeException("Post id not found - " + postId);
       }
       postService.deleteById(postId);
       return "Post deleted id - " + postId;
    }

}
