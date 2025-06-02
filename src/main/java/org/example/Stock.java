package org.example;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Stock {
    private Game[] gameStock;

    public Stock(){
        this.gameStock = new Game[]{
                new Game(1, "Celeste", 25.99f),
                new Game(2, "Terraria", 12.99f),
                new Game(3, "Rimworld", 39.99f),
                new Game(4, "A Hat in Time", 38.99f),
                new Game(5, "Monster Hunter: Rise", 49.99f),
                new Game(6, "Deep Rock Galactic", 34.99f),
                new Game(7, "Satisfactory", 51.99f),
                new Game(8, "Hades", 32.50f),
                new Game(9, "TUNIC", 38.99f),
                new Game(10, "DOOM", 24.99f)
        };
    }
    public Stock(Game[] gameStock){
        this.gameStock = gameStock;
    }

    public Game[] getGameStock(){
        return this.gameStock;
    }

    public Game getGameByID(int id){
        for (int i = 0; i < this.gameStock.length; i++) {
            if (this.gameStock[i].getId() == id){
                return this.gameStock[i];
            }
        }

        System.out.println("ERR: Game ID not found.");
        return null;
    }
    // Returns a set of games based on a search query.
    public Game[] searchGamesByName(String searchQuery){
        ArrayList<Game> searchResults = new ArrayList<>();
        Pattern pattern = Pattern.compile(searchQuery, Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        for (int i = 0; i < this.gameStock.length; i++) {
            matcher = pattern.matcher(this.gameStock[i].getTitle());
            if (matcher.find()){
                searchResults.add(this.gameStock[i]);
            }
        }

        Game[] searchArray = new Game[searchResults.size()];
        return searchResults.toArray(searchArray);
    }

    public void setGamePrice(int id, float gamePrice){
        for (int i = 0; i < this.gameStock.length; i++) {
            if (this.gameStock[i].getId() == id){
                this.gameStock[i].setPrice(gamePrice);
                System.out.println("Price set.");
                return;
            }
        }

        System.out.println("ERR: Game ID not found.");
    }

    // Returns the full list of games in stock
    public String toString(){
        String returnString = "Stock: \n";
        for (int i = 0; i < this.gameStock.length; i++) {
            returnString += this.gameStock[i] + "\n";
        }
        return returnString;
    }
}
