package com.springboot.SpringBoot_firstApp.dao;

import com.springboot.SpringBoot_firstApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceContext;

import java.sql.SQLDataException;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addOrUpdateUser(User user) {

        if (user.getId() == null) {
            entityManager.persist(user);
        } else {
            entityManager.merge(user);
        }

    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User  ", User.class).getResultList();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void removeUser(Long id) throws SQLDataException {

        User user = getUserById(id);
        if (user == null) {
            throw new SQLDataException("User not found");
        }

        entityManager.remove(user);
    }
}
