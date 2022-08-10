package com.personal.shop.security;

import com.personal.shop.user.LoginForm;
import com.personal.shop.user.UserRepository;
import com.personal.shop.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DataSource dataSource; // datasource dependency that takes the config values made in application.properties

    @Value("select * from users inner join user_roles on users.username = user_roles.role_name")
    private String userQuery;

    //@Autowired
   // private BCryptPasswordEncoder encoder;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        // authentication manager

        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select u.username, u.password from users u where u.username =?")
                .authoritiesByUsernameQuery("select users.username, user_roles.role_name from users inner join user_roles on users.username = user_roles.role_name");


    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // Path authorization config
                .csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/login", "/cart","/register").permitAll() // permitAll allows to access the urls indicated in antmatchers freely
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated() // anyRequest is about the other urls, which must be authenticated
                    .and()// another config

                // Login config
                .formLogin()
                    .loginPage("/login").permitAll() // login page. Everyone can access it. If user logs it redirects to the previous page that needed auth
                    .defaultSuccessUrl("/")
                    .loginProcessingUrl("/login")
                    //.failureUrl("/login?error=true")
                    .and()

                // Logout config
                .logout()
                    .logoutSuccessUrl("/login?logout=true")
                    .deleteCookies("JSESSIONID")
                    .permitAll();


    }



    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }



}
