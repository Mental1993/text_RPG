/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.mainController;

/**
 *
 * @author Mental
 */
public class Battle {
    Database db = new Database();
    Monster curr_monster = null;
    
    public Battle() {
        
    }
    
    public String monsterExistsInRoom() {
        if(db.hasMonster(Room.currRoom.getRoomId())) {
            int monster_id = db.findMonsterId(Room.currRoom.getRoomId());
            mainController.fightMode = true;
            curr_monster = db.getMonsterById(monster_id);
            return "A " + curr_monster.getName() + " appeared!\n" + curr_monster.getDesc() + "You can FIGHT or RUN!";
            
        }else{
            return "";
        }
    }
    
    public String fight() {
        //initialize variables
        String output = "";
        int p_max_hp,p_curr_hp,p_attack,m_max_hp,m_curr_hp,m_attack;
        //Fill combat variables with values
        p_max_hp = p_curr_hp = Player.get().getHP();
        m_max_hp = m_curr_hp = curr_monster.getHP();
        p_attack = Player.get().getAttack();
        m_attack = curr_monster.getAttack();
        //fight loop
        while(p_curr_hp > 0 && m_curr_hp > 0) {
            output += "You attacked " + curr_monster.getName() + " for " + p_attack + " damage!\n";
            m_curr_hp -= p_attack;
            if(m_curr_hp <= 0) {
                output += curr_monster.getName() + " is dead!\n";
                p_curr_hp = p_max_hp;
                Player.get().setGold(Player.get().getGold() + curr_monster.getGold());
                mainController.fightMode = false;
            }else {
                output += curr_monster.getName() + " attacked you for " + curr_monster.getAttack() + " damage!\n";
                p_curr_hp -= m_attack;
                if(p_curr_hp <= 0) {
                    output += "You are dead!\n";
                    p_curr_hp = 0;
                    Player.get().setGold(0);
                    Player.get().getInv().clear();
                    mainController.fightMode = false;
                }
            }
        }

        return output;
    }
    
    public String run() {
        mainController.fightMode = false;
        return "You run away. Coward!";
    }
}
