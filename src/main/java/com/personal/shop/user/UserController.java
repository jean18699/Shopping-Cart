package com.personal.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/users")
    @ResponseBody
    public List<User> getUserList(){
        return userService.getUsers();
    }

    @GetMapping("/register")
    public String showRegisterPager(RegisterForm registerForm){
        return "register";
    }


    @PostMapping("/register")
    public String registerNewUser(@Valid RegisterForm registerForm, BindingResult result,  Model model){
        System.out.println(userService.getUsers().size());

        if(!result.hasErrors()){
            User newUser = new User(registerForm.getUsername(), registerForm.getPassword(), registerForm.getName());

            if (userService.isExistingUser(newUser)) {
                model.addAttribute("userExists",true);
            }else
            {
                userService.addUser(newUser);
                model.addAttribute("userExists",false);
                return "redirect:/login";
            }
        }
        return "register";
    }






}