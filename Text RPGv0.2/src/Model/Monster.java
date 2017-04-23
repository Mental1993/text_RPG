package Model;

import java.util.ArrayList;

public class Monster {
    
    //Class variables
    private int monsterId;
    private String name;
    private String desc;
    public static ArrayList<Monster> monsterList = new ArrayList<Monster>();
    
    //Create an an empty Monster object
    public Monster() {
        
    }
    
    //Create a Monster with name and desc
    public Monster(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    //Setters abd Getters
    public int getMonsterId() {
        return this.monsterId;
    }
    
    public void setMonsterId(int newMonsterId) {
        this.monsterId = newMonsterId;
    }
    
    public String getName() {
        return name;
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
