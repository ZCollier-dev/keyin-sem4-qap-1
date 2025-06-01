package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartTest {

    // validate game addition/removal/clear
    // cart total calc (maybe with tax?)
    // create order as part of purchase processing

    Stock standardStock = new Stock();
    Game testGame = new Game(12, "TestGame", 12.34f);
    int[] testIDs = new int[]{1,4,6};
    Cart testCart;

    @BeforeEach
    void setUp(){
        testCart = new Cart();
        for (int i = 0; i < testIDs.length; i++) {
            testCart.addCartItem(standardStock.getGameByID(testIDs[i]));
        }
    }

    @Test
    void testAddCartItems(){
        Assertions.assertEquals(3, testCart.getCartItemsAsArray().length);
    }

    @Test
    void testRemoveCartItems(){
        testCart.removeCartItemByID(testIDs[1]);
        Assertions.assertEquals(2, testCart.getCartItemsAsArray().length);
        Assertions.assertEquals(testIDs[0], testCart.getCartItemsAsArray()[0].getId());
        Assertions.assertNotEquals(testIDs[1], testCart.getCartItemsAsArray()[1].getId());
    }

    @Test
    void testClearCartItems(){
        testCart.clearCart();
        Assertions.assertEquals(0, testCart.getCartItemsAsArray().length);
    }

    @Test
    void testCalcCartTotal(){
        float initialTotal = testCart.getTotalCost();
        testCart.addCartItem(testGame);
        float finalTotal = testCart.getTotalCost();
        Assertions.assertNotEquals(initialTotal, finalTotal);
        testCart.removeCartItemByID(12);
        finalTotal = testCart.getTotalCost();
        Assertions.assertEquals(initialTotal, finalTotal);
    }
}
