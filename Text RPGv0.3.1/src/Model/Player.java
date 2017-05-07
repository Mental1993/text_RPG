package Model;

import Controller.mainController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.Timer;

public class Player {
    
    //Initialize variables & objects
    private Database db = new Database();
    private int userId, currRoom;
    private String name;
    private int p_hp, p_attack, p_gold;
    private static ArrayList<Item> inventory = new ArrayList<Item>();
    private static Player player = new Player("Mentalos", 40, 5, 0);
    
    //Sigleton pattern
    public static Player get() { 
        if(player == null) {
            player = new Player("Mentalos", 40, 5, 0);
        }
        return player; 
    }
    
    //Constructor for new player without name
    public Player() {
        
    }
    
    //Constructor for new player with name
    public Player(String name) {
        this.name = name;
    }
    
    //Constructor for new player with name, hp and attack
    public Player(String name, int hp, int attack, int gold) {
        this.name = name;
        this.p_hp = hp;
        this.p_attack = attack;
        this.p_gold = gold;
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
    
    public int getAttack() {
        return this.p_attack;
    }
    
    public void setAttack(int newAttack) {
        this.p_attack = newAttack;
    }
    
    public int getHP() {
        return this.p_hp;
    }
    
    public void setHP(int newHP) {
        this.p_hp = newHP;
    }
    
    public int getGold() {
        return this.p_gold;
    }
    
    public void setGold(int newGold) {
        this.p_gold = newGold;
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
        if((db.hasItem(Room.currRoom.getRoomId(), itemId)) ) {
            output = db.getItemById(itemId).getName() + " has been added to your inventory.";
            inventory.add(db.getItemById(itemId));
            Room.currRoom.removeItem();
            db.removeItemFromRoom(Room.currRoom.getRoomId());
            return output;
        }else {
            output = db.getItemById(itemId).getName() + " doesn't exist in the room.";
            System.out.println(Room.currRoom.getRoomId() + " " + itemId);
            return output;
        }
    }
}
