package org.example;

import java.util.Scanner;

// Handles advanced logic away from the menu.
public class StoreProcessingSystem {

    public Stock changeGamePrice(Stock stock, Scanner scanner){
        int id;
        float price;

        System.out.println(stock);

        while (true) {
            System.out.println("Enter game ID: ");
            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                if (stock.getGameByID(id) != null){
                    break;
                }
            } else {
                System.out.println("ERR: Invalid input.");
                scanner.next();
            }
        }

        while (true) {
            System.out.println("Enter new price: ");
            if (scanner.hasNextFloat()){
                price = scanner.nextFloat();
                break;
            } else {
                System.out.println("ERR: Invalid input.");
                scanner.next();
            }
        }

        stock.setGamePrice(id, price);
        return stock;
    }

    public Cart searchGameByIDAndAdd(Stock stock, Cart cart, Scanner scanner){
        System.out.println("Enter game ID: ");

        if (scanner.hasNextInt()){
            int id;
            Game game;
            id = scanner.nextInt();
            game = stock.getGameByID(id);
            if (game != null){
                cart.addCartItem(game);
            }
        } else {
            System.out.println("ERR: Invalid input.");
            scanner.next();
        }

        return cart;
    }

    public Cart searchGameByNameAndAdd(Stock stock, Cart cart, Scanner scanner){
        String query;
        Game[] searchResults;

        System.out.print("Enter search query: ");
        query = scanner.nextLine();
        searchResults = stock.searchGamesByName(query);

        if (searchResults.length > 0){
            int id;

            for (int i = 0; i < searchResults.length; i++) {
                System.out.println(searchResults[i].toString());
            }

            while (true) {
                System.out.println("Enter game ID to purchase (or -1 to buy none of them): ");

                if (scanner.hasNextInt()){
                    id = scanner.nextInt();

                    if (id <= -1) {
                        break;
                    }

                    Game game = null;
                    for (int i = 0; i < searchResults.length; i++) {
                        if (id == searchResults[i].getId()){
                            game = searchResults[i];
                            cart.addCartItem(game);
                            break;
                        }
                    }

                    if (game == null){
                        System.out.println("ERR: Invalid choice.");
                    }
                } else {
                    System.out.println("ERR: Invalid input.");
                    scanner.next();
                }
            }
        } else {
            System.out.println("ERR: No games found.");
        }

        return cart;
    }

    public Cart removeGameFromCart(Cart cart, Scanner scanner){
        int id;

        while (true) {
            System.out.println(cart.toString());
            System.out.print("Enter game ID to delete (or -1 to exit): ");

            if (scanner.hasNextInt()){
                id = scanner.nextInt();
                if (id <= -1){
                    break;
                }
                cart.removeCartItemByID(id);
            } else {
                System.out.println("ERR: Invalid input.");
                scanner.next();
            }
        }

        return cart;
    }

    public OrderDB purchaseAndCreateOrder(Cart cart, float taxRate, OrderDB database, Scanner scanner){
        String choice;

        System.out.println("Review your order: ");
        System.out.println(cart.toString());
        System.out.println(String.format("TAX: $%.2f", (cart.getTotalCost() * taxRate)));
        System.out.println(String.format("TOTAL: $%.2f", (cart.getTotalCost() * (1 + taxRate))));
        System.out.println();

        while (true) {
            System.out.print("Place your order now? (y for yes, n for no): ");
            scanner.nextLine();
            choice = scanner.nextLine();

            if (choice.toLowerCase().equals("y")){
                database.addOrder(new Order(cart, taxRate));
                break;
            } else if (choice.toLowerCase().equals("n")){
                break;
            } else {
                System.out.println("ERR: Invalid input.");
            }
        }

        return database;
    }
}
