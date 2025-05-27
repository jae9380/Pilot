package com.step3.problem09.repository;

import com.step3.problem09.entity.order.Order;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrderList {
    private Queue<Order> q;

    public OrderList() {
        this.q = new LinkedList<>();
    }

    public void save(Order order) {
        q.add(order);
    }

    public List<Order> getOrderList() {
        return q.stream().toList();
    }

}
