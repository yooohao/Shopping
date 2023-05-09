package com.example.shopping.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopping.domain.Product;
import com.example.shopping.domain.vo.TimesVo;
import com.example.shopping.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class  ProductServiceImpl {

    @Resource
    private ProductMapper productMapper;

    public void insertProduct(Product product) {
        productMapper.insert(product);
    }

    public void deleteProduct(Long id) {
        productMapper.deleteById(id);
    }

    public void update(Product product) {
        productMapper.updateById(product);
    }

    public Product select(Long id) {
        return productMapper.selectById(id);
    }

    public List<Product> selectList(Product product) {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("brand", product.getBrand());
        return productMapper.selectList(queryWrapper);
    }

    public List<Product> selectByTimes(TimesVo timesVo) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = sdf.parse(timesVo.getStartTime());
        Date end = sdf.parse(timesVo.getEndTime());
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("create_time", start).lt("create_time", end);
        return productMapper.selectList(queryWrapper);
    }

    public List<String> selectBrands() {
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        queryWrapper.groupBy("brand");
        List<Product> products = productMapper.selectList(queryWrapper);
        return products.stream().map(Product::getBrand).collect(Collectors.toList());
    }
}
