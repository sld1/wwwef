package com.dao;

import com.entity.ProductType;

import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
public interface ProductTypeDao {
    void addPro(ProductType pro);
    void updatePro(ProductType pro);
    void deletePro(int id);

    ProductType findById(int id);
    List<ProductType> findAll();
}
