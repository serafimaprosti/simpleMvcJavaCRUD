package com.example.simpleMvcCrud.services;

import com.example.simpleMvcCrud.daoUtil.userRepositoryInterface;
import com.example.simpleMvcCrud.entity.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;

@Service
public class userService implements service{
    @Autowired
    private userRepositoryInterface repository;  //  interface
    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED) //by default
    public List<user> findAllUsers() {
        List<user> resultList = repository.findAllUsers();
        resultList.sort(Comparator.comparing(user::getUserId));
        return resultList;
    }

    @Override
    @Transactional
    public void saveNewUser(user user) {
        repository.saveNewUser(user);
    }

    @Override
    @Transactional
    public user findById(Long userToEditId) {
        return repository.findById(userToEditId);
    }

    @Override
    @Transactional
    public void saveChangesUser(user changedUser) {
        repository.saveChangesUser(changedUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long userToDeleteId) {
        repository.deleteUser(userToDeleteId);
    }
}
