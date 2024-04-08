package com.chatservice.springboot.Model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "postComments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentID")
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @Column(name = "commentDate", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date commentDate;

    @Column(name = "idUser", nullable = false)
    private Long userId;

    @Column(name = "postID", nullable = false)
    private Long postId;

    // Getters
    public Long getCommentId() {
        return commentId;
    }

    public String getContent() {
        return content;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getPostId() {
        return postId;
    }

    // Setters
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
