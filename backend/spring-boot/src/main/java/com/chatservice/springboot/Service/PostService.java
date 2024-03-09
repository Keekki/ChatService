package com.chatservice.springboot.Service;

import com.chatservice.springboot.Model.Post;
import com.chatservice.springboot.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    // Used to search by category, if there is no category, returns all posts
    public Page<Post> getPosts(String category, Pageable pageable) {
        if (category != null) {
            return postRepository.findByCategory(category, pageable);
        } else {
            return postRepository.findAll(pageable);
        }
    }

    // If the contents of the Post are not found, throws an exception
    public Post updatePost(Long id, Post postDetails) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setContent(postDetails.getContent());
                    post.setCategory(postDetails.getCategory());
                    post.setMediaAttachments(postDetails.getMediaAttachments());
                    return postRepository.save(post);
                }).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}