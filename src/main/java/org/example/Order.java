package org.example;

public class Order {
    private Game[] orderItems;
    private float totalCost;
    private int id;

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

    // Used only for OrderDB
    public void setID(int id){
        this.id = id;
    }

    // Returns the order's games as well as its total cost, after taxes.
    public String toString(){
        String returnString = "Order " + id + ": \n";
        for (int i = 0; i < this.orderItems.length; i++) {
            returnString += this.orderItems[i].toString() + "\n";
        }
        returnString += String.format("Total: $%.2f", this.totalCost);
        return returnString;
    }
}
