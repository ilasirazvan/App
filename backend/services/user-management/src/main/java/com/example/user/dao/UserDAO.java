package com.example.user.dao;

import com.example.user.entity.UserAccount;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class UserDAO {

    @PersistenceContext(unitName = "user-pu")
    EntityManager entityManager;

    public List<UserAccount> getUsers() {
        return entityManager.createQuery("SELECT u FROM UserAccount u").getResultList();
    }

    @Transactional
    public boolean registerUser(UserAccount userAccount) {
         try{
             entityManager.persist(userAccount);
         } catch (Exception ex){
             return false;
         }
         return true;
    }

    public UserAccount getUser(String userId) {
        return entityManager.find(UserAccount.class, userId);
    }

    public UserAccount getUserByUsername(String username) {
        Query namedQuery = entityManager.createNamedQuery("UserAccount.findUserAccountByUsername");
        namedQuery.setParameter("username", username);
        return (UserAccount) namedQuery.getSingleResult();
    }
}
