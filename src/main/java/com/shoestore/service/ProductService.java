package com.shoestore.service;

import com.shoestore.model.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductService {
    private final List<Product> products;

    public ProductService() {
        List<Product> list = new ArrayList<>();
        list.add(new Product("S001", "Classic Runner", "Comfortable running shoe for daily wear.", "Shoes", 79.99, "https://via.placeholder.com/500x320?text=Classic+Runner"));
        list.add(new Product("S002", "Leather Loafer", "Stylish leather loafers with padded sole.", "Shoes", 109.99, "https://via.placeholder.com/500x320?text=Leather+Loafer"));
        list.add(new Product("F001", "Arch Support Insole", "High quality insole for arch support and comfort.", "Footwear", 24.99, "https://via.placeholder.com/500x320?text=Insole"));
        list.add(new Product("F002", "Breathable Socks", "Soft socks made for everyday comfort.", "Footwear", 14.99, "https://via.placeholder.com/500x320?text=Socks"));
        list.add(new Product("S003", "Trail Hiker", "Durable hiking shoe for rugged terrain.", "Shoes", 129.99, "https://via.placeholder.com/500x320?text=Trail+Hiker"));
        this.products = Collections.unmodifiableList(list);
    }

    public List<Product> getAllProducts() {
        return products;
    }
}
