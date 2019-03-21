package com.dao;

import com.entity.ProductType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Repository
public class ProductTypeDaoImpl implements ProductTypeDao{
    @Resource
    JdbcTemplate template;
    @Override
    public void addPro(ProductType pro) {
        //sql
        String sql="INSERT into t_producttype(name) value(?)";
        Object[] args={pro.getName()};
        //执行
        int update = template.update(sql, args);
        System.out.println("addPro return :"+ update);
    }

    @Override
    public void updatePro(ProductType pro) {
        //sql
        String sql="update t_producttype set name=?  where id=? ";
        Object[] args={pro.getName(),pro.getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("updatePro return :"+ update);
    }

    @Override
    public void deletePro(int id) {
        //sql
        String sql="delete from t_producttype where id = ? ";
        Object[] args={id};
        //执行
        int update = template.update(sql, args);
        System.out.println("deletePro return :"+ update);
    }

    @Override
    public ProductType findById(int id) {
        //sql
        String sql="select * from t_producttype where id =? ";
        Object[] args={id};
        //rowMapper
        RowMapper<ProductType> rowMapper=new RowMapper<ProductType>() {
            @Override
            public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductType pro=new ProductType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return pro;
            }
        };
        //执行
        ProductType productTypeEntity = template.queryForObject(sql, args, rowMapper);
        return productTypeEntity;
    }

    @Override
    public List<ProductType> findAll() {
        //sql
        String sql="select * from t_producttype ";
        //rowMapper
        RowMapper<ProductType> rowMapper=new RowMapper<ProductType>() {
            @Override
            public ProductType mapRow(ResultSet resultSet, int i) throws SQLException {
                ProductType pro=new ProductType(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );
                return pro;
            }
        };
        //执行
        List<ProductType> list = template.query(sql, rowMapper);
        return list;
    }
}
