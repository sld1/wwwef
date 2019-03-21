package com.dao;

import com.entity.Product;
import com.entity.ProductType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Repository
public class ProductDaoImpl implements ProductDao{
    @Resource
    JdbcTemplate template;
    @Resource
    ProductTypeDaoImpl typeDao;

    @Override
    public void deleteAllPro(List<Integer> idlist) {
        //sql
        String sql="delete from t_product where id = ?";
        //创建一个存放id参数值的集合
        List<Object[]> objlist=new ArrayList<>();
        for(int id:idlist){
            //参数数组
            Object[] args={id};
            objlist.add(args);
        }
        //调用批量删除的方法
        template.batchUpdate(sql,objlist);
    }

    @Override
    public void addPro(Product pro) {
        //sql
        String sql="INSERT into t_product(name,price,pid) value(?,?,?)";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("addPro return :"+ update);
    }

    @Override
    public void updatePro(Product pro) {
        //sql
        String sql="update t_product set name=?,price=?,pid=? where id=?";
        Object[] args={pro.getName(),pro.getPrice(),pro.getProductType().getId(),pro.getId()};
        //执行
        int update = template.update(sql, args);
        System.out.println("updatePro return :"+ update);
    }

    @Override
    public void deletePro(int id) {
        //sql
        String sql="delete from t_product where id = ?";
        Object[] args={id};
        //执行
        int update = template.update(sql, args);
        System.out.println("deletePro return :"+ update);
    }

    @Override
    public Product findById(int id) {
        //sql
        String sql="select * from t_product where id = ? ";
        Object[] args={id};
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        Product product = template.queryForObject(sql, args, rowMapper);
        return product;
    }

    @Override
    public List<Product> findByName(String name) {
        //sql
        String sql="select * from t_product where name like ? ";
        Object[] args={"%"+name+"%"};
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        List<Product>  list = template.query(sql, args, rowMapper);
        return list;
    }

    @Override
    public List<Product> findAll() {
        //sql
        String sql="select * from t_product ";
        //将查询数据封装到对象
        RowMapper<Product> rowMapper=new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet resultSet, int i) throws SQLException {
                Product pro=new Product();
                pro.setId(resultSet.getInt("id"));
                pro.setName(resultSet.getString("name"));
                pro.setPrice(resultSet.getDouble("price"));
                //获取类型Id
                int pid=resultSet.getInt("pid");
                //获取类型对象
                ProductType byId = typeDao.findById(pid);
                pro.setProductType(byId);
                return pro;
            }
        };
        //执行查询
        List<Product>  list = template.query(sql, rowMapper);
        return list;
    }
}
