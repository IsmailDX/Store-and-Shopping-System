package Assignment_1;

import java.util.ArrayList;

public class Cart extends Store{
    private Store store;
    protected ArrayList<Item> cart_list;

    Cart(){

    }

    public Cart(Store store) {
        this.store = store;
        this.cart_list = new ArrayList<Item>();
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public void addItem (Item item){
       cart_list.add(item);
    }

    public void removeItem(Item item){
        cart_list.remove(item);
    }

    public void emptyCart(){
        cart_list.clear();
    }

    public void displayCart(){
        for(var f : cart_list){
            System.out.println(f.displayItem());
            System.out.println();
        }
    }

    public double calculatePrice(){
        double total_price = 0.0;
        for(var f : cart_list){
            total_price += (f.getPrice()*f.getQuantity());
        }
        return total_price;
    }
}
