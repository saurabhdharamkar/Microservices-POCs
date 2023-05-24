package com.javatechie.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.redis.entity.Product;
import com.javatechie.redis.respository.ProductDao;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	
    @Autowired
    private ProductDao dao;

    @PostMapping("/addProduct")
    public Product save(@RequestBody Product product) {
        return dao.save(product);
    }
    
    @PostMapping("/updateProduct/{id}")
    @CachePut(key = "#id",cacheNames  = "Product")
    public Product save(@RequestBody Product product ,@PathVariable int id) {
    	product.setId(id);
        return dao.save(product);
    }

    @GetMapping("/getAllProducts")
    public List<?> getAllProducts() {
        return dao.findAll();
    }

    @GetMapping("/{id}")
    @Cacheable(key = "#id",cacheNames  = "Product")
    public Product findProduct(@PathVariable int id) {
        return dao.findProductById(id);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(key = "#id",cacheNames = "Product")
    public String remove(@PathVariable int id) {
        return dao.deleteProduct(id);
    }



}
