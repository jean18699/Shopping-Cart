package com.personal.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.shop.user.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title","Web Shopping");

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public void login(@ModelAttribute User user){
        System.out.println(user.getUsername());
    }

}
