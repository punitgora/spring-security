package com.spring.security.springsecurity.repository;


import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import com.spring.security.springsecurity.entity.UserEntity;

import java.util.List;

@Named
@Transactional
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public UserEntity getUserByEmail(String email) {
        /** some variation we can use
         * select u from UserEntity u where u.email LIKE ?1
         * select u from UserEntity u where u.email = ?1
         * select u from UserEntity u where u.email LIKE :custEmail
         *
         */
        List userList = entityManager.createQuery("select u from UserEntity u where u.email = ?1")
                .setParameter(1, email)
                .setMaxResults(1)
                .getResultList();

        if (userList.size() == 0) {
            return null;
        }

        return (UserEntity)userList.get(0);
    }

    @Override
    public UserEntity saveOrUpdate(UserEntity userEntity) {
        return entityManager.merge(userEntity);
    }
}
