package com.personal.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Set;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product addProduct(Product product){
        if(!productRepository.existsById(product.getId())){
            productRepository.save(product);
            return product;
        }
        return null;
    }


}
