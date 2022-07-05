package Assignment_1;

public abstract class Item implements Cloneable{
    final protected int item_ID;
    final protected String name;
    protected double price;
    protected int quantity;

    Item(){
        this.item_ID = -1;
        this.name = null;
        this.price = -1;
        this.quantity = -1;
    }

    Item(int item_ID, String name, double price, int quantity){
        this.item_ID = item_ID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getItem_ID() {
        return item_ID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract String displayItem();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
