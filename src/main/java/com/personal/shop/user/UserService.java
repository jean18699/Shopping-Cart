package com.personal.shop.user;

import org.springframework.beans.factory.annotation.Autowired;
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

}
