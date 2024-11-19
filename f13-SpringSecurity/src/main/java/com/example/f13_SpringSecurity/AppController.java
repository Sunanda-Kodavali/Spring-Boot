package com.example.f13_SpringSecurity;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin() {
        return "admin";
    }

    @GetMapping("/secure")
    public String secure(@AuthenticationPrincipal User principal, Model model) {
        System.out.println(principal.getUsername()+"and"+principal.getAuthorities());
        return "secure";
    }

}
