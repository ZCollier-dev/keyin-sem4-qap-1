package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OrderDBTest {
    Cart testCart = new Cart();
    Game[] testGames = new Game[]{
            new Game(1, "Game A", 12.34f),
            new Game(2, "G4me B", 56.78f),
            new Game(3, "Game C", 90.12f)
    };
    Order testOrder;
    OrderDB testDB = new OrderDB();
    float taxRate = 0.15f;

    @BeforeEach
    void setUp(){
        testCart = new Cart();
        for (int i = 0; i < testGames.length; i++) {
            testCart.addCartItem(testGames[i]);
        }
        testOrder = new Order(testCart, taxRate);
    }

    @Test
    void testAddOrder(){
        testDB.addOrder(testOrder);
        Assertions.assertEquals(1, testDB.getOrders().length);
    }
}
