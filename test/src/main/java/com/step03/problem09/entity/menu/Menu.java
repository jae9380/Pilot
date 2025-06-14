package com.step03.problem09.entity.menu;

public abstract class Menu {
    private String name;
    private int price;
    
    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public abstract void getDetails();

    public abstract int amountInfo(int count, int quantity);
}
