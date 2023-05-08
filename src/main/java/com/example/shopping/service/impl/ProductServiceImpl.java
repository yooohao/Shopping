package com.example.shopping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopping.domain.Product;
import com.example.shopping.mapper.ProductMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductServiceImpl{

    @Resource
    private ProductMapper productMapper;

    public void insertProduct(Product product) {
        productMapper.insert(product);
    }

    public void deleteProduct(Long id) {
        productMapper.deleteById(id);
    }

    public void update(Product product){
        productMapper.updateById(product);
    }

    public Product select(Long id){
        return productMapper.selectById(id);
    }

    public List<Product> selectList(Product product){
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("category",product.getCategory());
        return productMapper.selectList(queryWrapper);
    }
}
