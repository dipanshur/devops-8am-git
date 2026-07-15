package com.shoestore.model;

public class Product {
    private final String id;
    private final String name;
    private final String description;
    private final String category;
    private final double price;
    private final String imageUrl;

    public Product(String id, String name, String description, String category, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}

