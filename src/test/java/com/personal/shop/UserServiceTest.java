package com.personal.shop;

import com.personal.shop.user.User;
import com.personal.shop.user.UserRepository;
import com.personal.shop.user.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Mock
    List userList;

    @Test
    void contextLoads(){

    }

    @Test
    void mustReturnUserList(){
       userList.add("user 1");
       userList.add("user 2");

       Mockito.when(userRepository.findAll()).thenReturn(userList);

       assertEquals(userList, userService.getUsers());

    }

    @Test
    void mustReturnTrueIfUserExists(){
        User existingUser = new User("existing","test","test user");
        User notExistingUser = new User("notExisting","test","test user that dont exist");

        // Mocking the return of the call of this method. It's true if the param is the username of the existing user
        Mockito.when(userRepository.existsById(existingUser.getUsername())).thenReturn(true);

        //isExistingUser method of userService calls the mocked userRepository.existById, returning the mocked expected result
        assertTrue(userService.isExistingUser(existingUser));

        //The main idea is mocking all the functions that the service method is dependent in order to return its value
        assertFalse(userRepository.existsById(existingUser.getUsername()));

    }

    @Test
    void mustReturnFalseIfUserNotExists(){
        User existingUser = new User("existing","test","test user");
        User notExistingUser = new User("notExisting","test","test user that dont exist");

        Mockito.when(userRepository.existsById(existingUser.getUsername())).thenReturn(true);
        assertFalse(userService.isExistingUser(notExistingUser));

    }

}
