package com.spring.security.springsecurity.service;

import com.spring.security.springsecurity.entity.UserEntity;
import com.spring.security.springsecurity.repository.UserDao;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;

@Named
public class UserService implements UserDetailsService {

    @Inject
    UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userDao.getUserByEmail(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("username "+userName+" not found");
        }
       return new User(userName, userEntity.getPassword(), userEntity.isActive(),
                true, true, true, new ArrayList<>());
    }
}
