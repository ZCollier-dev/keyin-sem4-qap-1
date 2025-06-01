package org.example;

// - Order: games array, totalcost (typically an entry into a db)
public class Order {
    private Game[] orderItems;
    private float totalCost;

    public Order(Cart cart, float taxRate){
        this.orderItems = cart.getCartItemsAsArray();
        this.totalCost = cart.getTotalCost() * (1 + taxRate);
    }

    public Game[] getOrderItems(){
        return orderItems;
    }
    public float getTotalCost(){
        return this.totalCost;
    }

    /* display order info (orders are unchanging) (part of purchase processing, test case)*/
}
