package com.fastcampus.blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Table(name = "post")
@Data
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(length = 100, nullable = false)
    private String title;

    @NotBlank(message = "Body is required")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String body;

    @NotBlank(message = "Slug is required")
    @Column(length = 100, nullable = false, unique = true)
    private String slug;

    @Column(name = "is_deleted", nullable = false)
    private boolean isDeleted = false;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserInfo user;

}
