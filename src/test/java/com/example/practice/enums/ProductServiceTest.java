package com.example.practice.enums;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Incheol Jung
 */
@SpringBootTest
class ProductServiceTest {
    @Autowired
    ProductService productService;

    @Test
    public void save(){
        productService.save();
    }
}
