package com.example.simpleMvcCrud.services;

import com.example.simpleMvcCrud.entity.user;

import java.util.List;

public interface service {
    List<user> findAllUsers();
    void saveNewUser(user user);
    user findById(Long userToEditId);
    void saveChangesUser(user changedUser);
    void deleteUser(Long userToDeleteId);
}
