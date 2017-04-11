package Model;

import View.mainScreen;
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
    //table items
    private static final String TABLE_ITEMS = "items";
    private static final String ITEMS_COLUMN_ITEM_ID = "item_id";
    private static final String ITEMS_COLUMN_ITEM_NAME = "item_name";
    private static final String ITEMS_COLUMN_ITEM_DESC = "item_desc";
    
    
    private static String connString = "jdbc:mysql://localhost:3306/text_rpg";
    public static Connection connection;
    
    //Attempts connection to the database. Catches the error if it fails.
    public void connect(){
        try {
            connection = DriverManager.getConnection(connString, username, password);
            System.out.println("Connection is OK");
        } catch (SQLException ex) {
            Logger.getLogger(mainScreen.class.getName()).log(Level.SEVERE, null, ex);
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
                Player.get().getInv().add(item);
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
        String query = "SELECT " + ROOMS_COLUMN_ITEM + " FROM " + TABLE_ROOMS + " WHERE " + ROOMS_COLUMN_ROOM_ID + " = " + roomId + "";
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
}
