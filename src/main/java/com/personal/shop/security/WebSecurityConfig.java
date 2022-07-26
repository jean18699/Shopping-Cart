package com.personal.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager (see below)

        // Creating the admin user
        auth.inMemoryAuthentication().
                withUser("admin")
                    .password("{noop}admin")
                    .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {



        http
                // Path authorization config
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/login", "/cart").permitAll() // permitAll allows to access the urls indicated in antmatchers freely
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated() // anyRequest is about the other urls, which must be authenticated
                    .and()// another config

                // Login config
                .formLogin()
                    .loginPage("/login").permitAll() // login page. Everyone can access it. If user logs it redirects to the previous page that needed auth
                    //.defaultSuccessUrl("/")
                    .loginProcessingUrl("/login")
                    //.failureUrl("/login?error=true")
                    .and()

                // Logout config
                .logout()
                    .logoutSuccessUrl("/login?logout=true")
                    .deleteCookies("JSESSIONID")
                    .permitAll();


    }

   /* @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin")
                        .roles("ADMIN")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }*/

}
