package Assignment_1;

public class Food extends Item{
    private int calories;
    private boolean fresh;

    Food(){
    }

    Food(int item_ID, String name, double price, int quantity, int calories, boolean fresh){
        super(item_ID, name, price, quantity);
        this.calories = calories;
        this.fresh = fresh;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public boolean isFresh() {
        return fresh;
    }

    public void setFresh(boolean fresh) {
        this.fresh = fresh;
    }

    public String displayItem(){
        return  "Item type: Food" +
                "\nItemID: " + item_ID +
                "\nName: " + name +
                "\nPrice: " + price +
                "\nQuantity: " + quantity +
                "\nCalories: " + calories +
                "\nFresh: " + fresh;
    }
}
