package com.controller;

import com.entity.Product;
import com.entity.ProductType;
import com.tools.ProductValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import com.service.ProductServiceImpl;
import com.service.ProductTypeServiceImpl;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Administrator on 2019/3/16.
 */
@Controller
@RequestMapping("/pro")
public class proController {
    @Resource
    ProductServiceImpl ser;
    @Resource
    ProductTypeServiceImpl typeser;
    //全查
    @RequestMapping("/show")
    public String showP(Model model){
        //调用查询所有方法
        List<Product> list = ser.findAll();
        model.addAttribute("list",list);
        return "show";
    }
    //删除
    @RequestMapping("/dele")
    public  String dele(Model model,int id){
        ser.deletePro(id);
        return "redirect:show.do";
    }
    //模糊查询
    @RequestMapping("/mhcha")
    public String mohucha(Model model,String mname){
        List<Product> list = ser.findByName(mname);
        model.addAttribute("list",list);
        return  "show";
    }
    //新增1
    @RequestMapping("/add1")
    public String add1(Model model){
        List<ProductType> prolist = typeser.findAll();
        Product pro=new Product();
        model.addAttribute("prolist",prolist);
        model.addAttribute("pro",pro);
        return "insert";
    }
    //新增2
    @RequestMapping("/add")
    public String addP(Model model, Product pro, BindingResult result){
        //验证
        ProductValidator validator =new ProductValidator();
        validator.validate(pro,result);
        //判断如果验证通过进行添加 否则跳转到添加页面
        if (!result.hasErrors()){
            ser.addPro(pro);
            return "redirect:show.do";
        }
            //类型列表
            List<ProductType> prolist = typeser.findAll();
            //封装一个产品类型列表
            model.addAttribute("prolist",prolist);
            //封装一个产品对象
            model.addAttribute("pro",pro);
            return "insert";

    }
    //修改1
    @RequestMapping("/update1")
    public String update1(Model model,int id){
        Product pro = ser.findById(id);
        model.addAttribute("pro",pro);
        List<ProductType> typelist = typeser.findAll();
        model.addAttribute("typelist",typelist);
        return "update";
    }
    //修改2
    @RequestMapping("/update2")
    public String update2(Model model,Product pro){
        ser.updatePro(pro);
        return "redirect:show.do";
    }
    //批量删除
    @RequestMapping("/deleteAllPro")
    public  String deleteAllPro(Model model,@RequestParam("id") List<Integer> idlist){
        //调用批量删除方法
        /*for (int id:idlist) {
            System.out.println("sssssss"+id);
        }*/
        ser.deleteAllPro(idlist);
        return "redirect:show.do";
    }


}
