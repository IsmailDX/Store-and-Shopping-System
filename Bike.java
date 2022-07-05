package Assignment_1;

public class Bike extends Item{
    private String company;
    private String description;

    Bike(){
    }

    Bike(int item_ID, String name, double price, int quantity, String company, String description){
        super(item_ID, name, price, quantity);
        this.company = company;
        this.description = description;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String displayItem(){
        return  "Item type: Bike" +
                "\nItemID: " + item_ID +
                "\nName: " + name +
                "\nPrice: " + price +
                "\nQuantity: " + quantity +
                "\nCompany: " + company +
                "\nDescroption: " + description;
    }
}
