package org.example;

// system for cart and stock manipulation
// search functionality
public class StoreProcessingSystem {
    private Cart cart;
    private Stock stock;

    public StoreProcessingSystem(){
        this.cart = new Cart();
        this.stock = new Stock();
    }
    public StoreProcessingSystem(Game[] gameStock){
        this.cart = new Cart();
        this.stock = new Stock(gameStock);
    }
    public StoreProcessingSystem(Stock stock){
        this.cart = new Cart();
        this.stock = stock;
    }
}
