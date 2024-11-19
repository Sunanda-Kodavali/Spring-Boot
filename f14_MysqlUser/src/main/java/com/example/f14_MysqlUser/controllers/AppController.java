package com.example.f14_MysqlUser.controllers;

import com.example.f14_MysqlUser.models.UserAccount;
import com.example.f14_MysqlUser.repositories.UserAccountRepository;
import com.example.f14_MysqlUser.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String index(Model model) {

//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPass1 = encoder.encode("12345678");
//        String encodedPass2 = encoder.encode("12345678");
//        System.out.println(encodedPass1);
//        System.out.println(encodedPass2);
//        System.out.println(encoder.matches("12345678", encodedPass2));
//        System.out.println(encoder.matches("12345679]", encodedPass2));

        UserAccount userAccount = new UserAccount();
        userAccount.setId(123L);
        userAccount.setUsername("LALALALALA");
        userAccount.setPassword("yoyoyo");

        model.addAttribute("user", userAccount);

        return "index";
    }

    @GetMapping("/register")
    public String register() {

        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@ModelAttribute UserAccount userAccount) {

        customUserDetailsService.createUserAccount(
                userAccount.getUsername(),
                userAccount.getPassword()
        );

        return "redirect:/register";
    }


    // 1 - First recreate this behaviour in a new App
    // 2 - Abuse the app and try to break it as a User
    // 3 - Create a way to delete users (probably by listing user first)
    // 4 - Allow to change the user password
    // 5 - Try to add roles to users, 1 role per user, can be a new varchar column in MySQL

}