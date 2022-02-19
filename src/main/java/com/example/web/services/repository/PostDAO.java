package com.example.web.services.repository;

import com.example.web.services.entity.PostEntity;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PostDAO {
    private EntityManager entityManager;

    @Autowired
    public PostDAO(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    public List findAll(){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("from PostEntity", PostEntity.class);
        List posts = theQuery.getResultList();
        return posts;
    }

    public void save(PostEntity thePost){
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(thePost);
    }

    public PostEntity findById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        PostEntity thePost = currentSession.get(PostEntity.class, theId);
        return thePost;
    }

    public void deleteById(int theId){
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from PostEntity where id=:postId");
        theQuery.setParameter("postId", theId);
        theQuery.executeUpdate();
    }
}
