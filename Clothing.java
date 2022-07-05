package Assignment_1;

public class Clothing extends Item{
    private int size;
    private String color;
    private String gender;

    Clothing(){
    }

    public Clothing(int item_ID, String name, double price, int quantity, int size, String color, String gender) {
        super(item_ID, name, price, quantity);
        this.size = size;
        this.color = color;
        this.gender = gender;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String displayItem(){
        return  "Item type: Clothing" +
                "\nItemID: " + item_ID +
                "\nName: " + name +
                "\nPrice: " + price +
                "\nQuantity: " + quantity +
                "\nSize: " + size +
                "\nColor: " + color +
                "\nGender: " + gender ;
    }
}
