package com.pulldataNswagger.controllers;

import com.pulldataNswagger.models.Comment;
import com.pulldataNswagger.models.Post;
import com.pulldataNswagger.services.CommentService;
import com.pulldataNswagger.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }
    @GetMapping("/posts/{id}")
    public Post getPostById(@PathVariable int id){
        return postService.getPostById(id);
    }
    @GetMapping("/posts/{id}/comments")
    public List<Comment> getPostByIdComments(@PathVariable int id){
        return commentService.getPostByIdComments(id);
    }
}
