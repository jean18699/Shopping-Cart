package com.personal.shop.user;

import com.personal.shop.cart.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String name;

    @OneToOne
    private ShoppingCart shoppingCart;

}
