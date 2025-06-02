package org.example;

import java.util.ArrayList;

// - OrderDB: Order arrayList (would be an actual db)
public class OrderDB {
    private ArrayList<Order> orders;
    int nextID;

    public OrderDB(){
        this.orders = new ArrayList<>();
        this.nextID = 0;
    }

    public void addOrder(Order order){
        order.setID(nextID);
        ++nextID;
        orders.add(order);
        System.out.println("Order processed.");
    }

    public Order[] getOrders(){
        Order[] orderArray = new Order[this.orders.size()];
        return this.orders.toArray(orderArray);
    }

    public String toString(){
        String returnString = "\nOrder DB: \n\n";
        for (int i = 0; i < orders.size(); i++) {
            returnString += orders.get(i).toString() + "\n----------\n";
        }
        return returnString;
    }
}
