package com.example.simpleMvcCrud.daoUtil;

import com.example.simpleMvcCrud.entity.user;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface userRepositoryInterface {
    List<user> findAllUsers();
    void saveNewUser(user user);
    user findById(Long userToEditId);
    void saveChangesUser(user changedUser);
    void deleteUser(Long userToDeleteId);
}
