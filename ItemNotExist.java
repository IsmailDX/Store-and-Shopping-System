package Assignment_1;

public class ItemNotExist extends Exception{

    private int ID;
    private String name;

    ItemNotExist(){
        super();
    }

    ItemNotExist(String e, int ID, String name){
        super(e);
        this.ID = ID;
        this.name = name;
    }

    public String toString(){
        return "*** The item " + name + " with the ID " + ID + " does not exist. ***";
    }

}
