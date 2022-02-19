package com.example.web.services.repository;

import com.example.web.services.entity.UserEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAO {
    private EntityManager entityManager;

    @Autowired
    public UserDAO(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from UserEntity", UserEntity.class);
        List users = theQuery.getResultList();
        return users;
    }

    public void save(UserEntity theUser){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theUser);
    }

    public UserEntity findById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        UserEntity theUser = currentSession.get(UserEntity.class, theId);
        return theUser;
    }

    public void deleteById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from UserEntity where id=:userId");
        theQuery.setParameter("userId", theId);
        theQuery.executeUpdate();
    }
}
