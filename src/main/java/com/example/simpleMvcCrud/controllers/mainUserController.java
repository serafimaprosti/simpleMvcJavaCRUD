package com.example.simpleMvcCrud.controllers;

import com.example.simpleMvcCrud.entity.user;
import com.example.simpleMvcCrud.services.service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller    //  url -> localhost:8080
public class mainUserController {
    @Autowired
    private service service;    //  interface

    @RequestMapping
    public String showAllUsers(Model model){
        List<user> users = service.findAllUsers();
        model.addAttribute("mainUserControllerShowAllUsers", users);
        return "main-page";
    }


    @RequestMapping(path = "/add-new")
    public String addNewUser(Model model){
        model.addAttribute("userForm", new user());
        return "add-new-page";
    }


    @RequestMapping(path = "/new") //  add new user
    public String addingNewUser(@ModelAttribute("userForm") @Valid user newUser,
                                BindingResult validResult){

        if (validResult.hasErrors()){
            return "add-new-page";
        }else {
            service.saveNewUser(newUser);
            return "redirect:/";
        }

    }
}
