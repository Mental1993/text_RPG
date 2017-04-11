package Model;

public class Movement {
    
    //Initialize variables & objects
    Database db = new Database();
    
    //User wants to go north
    public String north() {
        String output = move(0);
        return output;
    }
    
    //User wants to go south
    public String south() {
        String output = move(2);
        return output;
    }
    
    //User wants to go east
    public String east() {
        String output = move(3);
        return output;
    }
    
    //User wants to go west
    public String west() {
        String output = move(1);
        return output;
    }
    
    //Checks if an exit exists to the direction the user wants to go.
    public String move(int index) {
        String output;
        
        int[] nRoom = Room.currRoom.getExits();
        if(nRoom[index] != 0) {
            Room.currRoom = db.getRoomById(nRoom[index]);
            output = "You are now at room " + Room.currRoom.getRoomId() + "\n" + Room.currRoom.getName() + ".\n";
        }else {
            output = "There is no exit there.\n";
        }
        return output;
    }
    
    public String lookAround() {
        String output = "";
        output += "You are at Room " + Room.currRoom.getRoomId()+ "\n" + Room.currRoom.getName();
        return output;
    }
}
