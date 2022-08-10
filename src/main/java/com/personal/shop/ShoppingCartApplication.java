package com.personal.shop;

import com.personal.shop.role.Role;
import com.personal.shop.role.RoleRepository;
import com.personal.shop.role.RoleService;
import com.personal.shop.user.User;
import com.personal.shop.user.UserRepository;
import com.personal.shop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ShoppingCartApplication{



    public static void main(String[] args) {
       ApplicationContext context = SpringApplication.run(ShoppingCartApplication.class, args);

        User admin = new User("admin", "admin","Administrator");
        Set<Role> roles = new HashSet<>();
        roles.add(new Role("ADMIN"));
        admin.setRole(roles);

        UserService userService = (UserService) context.getBean("userService");
        RoleService roleService = (RoleService) context.getBean("roleService");

        roleService.addRole("admin"); roleService.addRole("user");

        userService.addUser(admin);


    }


}
