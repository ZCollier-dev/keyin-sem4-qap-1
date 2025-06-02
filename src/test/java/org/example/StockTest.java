package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// search by name and id
// change stock game price
public class StockTest {

    Game[] testGames = new Game[]{
            new Game(1, "Game A", 12.34f),
            new Game(2, "G4me B", 56.78f),
            new Game(3, "Game C", 90.12f)
    };
    Stock testStock = new Stock(testGames);
    float testPrice = 12.34f;
    int testId = 3;

    @Test
    // Tests whether the custom stock is initialized properly.
    void testCustomStockInitialized(){
        Assertions.assertEquals(3, testStock.getGameStock().length);
        Assertions.assertArrayEquals(testGames, testStock.getGameStock());
    }

    @Test
    // Tests whether the getGameByID method returns the correct game.
    void testSearchByID(){
        Game testGame = testStock.getGameByID(testId);
        Assertions.assertEquals(testId, testGame.getId());
    }

    @Test
    // Tests whether the searchGamesByName method returns the correct items in the array, both single- and multi-game results.
    void testSearchByName(){
        Game[] testSingleGame = testStock.searchGamesByName("b");
        Game[] testMultiGame = testStock.searchGamesByName("game");

        Assertions.assertEquals(1, testSingleGame.length);
        Assertions.assertNotEquals(testSingleGame[0], testGames[0]);
        Assertions.assertEquals(2, testMultiGame.length);
        Assertions.assertArrayEquals(new Game[]{testGames[0], testGames[2]}, testMultiGame);
    }

    @Test
    // Tests whether using the setGamePrice method successfully updates the price in the stock.
    void testSetGamePrice(){
        testStock.setGamePrice(testId, testPrice);
        Assertions.assertEquals(testPrice, testStock.getGameByID(testId).getPrice());
    }
}
