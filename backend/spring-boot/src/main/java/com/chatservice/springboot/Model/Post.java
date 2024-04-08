package com.chatservice.springboot.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String authorId;
    @Column(nullable = false)
    private Integer likeCount = 0; // Initialize with 0 likes
    @Column(name = "Category")
    private String category;
    @ElementCollection
    private List<String> mediaAttachments;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public Integer getLikeCount() { return likeCount; }

    public void setLikeCount(Integer likeCount) { this.likeCount = likeCount; }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getMediaAttachments() {
        return mediaAttachments;
    }

    public void setMediaAttachments(List<String> mediaAttachments) {
        this.mediaAttachments = mediaAttachments;
    }
}