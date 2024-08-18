package com.pulldataNswagger.services;

import com.pulldataNswagger.models.Post;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PostService {

    private final RestTemplate restTemplate;
    //Bu api ı application propertiese tası her yerde kullan
    private final String apiUrl = "https://jsonplaceholder.typicode.com/posts/";
    public PostService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    public List<Post> getPosts() {
        String url = apiUrl;
        Post[] posts = restTemplate.getForObject(url, Post[].class);
        return Arrays.asList(posts);
    }
    public Post getPostById(int id) {
        String url = apiUrl + id;
        return restTemplate.getForObject(url, Post.class);
    }
    public void deletePost(Long id)
    {
        String url = apiUrl + "/" + id;
        RestTemplate restTemplate = new RestTemplate();
        try {
            restTemplate.delete(url);
        } catch (HttpClientErrorException e) {
            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
                throw new RuntimeException("Post not found with id " + id);
            } else {
                throw new RuntimeException("Error occurred while deleting post with id " + id, e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Unexpected error occurred", e);
        }
    }
}
