package Model;

import java.util.ArrayList;


public class Item {
    
    //Class variables
    
    private int itemId;
    private String name;
    private String desc;
    public static ArrayList<Item> itemList = new ArrayList<Item>();
       
    //Constructor with no initial values
    public Item() {
        
    }

    //Constructor with name and desc
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    //Setters & Getters
    public int getItemId() {
        return this.itemId;
    }
    
    public void setItemId(int newItemId) {
        this.itemId = newItemId;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getDesc() {
        return this.desc;
    }
    
    public void setDesc(String newDesc) {
        this.desc = newDesc;
    }
 
}
