package com.spring.security.springsecurity.repository;
import com.spring.security.springsecurity.entity.UserEntity;

public interface UserDao {
    public UserEntity getUserByEmail(String email);

    public UserEntity saveOrUpdate(UserEntity userEntity);
}
