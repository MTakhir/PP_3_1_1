package com.example.pp_3_1_1.controller;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String addUser (@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String  edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.findUser(id));
        return "update";
    }

    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(user, id);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
