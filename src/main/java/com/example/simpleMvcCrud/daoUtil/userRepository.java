package com.example.simpleMvcCrud.daoUtil;

import com.example.simpleMvcCrud.entity.user;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class userRepository implements userRepositoryInterface{
    @Autowired
    private SessionFactory factory;

    @Override
    public List<user> findAllUsers() {
        Session session = factory.getCurrentSession();
        List<user> resultList = session.createQuery("from user", user.class).getResultList();

        return resultList;
    }
    @Override
    public void saveNewUser(user user) {
        Session session = factory.getCurrentSession();
        session.persist(user);
    }
    @Override
    public user findById(Long userToEditId) {
        Session session = factory.getCurrentSession();
        return session.find(user.class, userToEditId);
    }

    @Override
    public void saveChangesUser(user changedUser) {
        Session session = factory.getCurrentSession();
        session.merge(changedUser);
    }

    @Override
    public void deleteUser(Long userToDeleteId){
        Session session = factory.getCurrentSession();
        Query<user> query = session.createQuery("delete from user where id =:userId");
        query.setParameter("userId", userToDeleteId);
        query.executeUpdate();
    }
}
