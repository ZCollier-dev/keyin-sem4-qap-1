package org.example;

import java.util.ArrayList;

// - OrderDB: Order arrayList (would be an actual db)
public class OrderDB {
    private ArrayList<Order> orders;

    public OrderDB(){
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order){
        orders.add(order);
        System.out.println("Order processed.");
    }

    public Order[] getOrders(){
        Order[] orderArray = new Order[this.orders.size()];
        return this.orders.toArray(orderArray);
    }

    /* add order. view order list (is also part of purchase processing test case) */
}
