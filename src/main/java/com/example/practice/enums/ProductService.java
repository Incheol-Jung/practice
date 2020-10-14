package com.example.practice.enums;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Incheol Jung
 */
@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public void save(){
        Product product = new Product();
        product.setName("flower pattern dress");
        product.setCategory(Category.DRESS);
        productRepository.save(product);
    }

    public Product get(int id) {
        return productRepository.findById(id).get();
    }
}
