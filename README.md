# Keyin College - Semester 4 - QAP1 - Game Store System
AUTHOR: Zachary Collier
DEPENDENCIES: 
- JUnit 5 Jupiter API - Maven Repository - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

This project is a basic Game Store System, allowing a user to purchase a variety of games from a select stock.
Users may view store stock and their cart, add items found in the stock to the cart, remove/clear items from the cart, search the stock for an ID or search query, and place an order with all items in their cart.
Additionally, game prices in the stock may be changed (perhaps due to a sale), and view the order database.
All functionality can be accessed through a menu system, allowing users to control what they may do.

Many tests have been implemented into the project.

In CartTest.java:
Adding items is the first thing tested for, checking if the cart's ArrayList properly adds the game.
Removing items is next, ensuring that not only is an item removed, but also that the correct item was removed.
Clearing items ensures that the cart is properly cleared of items and holds nothing after the operation.
Calculating the total cost checks if the total cost of the cart items properly updates upon adding and removing items from the cart.

In OrderDBTest.java:
Adding orders to the database is the only thing tested, ensuring that orders are properly added to the object.

In OrderTest.java:
Creating the order is the only thing tested, ensuring the proper initialization of the Order object, and also that the tax rate is properly applied.

In StockTest.java:
Creating a custom stock is first, ensuring that the custom stock's array is the same as its input.
Searching the stock by ID tests if the proper game is returned after recieving an input ID.
Searching the stock by a name or search query checks if a query returns the correct games matching the query, and tests both single- and multi-game return values.
Setting the price of a game present in the stock (i.e. in case of a sale) checks if the price of that game is equal to the input price.

### NOTES ON QAP:
This past week has been riddled with personal issues, hence the very slow progress up until Sunday, June 1st. Very few QAP-related problems arose on this day.
No time for images prior to the deadline, may upload some the day after.
