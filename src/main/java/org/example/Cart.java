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
        Game[] cartArray = new Game[this.cartItems.size()];
        return this.cartItems.toArray(cartArray);
    }
    public float getTotalCost(){
        return this.totalCost;
    }

    public void addCartItem(Game item){
        this.cartItems.add(item);
        calcTotalCost();
        System.out.println(item.getTitle() + " added to cart.");
    }
    public void removeCartItemByID(int id){
        for (int i = 0; i < this.cartItems.size(); i++) {
            if (this.cartItems.get(i).getId() == id){
                String title = this.cartItems.get(i).getTitle();
                this.cartItems.remove(i);
                calcTotalCost();
                System.out.println(title + " removed from cart.");
                return;
            }
        }
        System.out.println("ERR: Game not found.");
    }
    public void clearCart(){
        this.cartItems.clear();
        this.totalCost = 0.00f;
        System.out.println("Cart cleared.");
    }

    private void calcTotalCost(){
        this.totalCost = 0.00f;
        for (int i = 0; i < this.cartItems.size(); i++) {
            this.totalCost += this.cartItems.get(i).getPrice();
        }
    }

    public String toString(){
        String returnString = "Cart: \n";
        for (int i = 0; i < this.cartItems.size(); i++) {
            returnString += this.cartItems.get(i).toString() + "\n";
        }
        returnString += "Total: $" + this.totalCost;
        return returnString;
    }
}
