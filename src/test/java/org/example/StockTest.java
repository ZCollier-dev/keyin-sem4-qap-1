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
    void testCustomStockSize(){
        Assertions.assertEquals(3, testStock.getGameStock().length);
    }

    @Test
    void testSearchByID(){
        Game testGame = testStock.getGameByID(testId);
        Assertions.assertEquals(testId, testGame.getId());
    }

    @Test
    void testSearchByName(){
        Game[] testSingleGame = testStock.searchGamesByName("b");
        Game[] testMultiGame = testStock.searchGamesByName("game");
        Assertions.assertEquals(1, testSingleGame.length);
        Assertions.assertEquals(2, testMultiGame.length);
        Assertions.assertArrayEquals(new Game[]{testGames[0], testGames[2]}, testMultiGame);
    }

    @Test
    void testSetGamePrice(){
        testStock.setGamePrice(testId, testPrice);
        Assertions.assertEquals(testPrice, testStock.getGameByID(testId).getPrice());
    }

}
