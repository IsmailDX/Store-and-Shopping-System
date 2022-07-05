# Store-and-Shopping-System
developing a virtual system for a store where customers can add items to their cart and checkout when they finished. 
This is a menu driven program used by interacting with the console terminal.

The Store has its name, location and a list of items that are in stock. At the start, the store is stocked from a database file which contains a description of items 
that are sold in the store. The items that are stocked each have a unique ID, unique name, a price and the quantity at the store. The ID and name of an item should 
not change. When attempting to stock an item with an ID or name that already exists, you should throw an exception with the appropriate name and description.
Items can have different types with additional details unique to the type of the item. Clothing items have a size, color and a gender which can be male, female or all. 
Computers at the store have a brand, a CPU model, some amount of RAM and storage. Food items have calories and whether they are fresh or not. Beverages have a volume 
and whether they are alcoholic or not. Additionally, the store has asked you to come up with an additional item type it can sell.
Customers use shopping carts to do shopping. The cart belongs to and has reference to the store and it has its own list of items with quantities in the cart. 
Customers can add items to the cart by taking it from the store or remove items from the cart by returning it to the store. When this happens, the quantity of the 
items in the store and the cart is decremented and incremented appropriately. When the customer tries to add an item which doesn't exist or out of stock, you should
have an exception. The customer should also have the option to completely empty their cart. 
Finally, at check out you should print the bill to a file with the list of items and the final amount to be paid. If the customer wants to check out with no items in 
their cart, there is no need for a bill.

+ Run the tester code to run the program
