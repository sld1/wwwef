package com.dao;

import com.entity.Product;

import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
public interface ProductDao {
    //添加  修改  删除  findAll findById findByName
    void addPro(Product pro);
    void updatePro(Product pro);
    void deletePro(int id);
    void deleteAllPro(List<Integer> idlist);

    Product findById(int id);
    List<Product> findByName(String name);
    List<Product> findAll();
}
