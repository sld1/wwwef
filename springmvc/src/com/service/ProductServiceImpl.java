package com.service;

import com.dao.ProductDaoImpl;
import com.entity.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductDaoImpl dao;

    @Override
    public void deleteAllPro(List<Integer> idlist) {
        dao.deleteAllPro(idlist);
    }

    @Override
    public void addPro(Product pro) {
    dao.addPro(pro);
    }

    @Override
    public void updatePro(Product pro) {
    dao.updatePro(pro);
    }

    @Override
    public void deletePro(int id) {
    dao.deletePro(id);
    }

    @Override
    public Product findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return dao.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return dao.findAll();
    }
}
