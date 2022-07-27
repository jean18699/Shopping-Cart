package com.personal.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
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
    public String registerNewUser(@Valid RegisterForm registerForm, BindingResult result){

        System.out.println(userService.getUserByUsername(registerForm.getUsername()).getUsername());
        if(result.hasErrors()){
            return "redirect:/register";
        }else
        {
            User newUser = new User(registerForm.getUsername(), registerForm.getPassword(), registerForm.getName());

            if(userService.getUserByUsername(newUser.getUsername()) == null){
                //userService.addUser(newUser);
                return "redirect:/login";
            }else
            {
                System.out.println("exists");
                return "redirect:/register?exists";
            }

        }
    }






}
