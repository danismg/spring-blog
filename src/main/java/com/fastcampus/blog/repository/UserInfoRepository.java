package com.fastcampus.blog.repository;

import com.fastcampus.blog.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserInfoRepository extends CrudRepository<UserInfo, Integer> {
    Optional<UserInfo> findByName(String name);
}
