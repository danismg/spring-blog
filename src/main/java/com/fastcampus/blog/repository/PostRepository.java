package com.fastcampus.blog.repository;

import com.fastcampus.blog.entity.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public interface PostRepository extends CrudRepository<Post, Integer> {
    Optional<Post> findFirstById(Long id);
    Optional<Post> findFirstByIdAndIsDeleted(Long id, Boolean isDeleted);

    // softdelete
    List<Post> findByIsDeleted(boolean isDeleted);
  }
