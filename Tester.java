package Assignment_1;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Tester {

    // function generates a checkout bill
    public static void checkout(Cart cart)throws Exception{
       try {
           double price = 0.0;

           File file = new File("Bill.txt");
           BufferedWriter bw = new BufferedWriter(new FileWriter(file));
           if (!cart.cart_list.isEmpty()) {

               // for-loop runs to through all the items in cart to display in the bill file
               for (var f : cart.cart_list) {
                   String info = f.getItem_ID() + " " + f.getName() + " " + f.price + " " + f.getQuantity();
                   bw.write(info);
                   bw.newLine();
                   info = "";
               }

               String finalamoumnt = "Totol Price: " + cart.calculatePrice();
               bw.write(finalamoumnt);
               bw.close();

               System.out.println("*** Checkout completed ***");

           } else{
               System.out.println("*** Cart empty - Checkout failed ***");
           }
       }
       catch (FileNotFoundException e){
           System.out.println("The bill file was not found");
       }
    }


    //function adds an item to the cart
    public static Cart addtoCart(Store store, Cart cart) throws Exception{

        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter the ID of the item you want to add: ");
            int item_ID = input.nextInt();
            System.out.println("Enter the name of the item you want to add: ");
            String name = input.next();
            System.out.println("Enter the quantity of the item: ");
            int quantity = input.nextInt();

            int error_count = 0;

            //for-loop iterates through items in store and checks if item user entered is present
            for (var f : store.itemList) {
                if (item_ID == f.getItem_ID() && name.equals(f.getName())) {

                    Item tempItem  = (Item)f.clone();

                    tempItem.setQuantity(quantity);

                    cart.addItem(tempItem);

                    // when item is added to cart quantity user enters is removed from the store
                    f.setQuantity(f.quantity - quantity);

                    System.out.println("*** Item added to cart ***");
                }
                else {
                    error_count++;
                }
            }

            if(error_count == store.itemList.size()){
                throw new ItemNotExist("*** The item doesn't exist ***", item_ID, name);
            }
        }
        catch(ItemNotExist e){
            System.out.println(e);
        }
        catch(InputMismatchException e){
            System.out.println("*** Wrong input format ***");
        }

        return cart;

    }


    //function removes an item from the cart
    public static Cart removeItem(Store store, Cart cart) throws Exception{

        try {
            Scanner input = new Scanner(System.in);

            System.out.println("Enter the ID of the item you want to remove: ");
            int item_ID = input.nextInt();
            System.out.println("Enter the name of the item you want to remove:");
            String name = input.next();

            int error_count = 0;

            //for-loop iterates through items in cart
            for (var f : cart.cart_list) {
                if (item_ID == f.getItem_ID() && name.equals(f.getName())) {
                    for(var j : store.itemList){
                        if (item_ID == f.getItem_ID() && name.equals(f.getName())){
                            //when item is found it returns to quantity to store
                            j.quantity += f.getQuantity();
                        }
                    }
                    cart.removeItem(f);

                    System.out.println("*** Item removed from cart ***");

                    return cart;
                } else {
                    error_count++;
                }
            }

            if(error_count == cart.cart_list.size()){
                throw new ItemNotExist("*** The item doesn't exist ***", item_ID, name);
            }
        }
        catch(ItemNotExist e){
            System.out.println(e);
        }
        catch (InputMismatchException e){
            System.out.println("*** Wrong input format ***");
        }

        return cart;

    }


    //function empties the cart
    public static Cart emptyCart(Store store, Cart cart){

        //for-loop iterates through the items in cart
        for (var f : cart.cart_list) {
            for (var j : store.itemList) {
                if (f.getItem_ID() == j.getItem_ID()) {
                    //for each item the quantity is returned to store
                    j.quantity += f.getQuantity();
                }
            }
        }

        cart.emptyCart();
        return cart;
    }


    //function stocks the store from a stock file
    public static ArrayList<Item> Stock() throws Exception{

        try {

            File filename = new File("Stock.txt");

            Scanner input = new Scanner(filename);

            ArrayList<Item> items = new ArrayList<Item>();
            Store store = new Store("Store", "Dubai");

            //while-loop goes through each line in the file and adds it to an ArrayList
            while (input.hasNextLine()) {
                String itemType = input.next();

                if (itemType.equals("Clothing")) {
                    int ID = input.nextInt();
                    String name = input.next();
                    double price = input.nextDouble();
                    int quantity = input.nextInt();
                    int size = input.nextInt();
                    String color = input.next();
                    String gender = input.next();

                    Item item = new Clothing(ID, name, price, quantity, size, color, gender);

                    items.add(item);

                } else if (itemType.equals("Bike")) {
                    int ID = input.nextInt();
                    String name = input.next();
                    double price = input.nextDouble();
                    int quantity = input.nextInt();
                    String company = input.next();
                    String description = input.next();

                    Item item = new Bike(ID, name, price, quantity, company, description);

                    items.add(item);
                } else if (itemType.equals("Beverage")) {
                    int ID = input.nextInt();
                    String name = input.next();
                    double price = input.nextDouble();
                    int quantity = input.nextInt();
                    double volume = input.nextDouble();
                    boolean alcoholic = input.nextBoolean();

                    Item item = new Beverage(ID, name, price, quantity, volume, alcoholic);

                    items.add(item);
                } else if (itemType.equals("Food")) {
                    int ID = input.nextInt();
                    String name = input.next();
                    double price = input.nextDouble();
                    int quantity = input.nextInt();
                    int calories = input.nextInt();
                    boolean fresh = input.nextBoolean();

                    Item item = new Food(ID, name, price, quantity, calories, fresh);

                    items.add(item);
                } else if (itemType.equals("Computer")) {
                    int ID = input.nextInt();
                    String name = input.next();
                    double price = input.nextDouble();
                    int quantity = input.nextInt();
                    String brand = input.next();
                    String cpu_model = input.next();
                    int ram = input.nextInt();
                    int storage = input.nextInt();

                    Item item = new Computer(ID, name, price, quantity, brand, cpu_model, ram, storage);

                    items.add(item);

                }

            }

            //for-loop iterates through an ArrayList of items to check for any duplicates
            for (int i = 0; i < items.size(); i++) {
                for (int j = items.size() - 1; j > i; j--) {
                    try {
                        if (items.get(i).getItem_ID() == items.get(j).getItem_ID() || items.get(i).getName().equals(items.get(j).getName())) {
                            throw new DuplicateRecord("Duplicate", items.get(j).getItem_ID(), items.get(j).getName());
                        }
                    } catch (DuplicateRecord d) {
                        System.out.println(d);
                        items.remove(items.get(j));
                    }

                }
            }

            return items;
        }
        catch(FileNotFoundException e){
            System.out.println("*** Stock file is not found ***");
        }
        catch (InputMismatchException e){
            System.out.println("*** Wrong input format ***");
        }

        return null;
    }


    //main
    public static void main(String[] args) throws Exception{

        try {

            Store store = new Store("Store", "Dubai");

            store.itemList = Stock();

            Cart cart = new Cart(store);

            Scanner input = new Scanner(System.in);


            int menuChoice = -1;

            //while loop that display the store menu
            while (menuChoice != 7) {

                System.out.println("\n1) List Items in Store");
                System.out.println("2) List Items in Cart");
                System.out.println("3) Add Item to Cart");
                System.out.println("4) Remove Item from Cart");
                System.out.println("5) Empty Cart");
                System.out.println("6) Checkout");
                System.out.println("7) QUIT");

                Scanner input2 = new Scanner(System.in);

                menuChoice = input2.nextInt();

                if (menuChoice == 7) {
                    break;
                } else {

                    switch (menuChoice) {

                        case 1:
                            System.out.println();
                            System.out.println("*** Items in store: ***\n");
                            store.displayItems();
                            System.out.println("***********************************");

                            break;

                        case 2:
                            System.out.println();
                            System.out.println("*** Items in cart: ***");
                            System.out.println();
                            cart.displayCart();
                            System.out.println("***********************************");
                            break;

                        case 3:

                            cart = addtoCart(store, cart);
                            System.out.println("***********************************");

                            break;

                        case 4:
                            cart = removeItem(store, cart);
                            System.out.println();
                            System.out.println("***********************************");

                            break;

                        case 5:
                            cart = emptyCart(store, cart);
                            System.out.println("*** Emptied cart ***");
                            System.out.println("***********************************");

                            break;

                        case 6:
                            checkout(cart);
                            System.out.println("***********************************");

                            break;

                        default:

                            System.out.println("*** Please enter a number from 1 to 7 ***");

                            break;
                    }//switch

                }//else

            }//while
        }
        catch (NullPointerException e){
            System.out.println("*** There are no items in store ***");
        }
        catch (InputMismatchException e){
            System.out.println("*** Wrong input format ***");
        }


        System.out.println("**** PROGRAM END ****");

        System.out.println("-----------------------------------");
    }

    
}
