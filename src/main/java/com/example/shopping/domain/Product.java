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
@AllArgsConstructor
@NoArgsConstructor
@TableName("product")
public class Product extends BaseEntity {

    @TableId(value = "id", type = IdType.AUTO)
    public Long id;

    @TableField(value = "name")
    public String name;

    @TableField(value = "item_num")
    public String itemNum;

    @TableField(value = "category")
    public String category;

    @TableField(value = "price")
    public BigDecimal price;

    @TableField(value = "brand")
    private String brand;
}