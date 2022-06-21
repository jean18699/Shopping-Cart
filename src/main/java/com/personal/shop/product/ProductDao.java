package com.personal.shop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductDao extends JpaRepository<Product, Long> {

    //@Query("SELECT p FROM Products WHERE LOWER(p.name) = LOWER(:name)")
    //Optional<Product> findByName(@Param("name") String name);

}
