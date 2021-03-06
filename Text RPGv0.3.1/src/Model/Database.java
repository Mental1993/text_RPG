package Model;

import View.game;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class Database { 
    //Database connection variables
    private static String username = "root";
    private static String password = "";
    //table users
    private static final String TABLE_USERS = "users";
    private static final String USERS_COLUMN_USER_ID = "user_id";
    private static final String USERS_COLUMN_USER_NAME = "user_name";
    private static final String USERS_COLUMN_USER_HP = "p_hp";
    private static final String USERS_COLUMN_USER_ATTACK = "p_attack";
    private static final String USERS_COLUMN_USER_GOLD = "p_gold";
    private static final String USERS_COLUMN_CURR_ROOM = "curr_room";
    //table rooms
    private static final String TABLE_ROOMS = "rooms";
    private static final String ROOMS_COLUMN_ROOM_ID = "room_id";
    private static final String ROOMS_COLUMN_ROOM_NAME = "room_name";
    private static final String ROOMS_COLUMN_ROOM_DESC = "room_desc";
    private static final String ROOMS_COLUMN_EXIT_1 = "exit1";
    private static final String ROOMS_COLUMN_EXIT_2 = "exit2";
    private static final String ROOMS_COLUMN_EXIT_3 = "exit3";
    private static final String ROOMS_COLUMN_EXIT_4 = "exit4";
    private static final String ROOMS_COLUMN_IMAGE = "image";
    private static final String ROOMS_COLUMN_ITEM = "item";
    private static final String ROOMS_COLUMN_MONSTER = "monster";
    //table items
    private static final String TABLE_ITEMS = "items";
    private static final String ITEMS_COLUMN_ITEM_ID = "item_id";
    private static final String ITEMS_COLUMN_ITEM_NAME = "item_name";
    private static final String ITEMS_COLUMN_ITEM_DESC = "item_desc";
    //table inventory
    private static final String TABLE_INVENTORY = "inventory";
    private static final String INV_COLUMN_INV_ID = "inv_id";
    private static final String INV_COLUMN_USER_ID = "user_id";
    private static final String INV_COLUMN_ITEM1_ID = "item1_id";
    private static final String INV_COLUMN_ITEM2_ID = "item2_id";
    private static final String INV_COLUMN_ITEM3_ID = "item3_id";
    private static final String INV_COLUMN_ITEM4_ID = "item4_id";
    private static final String INV_COLUMN_ITEM5_ID = "item5_id";
    private static final String INV_COLUMN_ITEM6_ID = "item6_id";
    //table monster
    private static final String TABLE_MONSTERS = "monsters";
    private static final String MONSTERS_COLUMN_MONSTER_ID = "monster_id";
    private static final String MONSTERS_COLUMN_MONSTER_NAME = "monster_name";
    private static final String MONSTERS_COLUMN_MONSTER_DESC = "monster_desc";
    private static final String MONSTERS_COLUMN_MONSTER_HP = "monster_hp";
    private static final String MONSTERS_COLUMN_MONSTER_ATTACK = "monster_attack";
    private static final String MONSTERS_COLUMN_MONSTER_GOLD = "m_gold";
    
    private static String connString = "jdbc:mysql://localhost:3306/text_rpg";
    public static Connection connection;
    
    //Attempts connection to the database. Catches the error if it fails.
    public void connect(){
        try {
            connection = DriverManager.getConnection(connString, username, password);
            System.out.println("Connection is OK");
        } catch (SQLException ex) {
            Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Grabs the rooms from the databse and stores them in an ArrayList
    public void getRooms() {
        Statement stmt = null;
        //create query
        String query = "SELECT * FROM " + TABLE_ROOMS + "";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                Room room = new Room();
                room.setRoomId(rs.getInt(ROOMS_COLUMN_ROOM_ID));
                room.setName(rs.getString(ROOMS_COLUMN_ROOM_NAME));
                room.setDesc(rs.getString(ROOMS_COLUMN_ROOM_DESC));
                room.setExits(rs.getInt(ROOMS_COLUMN_EXIT_1), rs.getInt(ROOMS_COLUMN_EXIT_2), rs.getInt(ROOMS_COLUMN_EXIT_3), rs.getInt(ROOMS_COLUMN_EXIT_4));
                room.setItem(getItemById(rs.getInt(ROOMS_COLUMN_ITEM)));
                room.setMonster(getMonsterById(rs.getInt(ROOMS_COLUMN_MONSTER)));
                Room.roomList.add(room); 
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    //Grabs the items from the database and stores them in an ArrayList
    public void getItems() {
        Statement stmt = null;
        //create query
        String query = "SELECT * FROM " + TABLE_ITEMS + "";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                Item item = new Item();
                item.setItemId(rs.getInt(ITEMS_COLUMN_ITEM_ID));
                item.setName(rs.getString(ITEMS_COLUMN_ITEM_NAME));
                item.setDesc(rs.getString(ITEMS_COLUMN_ITEM_DESC));
                Item.itemList.add(item);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    //Grabs the monsters from the database and stores them in an ArrayList
    public void getMonsters() {
        Statement stmt = null;
        //create query
        String query = "SELECT * FROM " + TABLE_MONSTERS + "";
        try {
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                Monster monster = new Monster();
                monster.setMonsterId(rs.getInt(MONSTERS_COLUMN_MONSTER_ID));
                monster.setName(rs.getString(MONSTERS_COLUMN_MONSTER_NAME));
                monster.setDesc(rs.getString(MONSTERS_COLUMN_MONSTER_DESC));
                monster.setHP(rs.getInt(MONSTERS_COLUMN_MONSTER_HP));
                monster.setAttack(rs.getInt(MONSTERS_COLUMN_MONSTER_ATTACK));
                monster.setGold(rs.getInt(MONSTERS_COLUMN_MONSTER_GOLD));
                Monster.monsterList.add(monster);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Returns ONE room according to the ID given
    public Room getRoomById(int roomId) {
        //Initialize variables and objects
        Statement stmt = null;
        Room room = new Room();       
        //create query
        String query = "SELECT * FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId + "";
        try {
            stmt = connection.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                room.setRoomId(rs.getInt(ROOMS_COLUMN_ROOM_ID));
                room.setName(rs.getString(ROOMS_COLUMN_ROOM_NAME));
                room.setDesc(rs.getString(ROOMS_COLUMN_ROOM_DESC));
                int exit1 = rs.getInt(ROOMS_COLUMN_EXIT_1);
                int exit2 = rs.getInt(ROOMS_COLUMN_EXIT_2);
                int exit3 = rs.getInt(ROOMS_COLUMN_EXIT_3);
                int exit4 = rs.getInt(ROOMS_COLUMN_EXIT_4);
                room.setExits(exit1, exit2, exit3, exit4); 
                room.setItem(getItemById(rs.getInt(ROOMS_COLUMN_ITEM)));
                room.setMonster(getMonsterById(rs.getInt(ROOMS_COLUMN_MONSTER)));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return room;
    }
   
    //Returns ONE item according to the ID given
    public Item getItemById(int itemId) {
        //Initialize variables and objects
        Statement stmt = null;
        Item item = new Item();
        //create query
        String query = "SELECT * FROM " + TABLE_ITEMS + " WHERE " + ITEMS_COLUMN_ITEM_ID + " = " + itemId + "";
        try {
            stmt = connection.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                item.setItemId(rs.getInt(ITEMS_COLUMN_ITEM_ID));
                item.setName(rs.getString(ITEMS_COLUMN_ITEM_NAME));
                item.setDesc(rs.getString(ITEMS_COLUMN_ITEM_DESC));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return item;
    }
    
    //Returns ONE monster according to the ID given
    public Monster getMonsterById(int monsterId) {
        //Initialize variables and objects
        Statement stmt = null;
        Monster monster = new Monster();
        //create query
        String query = "SELECT * FROM " + TABLE_MONSTERS + " WHERE " + MONSTERS_COLUMN_MONSTER_ID + " = " + monsterId + "";
        try {
            stmt = connection.createStatement();
            //execute query
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                monster.setMonsterId(rs.getInt(MONSTERS_COLUMN_MONSTER_ID));
                monster.setName(rs.getString(MONSTERS_COLUMN_MONSTER_NAME));
                monster.setDesc(rs.getString(MONSTERS_COLUMN_MONSTER_DESC));
                monster.setHP(rs.getInt(MONSTERS_COLUMN_MONSTER_HP));
                monster.setAttack(rs.getInt(MONSTERS_COLUMN_MONSTER_ATTACK));
                monster.setGold(rs.getInt(MONSTERS_COLUMN_MONSTER_GOLD));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return monster;
    }
   
    public static ImageIcon getImageById(int roomId) {
        //initialize variables and objects
        Statement stmt = null;
        ImageIcon image = null;
        //create query
        String query = "SELECT " + ROOMS_COLUMN_IMAGE + " FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId + "";
        try {
            stmt = connection.createStatement();
            //execute
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                String img = rs.getString(ROOMS_COLUMN_IMAGE);
                image = new ImageIcon("img/rooms/" + img);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }   
        return image;
    }
    
    public Player getPlayerById(int playerId) {
        //Initialize variables and objects
        Statement stmt = null;
        Player player = new Player();
        //create query
        String query = "SELECT * FROM " + TABLE_USERS + " WHERE " + USERS_COLUMN_USER_ID + " = " + playerId + "";
        try {
            stmt = connection.createStatement();
            //execute
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                player.setUserId(rs.getInt(USERS_COLUMN_USER_ID));
                player.setName(rs.getString(USERS_COLUMN_USER_NAME));
                player.setHP(rs.getInt(USERS_COLUMN_USER_HP));
                player.setAttack(rs.getInt(USERS_COLUMN_USER_ATTACK));
                player.setGold(rs.getInt(USERS_COLUMN_USER_GOLD));
                player.setCurrRoom(rs.getInt(USERS_COLUMN_CURR_ROOM));
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return player;
    }
    
    public boolean hasItem(int roomId, int itemReqId) {
        //Initialize variables and objects
        Statement stmt = null;
        boolean hasItem = false;
        //create query
        String query = "SELECT " + ROOMS_COLUMN_ITEM + " FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId;
        try {
            stmt = connection.createStatement();
            //execute
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int item_id = rs.getInt(ROOMS_COLUMN_ITEM);
                if(item_id == itemReqId) {
                    hasItem = true;
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }  
        return hasItem;
    }
    
    public boolean hasMonster(int roomId) {
        //Initialize variables and objects
        Statement stmt = null;
        boolean hasMonster = false;
        //create query
        String query = "SELECT " + ROOMS_COLUMN_MONSTER + " FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId;
        try {
            stmt = connection.createStatement();
            //execute
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                int monster_id = rs.getInt(ROOMS_COLUMN_MONSTER);
                if(monster_id != 0) {
                    hasMonster = true;
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return hasMonster;
    }
    
    public boolean removeItemFromRoom(int roomId) {
        //Initialize variables and objects
        Statement stmt = null;
        boolean itemRemoved = false;
        //create query
        String query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 0 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId;
        try {
            stmt = connection.createStatement();
            //execute;
            int count = stmt.executeUpdate(query);
            if(count != 0) {
                itemRemoved = true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return itemRemoved;
    }
    
    public boolean editExit(int roomId, int[] exits) {
        //Initialize variables and objects
        Statement stmt = null;
        boolean exitEdited = false;
        //create query
        String query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_EXIT_1 + " = " + exits[0] + ", " + ROOMS_COLUMN_EXIT_2 + " = " + exits[1]
                + ", " + ROOMS_COLUMN_EXIT_3 + " = " + exits[2] + ", " + ROOMS_COLUMN_EXIT_4 + " = " + exits[3] + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId;
        try {
            stmt = connection.createStatement();
            //execute
            int count = stmt.executeUpdate(query);
            if(count != 0) {
                exitEdited=  true;
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        
        return exitEdited;
    } 
    
    public void fillRoomsWithItems() {
        //Initialize variables and objects
        int max = 10;
        int min = 1;
        Statement stmt = null;
        String query = "";
        for(int i = 2; i < 9; i++) {
            int random = (int)(Math.random() * max + min);
            if(random < 5) {
                 query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 0 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else if(random < 7) {
                 query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 3 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else if(random < 8) {
                 query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 4 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else if(random < 9) {
                 query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 2 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else {
                 query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_ITEM + " = 1 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }  
    }
    
    public void fillRoomsWithMonsters() {
        //initialize variables and objects
        int max = 10;
        int min = 1;
        Statement stmt = null;
        String query = "";
        for(int i = 2; i < 9; i++) {
            int random = (int)(Math.random() * max + min);
            if(random < 1) {
                query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_MONSTER + " = 4 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else if(random < 3){
                query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_MONSTER + " = 2 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else if(random < 6) {
                query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_MONSTER + " = 1 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }else {
                query = "UPDATE " + TABLE_ROOMS + " SET " + ROOMS_COLUMN_MONSTER + " = 3 WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + i;
            }
            try {
                stmt = connection.createStatement();
                stmt.executeUpdate(query);
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }  
    }
    
    public int findMonsterId(int roomId) {
        int monster_id = 0;
        if(hasMonster(roomId)) {
            Statement stmt = null;
            String query = "SELECT " + ROOMS_COLUMN_MONSTER + " FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId;
            try {
                stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while(rs.next()) {
                    monster_id = rs.getInt(ROOMS_COLUMN_MONSTER);
                }
            }catch(SQLException e) {
                e.printStackTrace();
            }
        }
        return monster_id;
    }
    
    
}
