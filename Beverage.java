package Assignment_1;

public class Beverage extends Item{
    private double volume;
    private boolean alcoholic;

    Beverage(){
    }

    Beverage(int item_ID, String name, double price, int quantity, double volume, boolean alcoholic){
        super(item_ID, name, price, quantity);
        this.volume = volume;
        this.alcoholic =alcoholic;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        this.alcoholic = alcoholic;
    }
    public String displayItem(){
        return  "Item type: Beverage" +
                "\nItemID: " + item_ID +
                "\nName: " + name +
                "\nPrice: " + price +
                "\nQuantity: " + quantity +
                "\nVolume: " + volume +
                "\nAlcoholic: " + alcoholic;
    }
}
