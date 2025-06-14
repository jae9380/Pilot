package com.step03.problem09.entity.menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Sandwich extends Menu{
    private String ingredient;
    private LocalDateTime expirationDateTime;
    public Sandwich(String name, int price, String ingredient, int expiryDate) {
        super(name, price);
        this.ingredient = ingredient;
        this.expirationDateTime = LocalDateTime.now().plusDays(expiryDate);
    }

    public Sandwich(String... str) {
        super(str[0], Integer.parseInt(str[1]));
        this.ingredient = str[2];
        this.expirationDateTime = LocalDateTime.now().plusDays(Integer.parseInt(str[3]));
    }

    @Override
    public void getDetails() {
        System.out.printf("[SANDWICH] %1$s %2$d원 핵심 재료 : %3$s 유통기한 : %4$s \n", getName(), getPrice(),ingredient, expirationDateTime );
    }

    @Override
    public int amountInfo(int count, int quantity) {
        System.out.printf("%1$d. %2$s %3$d개 \t%4$,d원 \n", count, getName(), quantity, getPrice()*quantity);
        return getPrice()*quantity;

    }

    public boolean expirationDateVerification() {
        return LocalDateTime.now().isBefore(expirationDateTime);
    }

    public String getExpirationDateTime() {
        return expirationDateTime.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분 ss초"));
    }
}
