package com.example.shopping.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopping.domain.Product;
import com.example.shopping.domain.vo.TimesVo;
import com.example.shopping.mapper.ProductMapper;
import com.example.shopping.service.impl.ProductServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {    //Controller是与前端交互的类

    @Resource
    private ProductServiceImpl service;
    @Resource
    private ProductMapper productMapper;

    @PostMapping
    public void insert(@RequestBody Product product) {
        service.insertProduct(product);
    }

    @DeleteMapping
    public void delete(Long id) {
        service.deleteProduct(id);
    }

    @PutMapping
    public void update(@RequestBody Product product) {
        service.update(product);
    }

    @GetMapping
    public Product select(Long id) {
        return service.select(id);
    }

    @GetMapping("/list")
    public List<Product> selectList(Product product) {
        return service.selectList(product);
    }

    @GetMapping("/list/times")
    public List<Product> selectByTimes(TimesVo timesVo) throws ParseException {
        return service.selectByTimes(timesVo);
    }

}
