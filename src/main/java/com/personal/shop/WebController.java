package com.personal.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.shop.user.LoginForm;
import com.personal.shop.user.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class WebController {

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("title","Web Shopping");

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm user, Model model){

        System.out.printf(model.getAttribute("user").toString());
        //System.out.println(user.getUsername());
        return "index.html";
    }

}
