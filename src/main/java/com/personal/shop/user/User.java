package com.personal.shop.user;

import com.personal.shop.cart.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="shopping_cart_id")
    private ShoppingCart shoppingCart;

    public User(String username, String password, String name){
        this.username = username;
        this.password = password;
        this.name = name;
        this.shoppingCart = new ShoppingCart();
    }

}
