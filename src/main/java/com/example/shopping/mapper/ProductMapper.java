package com.example.shopping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.shopping.domain.Product;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ProductMapper extends BaseMapper<Product> {

//    void insert(Product product);
//
//    void delete(Long id);
//
//    void update(Product product);
//
//    Product select(Long id);
//
//    List<Product> selectList(Product product);
}
