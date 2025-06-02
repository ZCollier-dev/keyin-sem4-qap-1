# Keyin College - Semester 4 - QAP1 - Game Store System
AUTHOR: Zachary Collier

DEPENDENCIES: 
- JUnit 5 Jupiter API - Maven Repository - https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api

This project is a basic Game Store System, allowing a user to purchase a variety of games from a select stock.
Users may view store stock and their cart, add items found in the stock to the cart, remove/clear items from the cart, search the stock for an ID or search query, and place an order with all items in their cart.
Additionally, game prices in the stock may be changed (perhaps due to a sale), and view the order database.
All functionality can be accessed through a menu system, allowing users to control what they may do.

### TESTS:
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

### CLEAN CODE SNIPPETS:

Stock.java
```java 
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
```

The above code has decent readability. The comment above the method tells what the method returns and how the method does its job. The method name is fairly self-explanatory - it searches for a game via its name. The for loop is also split into its own block for extra readability, allowing the eyes to rest. Variable names are clear enough to understand.

Adding some of the name's functionality into the comment may make the method more clear in what it does in its entirety.

StoreProcessingSystem.java
```java
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
```

The above code also has decent readability. The method name describes how the method works - it searches for a game by its ID, then adds it to the cart. There is some separation in the method's code, but there could be more within the first if statement, say, between ```Game game;``` and ```id = scanner.nextInt();```. Variable names represent exactly what they are - cart for a cart, stock for the stock used, etc.

A comment at the top may also go a long way in describing how it works, i.e. the fact that it returns the cart, whether the cart gets updated or not.

CartTest.java
```java
    @Test
    void testCalcCartTotal(){
        // Tests whether the total cost is properly calculated on item add/remove.
        float initialTotal = testCart.getTotalCost();
        testCart.addCartItem(testGame);
        float finalTotal = testCart.getTotalCost();
        Assertions.assertEquals(initialTotal + testGame.getPrice(), finalTotal);
        testCart.removeCartItemByID(12);
        finalTotal = testCart.getTotalCost();
        Assertions.assertEquals(initialTotal, finalTotal);
    }
```

The above code, again, has decent readability. This time, bot the name and comment describe the test very well, in that it tests the cart's total cost recalculation method for proper functionality when an item is added or removed. The name gives a basic overview at a glance, the comment goes into some more detail. Variable names are descriptive.

The flaw here is the lack of spacing between blocks of code. A good place for one may be directly after the first assertion.

### NOTES ON QAP:
This past week has been riddled with personal issues, hence the very slow progress up until Sunday, June 1st. Very few QAP-related problems arose on this day.
