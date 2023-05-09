package com.example.shopping.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Product {
    public Long id;
    public String name;
    public String itemId;
    public String categories;
}