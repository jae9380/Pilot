package com.step03.problem09.entity.order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String customerName;
    private List<OrderItem> order;
    private LocalDateTime orderTime;

    public Order(String customerName, List<OrderItem> order) {
        this.customerName = customerName;
        this.order = order;
        this.orderTime = LocalDateTime.now();
    }
    public Order(String customerName) {
        this.customerName = customerName;
        this.order = new ArrayList<>();
        this.orderTime = LocalDateTime.now();
    }

    public void addOrderItem(OrderItem... items) {
        for (OrderItem item : items) {
            order.add(item);
        }
    }
    public void removeOrderItem(OrderItem... items) {
        for (OrderItem item : items) {
            order.remove(item);
        }
    }

    public String getOrderTime() {
        return orderTime.format(DateTimeFormatter.ofPattern("yyyy년MM월dd일 HH시mm분 ss초"));
    }

    public boolean isOrderEmpty() {
        return order.isEmpty();
    }

    public void showOrderInfo() {
        System.out.println("---------");
        System.out.printf("주문 고객 : %1$s \t\t 주문 시간 : %2$s\n", customerName, getOrderTime());
        int count = 1, totalAmount = 0;
        for (OrderItem orderItem : order) {
            totalAmount += orderItem.getMenu().amountInfo(count++, orderItem.getQuantity());
        }
        System.out.printf("총 주문 금액 : %,d원 \n", totalAmount);
    }
}
