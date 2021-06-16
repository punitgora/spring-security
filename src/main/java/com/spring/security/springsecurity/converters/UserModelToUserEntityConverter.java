package com.spring.security.springsecurity.converters;

import com.spring.security.springsecurity.entity.UserEntity;
import com.spring.security.springsecurity.model.UserModel;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class UserModelToUserEntityConverter implements Converter<UserModel, UserEntity> {

    @Inject
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity convert(UserModel userModel) {
        return UserEntity.builder()
                .email(userModel.getEmail())
                .firstName(userModel.getFirstName())
                .lastName(userModel.getLastName())
                .password(passwordEncoder.encode(userModel.getPassword()))
                .active(userModel.isActive())
                .build();
    }
}
