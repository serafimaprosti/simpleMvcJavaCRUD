package com.example.simpleMvcCrud.controllers;

import com.example.simpleMvcCrud.entity.user;
import com.example.simpleMvcCrud.services.service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;



@Controller
public class editDeleteController {

    @Autowired
    private service service; //  interface

    @RequestMapping(path = "/edit/{id}")
    public String editUser(Model model, @PathVariable("id") Long userToEditId){
        user userToEdit = service.findById(userToEditId);
        model.addAttribute("userToEdit", userToEdit);

        return "edit-page";
    }
    @RequestMapping(path = "/edit/saveChanges")
    public String saveChanges(@ModelAttribute("userToEdit") @Valid user userToEdit, BindingResult validResult){
        if (validResult.hasErrors()){
            return "edit-page";
        }else {
            service.saveChangesUser(userToEdit);
            return "redirect:/";
        }
    }
    @RequestMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") Long userToDeleteId){
        service.deleteUser(userToDeleteId);

        return "redirect:/";
    }

}
