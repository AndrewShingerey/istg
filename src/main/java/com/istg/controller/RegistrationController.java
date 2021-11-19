package com.istg.controller;

import com.istg.domain.User;
import com.istg.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String registration(){
        return "registration";
    }

    @PostMapping("/addnewuser")
    public String registration(@RequestParam(name = "username")String username,
                               @RequestParam(name = "name_user")String name_user,
                               @RequestParam(name = "soname_user")String soname_user,
                               @RequestParam(name = "email")String email,
                               @RequestParam(name = "password")String password){
        User user = new User();
        user.setUsername(username);
        user.setSoname(soname_user);
        user.setName(name_user);
        user.setEmail(email);
        user.setPassword(password);

        userService.save(user);


    return "redirect:/login";
    }

}
