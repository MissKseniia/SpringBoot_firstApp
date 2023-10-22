package com.springboot.SpringBoot_firstApp.controller;

import com.springboot.SpringBoot_firstApp.entity.User;
import com.springboot.SpringBoot_firstApp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showAllUsers(ModelMap model) {

        model.addAttribute("users", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/new")
    public String createUser(@ModelAttribute("user") User user) {

        return "createOrUpdate_user";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.addOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/update")
    public String updateUser(@RequestParam("userId") Long id, ModelMap model) {

        model.addAttribute("user", userService.getUserById(id));
        return "createOrUpdate_user";
    }

    @GetMapping("/remove")
    public String removeUser(@RequestParam("userId") Long id) {

        userService.removeUser(id);
        return "redirect:/users";
    }

}
