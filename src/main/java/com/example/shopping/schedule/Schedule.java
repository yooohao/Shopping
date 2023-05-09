package com.example.shopping.schedule;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.shopping.domain.Product;
import com.example.shopping.mapper.ProductMapper;
import org.apache.tomcat.util.security.Escape;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Configuration
@EnableScheduling
public class Schedule {

    @Resource
    private ProductMapper productMapper;

    @Scheduled(cron = "0/5 * * * * ?")
    //或直接指定时间间隔，例如：5秒
    private void saleCheck() {
        //查询是否开始打折
        //查询是否超过打折时间
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();  //查询方法
        List<Product> products = productMapper.selectList(queryWrapper);
        for (Product product : products) {
            String saleInfo = product.getSaleInfo();
            if (saleInfo != null) {
                JSONArray objects = JSONArray.parseArray(saleInfo);
                for (int i = 0; i < objects.size(); i++) {
                    JSONObject json = (JSONObject) objects.get(i);
                    Double sale = json.getDouble("sale");
                    Date time = json.getDate("time");
                    if (i == 0) {
                        if (new Date().compareTo(time) > 0){
                            product.setSale(sale);
                        }
                    } else if (i == 1) {
                        if (new Date().compareTo(time) > 0){
                            product.setSale(sale);
                        }
                    } else {
                        if (new Date().compareTo(time) > 0) {
                            product.setSale(null);
                            product.setSaleInfo(null);
                        }
                    }
                }
                productMapper.updateById(product);
            }
        }
    }
}
