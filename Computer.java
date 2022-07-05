package Assignment_1;

public class Computer extends Item{
    private String brand;
    private String cpu_model;
    private int ram;
    private int storage;

    Computer(){
    }

    public Computer(int item_ID, String name, double price, int quantity, String brand, String cpu_model, int ram, int storage) {
        super(item_ID, name, price, quantity);
        this.brand = brand;
        this.cpu_model = cpu_model;
        this.ram = ram;
        this.storage = storage;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCpu_model() {
        return cpu_model;
    }

    public void setCpu_model(String cpu_model) {
        this.cpu_model = cpu_model;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String displayItem(){
        return  "Item type: Computer" +
                "\nItemID: " + item_ID +
                "\nName: " + name +
                "\nPrice: " + price +
                "\nQuantity: " + quantity +
                "\nBrand: " + brand +
                "\nCpu Model: " + cpu_model +
                "\nRAM: " + ram +
                "\nStorage: " + storage;
    }
}
