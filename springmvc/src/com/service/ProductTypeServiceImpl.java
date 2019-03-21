package com.service;

import com.dao.ProductTypeDaoImpl;
import com.entity.ProductType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {
    @Resource
    ProductTypeDaoImpl typeDao;
    @Override
    public void addPro(ProductType pro) {
        typeDao.addPro(pro);
    }

    @Override
    public void updatePro(ProductType pro) {
    typeDao.updatePro(pro);
    }

    @Override
    public void deletePro(int id) {
    typeDao.deletePro(id);
    }

    @Override
    public ProductType findById(int id) {
        return typeDao.findById(id);
    }

    @Override
    public List<ProductType> findAll() {
        return typeDao.findAll();
    }
}
