package com.pulldataNswagger.controllers;

import com.pulldataNswagger.models.Comment;
import com.pulldataNswagger.models.Post;
import com.pulldataNswagger.services.CommentService;
import com.pulldataNswagger.services.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @Operation(summary = "Get all posts",description = "Return all posts. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the posts"),
            @ApiResponse(responseCode = "404", description = "Posts not found")
    })
    @GetMapping("/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @Operation(summary = "Get a post by ID",description = "Return single post. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the post"),
            @ApiResponse(responseCode = "404", description = "Post not found")
    })
    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") int id){
        Post post = postService.getPostById(id);
        if (post == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(post);
    }
    @Operation(summary = "Get by post comment",description = "Return all post comments. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the posts comments"),
            @ApiResponse(responseCode = "404", description = "Post comments not found")
    })
    @GetMapping("/posts/{id}/comments")
    public List<Comment> getPostByIdComments(@PathVariable("id") int id){
        return commentService.getPostByIdComments(id);
    }
    @Operation(summary = "Delete a post by ID",description = "Deleted single post with id. ")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted the post"),
            @ApiResponse(responseCode = "404", description = "Posts could not be deleted")
    })
    @DeleteMapping("posts/{id}")
    public ResponseEntity<String> deletePost(@PathVariable("id") Long id)
    {
        try {
            postService.deletePost(id);
            return ResponseEntity.ok("Post deleted succesfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Post not found with id"+id);
        }
    }

}
