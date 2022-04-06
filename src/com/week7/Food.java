package com.week7;

public class Food {
    private int id;
    private String name;
    private String type;
    private int size;
    private double price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void getMenu() {
        System.out.printf("[id] %d \t[type] %s \t[name] %s  \t[size] %2d(Inches) \t[price] %.2f $ \n", id, type, name, size, price);
    }
}
