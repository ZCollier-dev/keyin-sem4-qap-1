package org.example;

import java.util.Scanner;

public class Main {
    private static void menu(){
        System.out.println("DEV'S CHOICE GAMING");
        System.out.println();
        System.out.println("0. Exit");
        System.out.println("1. Show Menu");
        System.out.println("2. View Store's Stock");
        System.out.println("3. View Cart");
        System.out.println("4. Add game to Cart (Game ID)");
        System.out.println("5. Search games stock");
        System.out.println("6. Remove game from Cart");
        System.out.println("7. Clear Cart");
        System.out.println("8. Place Order");
        System.out.println("----------");
        System.out.println("9. Change Game Price");
        System.out.println("10. View Orders");
        System.out.println();
    }

    public static void main(String[] args) {
        float HST = 0.15f;
        int choice = -1;
        Cart cart = new Cart();
        Stock stock = new Stock();
        OrderDB database = new OrderDB();
        StoreProcessingSystem SPSystem = new StoreProcessingSystem();
        Scanner scanner = new Scanner(System.in);

        menu();
        while (choice != 0) {
            System.out.print("Enter your choice (1 for menu): ");
            if (scanner.hasNextInt()){
                choice = scanner.nextInt();
                switch (choice) {
                    case 0: {
                        System.out.println("Exiting... thank you for using this program!");
                        break;
                    }
                    case 1: {
                        menu();
                        break;
                    }
                    case 2: {
                        System.out.println(stock);
                        break;
                    }
                    case 3: {
                        System.out.println(cart);
                        break;
                    }
                    case 4: {
                        cart = SPSystem.searchGameByIDAndAdd(stock, cart, scanner);
                        break;
                    }
                    case 5: {
                        cart = SPSystem.searchGameByNameAndAdd(stock, cart, scanner);
                        break;
                    }
                    case 6: {
                        cart = SPSystem.removeGame(cart, scanner);
                        break;
                    }
                    case 7: {
                        cart.clearCart();
                        break;
                    }
                    case 8: {
                        int oldDBLength = database.getOrders().length;
                        database = SPSystem.purchaseAndCreateOrder(cart, HST, database, scanner);
                        if (database.getOrders().length > oldDBLength){
                            cart.clearCart();
                        }
                        break;
                    }
                    case 9: {
                        stock = SPSystem.changeGamePrice(stock, scanner);
                        break;
                    }
                    case 10: {
                        System.out.println(database);
                        break;
                    }
                    default: {
                        System.out.println("ERR: Option not found.");
                    }
                }
            } else {
                System.out.println("ERR: Invalid input.");
                scanner.next();
            }
        }
    }
}