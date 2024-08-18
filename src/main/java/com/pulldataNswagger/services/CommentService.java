package com.pulldataNswagger.services;

import com.pulldataNswagger.models.Comment;
import com.pulldataNswagger.models.Post;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class CommentService {
    private final RestTemplate restTemplate;

    public CommentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Comment> getPostByIdComments(int id) {
        String url ="https://jsonplaceholder.typicode.com/posts/" +id+"/comments";
        Comment[] comments = restTemplate.getForObject(url, Comment[].class);
        return Arrays.asList(comments);
    }
}
