package com.personal.shop;

import com.personal.shop.user.User;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class ShoppingCartApplicationTests {



    @Test
    void contextLoads() {

    }

    @Test
    void testAssertion(){
        Assert.hasText("abc","abc");
    }



}
