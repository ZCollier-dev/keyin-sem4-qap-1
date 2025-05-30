package org.example;

import java.util.ArrayList;

// - Cart: games arraylist, totalcost (changes often)
public class Cart {
    private ArrayList<Game> cartItems;
    private float totalCost;

    public Cart(){
        this.cartItems = new ArrayList<>();
        this.totalCost = 0.00f;
    }

    public Game[] getCartItemsAsArray(){
        Game[] cartArray = new Game[cartItems.size()];
        return cartItems.toArray(cartArray);
    }
    public float getTotalCost(){
        return totalCost;
    }
}
