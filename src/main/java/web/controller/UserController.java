package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        model.addAttribute(userService.getUserById(id));
        return "showUser";
    }

    @GetMapping("/createUser")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUserById(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return "redirect:/";
    }
}