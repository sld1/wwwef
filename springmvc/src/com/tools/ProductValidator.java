package com.tools;

import com.entity.Product;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by Administrator on 2019/3/18.
 * ProductValidator产品验证器
 */
public class ProductValidator implements Validator{
    //对实体类的验证支持
    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }
    //具体验证的方法
    @Override
    public void validate(Object o, Errors errors) {
        //将验证目标转换成自定义的类型
        Product product=(Product)o;
        //验证
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","not EmptyOrWhitespace","不能为空或空格");
        //判断价格
        if(product.getPrice()<0){
            errors.rejectValue("price","product.price.gezero","产品价格不能小于零");
        }
        //判断产品类型必选
        if(product.getProductType().getId()==0){
            errors.rejectValue("productType.id","required","必须选择类型");
        }
    }
}
