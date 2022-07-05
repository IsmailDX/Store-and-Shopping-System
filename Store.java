package Assignment_1;

import java.util.ArrayList;

public class Store {
    protected String name;
    protected String location;
    protected ArrayList<Item> itemList = new ArrayList<Item>();

    Store(){
    }

    Store(String name, String location){
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void displayItems(){
        for(var f : itemList){
            System.out.println(f.displayItem());
            System.out.println();
        }
    }

    public void addItem(Item i){
        itemList.add(i);
    }

    public void removeItem(Item i){
        itemList.remove(i);
    }

}
