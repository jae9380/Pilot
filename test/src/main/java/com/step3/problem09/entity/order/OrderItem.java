package com.step3.problem09.entity.order;

import com.step3.problem09.entity.menu.Menu;

public class OrderItem {
    private Menu menu;
    private int quantity;

    public OrderItem(Menu menu, int quantity) {
        this.menu = menu;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }
}
