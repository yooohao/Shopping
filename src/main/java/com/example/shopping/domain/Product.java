package com.example.shopping.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.shopping.domain.common.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @PackageName:Shopping
 * @ClassName: Product
 * Description:
 * @author: ZIHAO
 * @date 2023-05-07 11:45
 */
@Data
@AllArgsConstructor //带所有参数的构造器
@NoArgsConstructor //不带参数的构造器
@TableName("product")
public class Product extends BaseEntity{

    @TableId(value = "id", type = IdType.AUTO)
    public Long id;

    @TableField(value = "name") //@TableField表明数据库中的字段, Mybatis Plus中的特性
    public String name;

    @TableField(value = "item_num")
    public String itemNum;

    @TableField(value = "category")
    public String category;

    @TableField(value = "price")
    public BigDecimal price;

    @TableField(value = "sale_info")
    public String saleInfo;

    @TableField(value = "sale")
    public Double sale;

    @TableField(value = "brand")
    private String brand;
}