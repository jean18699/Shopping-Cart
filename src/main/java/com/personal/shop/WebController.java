package com.personal.shop;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.personal.shop.user.LoginForm;
import com.personal.shop.user.User;
import com.personal.shop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // redirect to index page if the url doesn't exist
        registry.addRedirectViewController("/*","/");
     }

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("title","Web Shopping");
        return "index";
    }

    @GetMapping("/login")
    public String showLogin(LoginForm form){
//        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }


    @PostMapping("/login")
    //first parameters is the form to validate. 2nd parameter is the result of the validation
    public String login(@Valid LoginForm form, BindingResult result, Model model){

        if(result.hasErrors()){
           return "login";
        }else
        {
            if(model.getAttribute("title") != null){
                model.addAttribute("title", form.getUsername());
            }
            return "redirect:/";
        }
    }

}
