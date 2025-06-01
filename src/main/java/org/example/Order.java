package org.example;

// - Order: games array, totalcost (typically an entry into a db)
public class Order {
    private Game[] orderItems;
    private float totalCost;

    public Order(Cart cart){
        this.orderItems = cart.getCartItemsAsArray();
        this.totalCost = cart.getTotalCost();
    }

    /* display order info (orders are unchanging) (part of purchase processing, test case)*/
}
