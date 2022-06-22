package com.personal.shop.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping(value = "/products/newProduct", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(@RequestBody Product product){
        System.out.println(product.getDescription());
       productService.addProduct(product);
    }

    @GetMapping("/products/list")
    @ResponseBody
    public List<Product> getProducts(){
        return productService.getProducts();
    }

}
