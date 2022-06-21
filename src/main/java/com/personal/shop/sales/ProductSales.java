package com.personal.shop.sales;

import com.personal.shop.product.Product;
import com.personal.shop.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity
public class ProductSales {

    @Id
    private long id;
    private LocalDateTime saleDate;

    @ManyToOne
    private User user;

    @ManyToMany
    private Set<Product> products;

}
