package com.step3.problem09.entity.menu;

public class Coffee extends Menu{
    private String beenType;
    private String size;
    public Coffee(String name, int price, String beentype, String size) {
        super(name, price);
        this.beenType = beentype;
        this.size = size;
    }
    public Coffee(String... str) {
        super(str[0], Integer.parseInt(str[1]));
        this.beenType = str[2];
        this.size = str[3];
    }
    @Override
    public void getDetails() {
        System.out.printf("[COFFEE] %1$s %2$d원 %3$s 원두 %4$s 사이즈 \n", getName(), getPrice(),beenType, size );
    }

    @Override
    public int amountInfo(int count, int quantity) {
        System.out.printf("%1$d. %2$s 커피 %3$s 사이즈 %4$d잔 \t %5$,d원\n", count, getName(), size, quantity, getPrice()*quantity);
        return getPrice()*quantity;
    }

}
