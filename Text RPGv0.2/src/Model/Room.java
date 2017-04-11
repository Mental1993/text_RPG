package Model;

import java.util.ArrayList;
import Model.Movement;

public class Room {
    
    //Class variables
    private Database db = new Database();
    private int roomId;
    private String name;
    private String desc;
    private Item item;
    private int[] exits = new int[4]; //1->N, 2->W, 3->S, 4->E
    public static Room currRoom;
    public Movement movement = new Movement();
    
    public static ArrayList<Room> roomList = new ArrayList<Room>();
    
    //Constructors
    public Room() {
       
    }
    
    //Constructor - Room without item
    public Room(String roomName, String roomDesc) {
        this.name = roomName;
        this.desc = roomDesc;
        int i = 0;
        for(i=0; i< exits.length; i++) {
            exits[i] = 0;
        }     
    }
    
    //Constructor - Room with item
    public Room(String roomName, String roomDesc, Item item) {
        this.name = roomName;
        this.desc = roomDesc;
        this.item = item;
        int i = 0;
        for(i=0; i< exits.length; i++) {
            exits[i] = 0;
        }     
    }
    
    //Settes & Getters
    public int getRoomId() {
        return this.roomId;
    }
    
    public void setRoomId(int newRoomId) {
        this.roomId = newRoomId;
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
        this.name = newDesc;
    }
    
    public int[] getExits() {
        return this.exits;
    }
    
    public Item getItem() {
        return this.item;
    }
    
    public void setItem(Item newItem) {
        this.item = newItem;
    }
   
    public void setExits(int exit1, int exit2, int exit3, int exit4) {
        this.exits[0] = exit1;
        this.exits[1] = exit2;
        this.exits[2] = exit3;
        this.exits[3] = exit4;
    } 
    
    
}
