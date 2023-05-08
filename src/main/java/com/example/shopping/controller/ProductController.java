package com.example.shopping.controller;

import com.example.shopping.domain.Product;
import com.example.shopping.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductServiceImpl service;

    @PostMapping
    public void insert(@RequestBody Product product) {
        service.insertProduct(product);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.deleteProduct(id);
    }

    @PutMapping
    public void update(@RequestBody Product product){
        service.update(product);
    }

    @GetMapping
    public Product select(Long id){
        return service.select(id);
    }

    @GetMapping("/list")
    public List<Product> selectList(Product product){
        return service.selectList(product);
    }

}
