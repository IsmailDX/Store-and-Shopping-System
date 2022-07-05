package Assignment_1;

public class DuplicateRecord extends Exception{
    private int item_ID;
    private String name;

    DuplicateRecord(){
        super();
    }

    DuplicateRecord(String e, int item_ID, String name){
        super(e);
        this.item_ID = item_ID;
        this.name = name;
    }

    public String toString(){
        return "*** " +item_ID + " " + name + " is a duplicate entry ***";
    }
}
