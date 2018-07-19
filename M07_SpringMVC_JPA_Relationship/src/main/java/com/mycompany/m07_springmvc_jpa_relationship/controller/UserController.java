/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.m07_springmvc_jpa_relationship.controller;

import com.mycompany.m07_springmvc_jpa_relationship.entities.CountriesEntity;
import com.mycompany.m07_springmvc_jpa_relationship.entities.UserEntity;
import com.mycompany.m07_springmvc_jpa_relationship.enums.Gender;
import com.mycompany.m07_springmvc_jpa_relationship.repository.CountryRepository;
import com.mycompany.m07_springmvc_jpa_relationship.service.CountryService;
import com.mycompany.m07_springmvc_jpa_relationship.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnhLe
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(value = {"/", "/home"})
    public String getLstUser(Model model) {
        model.addAttribute("lstUser", userService.getLstUser());
        return "home";
    }

    @ModelAttribute("genders")
    private Gender[] gender() {
        return Gender.values();
    }

    @ModelAttribute("countries")
    private List<CountriesEntity> countries() {
        return countryService.getLstCountries();
    }

    @RequestMapping("/add-new")
    public String showPageAddNewUser(Model model) {
        model.addAttribute("user", new UserEntity());
        model.addAttribute("action", "register");
        return "add-new-html";
    }

    @RequestMapping("/register")
    public String registerUser(Model model, @ModelAttribute(value = "user") UserEntity user) {
        UserEntity u = userService.addNewUser(user);
        if (u.getId() > 0 && u.getUserDetail() != null && u.getUserDetail().getId() > 0) {
            return "redirect:/home";
        } else {
            model.addAttribute("message", "add new user fail");
            model.addAttribute("user", new UserEntity());
            model.addAttribute("action", "register");
            return "add-new-html";
        }
    }

    @RequestMapping("/edit/{id}")
    public String editUser(Model model,
            @PathVariable(value = "id") int id) {
        UserEntity user = userService.getUserById(id);
        if (user != null && user.getId() > 0) {
            model.addAttribute("action", "editUser");
            model.addAttribute("user", user);
        } else {
            model.addAttribute("message", "Not Found user with id= " + id);
            model.addAttribute("user", new UserEntity());
            model.addAttribute("action", "register");
        }
        return "add-new-html";
    }

    @RequestMapping("/editUser")
    public String actionEdit(Model model, @ModelAttribute(value = "user") UserEntity user) {
        UserEntity u = userService.addNewUser(user);
        if (u.getId() > 0) {
            return "redirect:/home";
        } else {
            model.addAttribute("message", "edit user fail");
            model.addAttribute("user", user);
            model.addAttribute("action", "editUser");
            return "add-new-html";
        }
    }

    @RequestMapping("/delete/{id}")
    public String deleteUser(Model model,
            @PathVariable(value = "id") int id) {
        userService.deleteUserByIdNoMessage(id);
        return "redirect:/home";
    }

    @RequestMapping("/search")
    public String searchUser(@ModelAttribute(value = "searchText") String searchText,
            Model model) {
        model.addAttribute("lstUser", userService.findUserByEmail(searchText));
        return "home";
    }
}
