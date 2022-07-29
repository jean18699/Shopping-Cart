package com.personal.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User addUser(User newUser){
        encodePassword(newUser);
        userRepository.save(newUser);
        return newUser;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }
  /*  public User getUserByUsername(String username){
        return userRepository.findUserByUsername(username).orElseThrow(()-> new UserNotFoundException("This user was not found"));
    }
*/

    public boolean isExistingUser(User user){
        return userRepository.existsById(user.getUsername());
    }


    private Object encodePassword(User user){
       return null;
        // user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

}
