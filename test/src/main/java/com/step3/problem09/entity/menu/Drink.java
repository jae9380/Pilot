package com.step3.problem09.entity.menu;

public class Drink extends Menu{
    private String size;
    public Drink(String name,int price, String size) {
        super(name, price);
        this.size = size;
    }
    public Drink(String... str) {
        super(str[0], Integer.parseInt(str[1]));
        this.size = str[2];
    }

    @Override
    public void getDetails() {
        System.out.printf("[DRINK] %1$s %2$d원 %3$s 사이즈\n", getName(), getPrice(), size );
    }

    @Override
    public int amountInfo(int count, int quantity) {
        System.out.printf("%1$d. %2$s 음료 %3$s 사이즈 %4$d잔 \t %5$,d원\n", count, getName(), size, quantity, getPrice()*quantity);
        return getPrice()*quantity;
    }

}
