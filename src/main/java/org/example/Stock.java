package org.example;

// - Stock: games array (maybe 10 games standard per stock? bigger arrays possible)
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
                new Game(10, "DOOM (2016)", 24.99f)
        };

    }
    public Stock(Game[] gameStock){
        this.gameStock = gameStock;
    }
}
