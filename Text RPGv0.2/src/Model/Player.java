package Model;

import java.util.ArrayList;

public class Player {
    
    //Initialize variables & objects
    private Database db = new Database();
    private int userId, currRoom;
    private String name;
    private static ArrayList<Item> inventory = new ArrayList<Item>();
    private static Player player = new Player();
    
    //Sigleton pattern
    public static Player get() { 
        return player; 
    }
    
    //Constructor for new player without name
    public Player() {
        
    }
    
    //Constructor for new player with name
    public Player(String name) {
        this.name = name;
    }
    
    //MISSING ---- Constructor for existing player(Load Game)
    
    //Setters & Getters
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setUserId(int newUserId) {
        this.userId = newUserId;
    }
    public int getUserId() {
        return this.userId;
    }
    public ArrayList<Item> getInv() {
        return inventory;
    }
    
    public void setCurrRoom(int newCurrRoom) {
        this.currRoom = newCurrRoom;
    }
    
    public int getCurrRoom() {
        return this.currRoom;
    }
    
    public void changeRoom(Room rooom) {
        
    }
    
    public String showInventory() {
        String output = "";
        output += "*************Inventory*************\n";
        for(Item inv_item : inventory) {
            output += inv_item.getName() + ":\t";
            output += inv_item.getDesc() + "\n";
        }
        return output;
    }
    
    public String pickItem(int itemId) {
        String output = "";
        if((db.hasItem(Room.currRoom.getRoomId(), itemId)) && (Room.currRoom.getItem() != null)) {
            output = db.getItemById(itemId).getName() + " has been added to your inventory.";
            inventory.add(db.getItemById(itemId));
            Room.currRoom.removeItem();
            return output;
        }else {
            output = db.getItemById(itemId).getName() + " doesn't exist in the room.";
            return output;
        }
    }
}
