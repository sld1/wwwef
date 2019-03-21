package com.entity;

/**
 * Created by Administrator on 2019/3/16.
 */
public class Product {
    private int id;
    private String name;
    private Double price;
    private ProductType productType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public Product(int id, String name, Double price, ProductType productType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", productType=" + productType +
                '}';
    }
}
