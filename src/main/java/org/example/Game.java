package org.example;

// - Game: id, title, price
public class Game {
    private int id;
    private String title;
    private float price;

    public Game(int id, String title, float price){
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public float getPrice(){
        return this.price;
    }

    public void setPrice(float newPrice){
        this.price = newPrice;
    }

    // Returns the game's ID, title, and cost.
    public String toString(){
        return String.format("%d: %s - $%.2f", this.id, this.title, this.price);
    }
}
