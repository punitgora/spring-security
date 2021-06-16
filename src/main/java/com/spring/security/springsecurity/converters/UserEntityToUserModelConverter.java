package com.spring.security.springsecurity.converters;

import com.spring.security.springsecurity.entity.UserEntity;
import com.spring.security.springsecurity.model.UserModel;
import org.springframework.core.convert.converter.Converter;

import javax.inject.Named;

@Named
public class UserEntityToUserModelConverter implements Converter<UserEntity, UserModel> {

    @Override
    public UserModel convert(UserEntity userEntity) {
        return UserModel.builder()
                .email(userEntity.getEmail())
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .password(userEntity.getPassword())
                .active(userEntity.isActive())
                .build();
    }
}
