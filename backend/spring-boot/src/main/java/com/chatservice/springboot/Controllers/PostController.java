package com.chatservice.springboot.Controllers;

import com.chatservice.springboot.Model.Post;
import com.chatservice.springboot.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post createPost(@RequestBody Post post) {
        return postService.createPost(post);
    }

    @GetMapping
    public Page<Post> getPosts(
            @RequestParam(required = false) String category,
            Pageable pageable) {
        return postService.getPosts(category, pageable);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable(value = "id") Long postId, @RequestBody Post postDetails) {
        return postService.updatePost(postId, postDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePost(@PathVariable(value = "id") Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }
}