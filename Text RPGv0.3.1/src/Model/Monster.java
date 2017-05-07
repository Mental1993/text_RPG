package Model;

import java.util.ArrayList;

public class Monster {
    
    //Class variables
    private int monsterId;
    private String name;
    private String desc;
    private int m_hp, m_attack, m_gold;
    public static ArrayList<Monster> monsterList = new ArrayList<Monster>();
    
    //Create an an empty Monster object
    public Monster() {
        
    }
    
    //Create a Monster with name and desc
    public Monster(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }
    
    //Create a Monster with name, desc, hp,attack and gold
    public Monster(String name, String desc, int m_hp, int m_attack) {
        this.name = name;
        this.desc = desc;
        this.m_hp = m_hp;
        this.m_attack = m_attack;
        this.m_gold = m_gold;
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
    
    public int getAttack() {
        return this.m_attack;
    }
    
    public void setAttack(int newAttack) {
        this.m_attack = newAttack;
    }
    
    public int getHP() {
        return this.m_hp;
    }
    
    public void setHP(int newHP) {
        this.m_hp = newHP;
    }
    
    public int getGold() {
        return this.m_gold;
    }
    
    public void setGold(int newGold) {
        this.m_gold = newGold;
    }
}
