package com.personal.shop;

import com.personal.shop.user.Role;
import com.personal.shop.user.User;
import com.personal.shop.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ShoppingCartApplication implements CommandLineRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(ShoppingCartApplication.class, args);

        String adminUser = applicationContext.getEnvironment().getProperty("adminuser");
        String adminPassword = applicationContext.getEnvironment().getProperty("adminpassword");
        User admin = new User(adminUser,adminPassword,"Administrator");
        admin.setRole(Role.ADMIN);

        //Adding app shop admin user
        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        userRepository.save(admin);

    }

    // this method is executed when the app starts
    @Override
    public void run(String... args) throws Exception {

    }
}
