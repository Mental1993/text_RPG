package Controller;
import Model.Database;
import Model.Player;
import Model.Movement;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class mainController {

    //Declare variables and objects
    Movement movement = new Movement();
    Database db = new Database();
    public static Date currDate = new Date();
    public static boolean isNight;
    
    String TAoutput;
   
    //Constructor
    public mainController() {
        this.TAoutput = "";
        
    }
    
    //Setters & Getters
    public String getTAoutput() {
        return this.TAoutput;
    }
    
    //Checks the user input command.
    public void proccessInput(String input){
        
        input = input.replace(' ', '_');
        Commands cmd;
        try {
            cmd = Commands.valueOf(input.toUpperCase());
        }catch(Exception e) {
            cmd = Commands.NONE;
        }
            switch(cmd) {
                case GO_NORTH:
                    TAoutput = movement.north();
                    break;
                case GO_WEST:
                    TAoutput = movement.west();
                    break;
                case GO_SOUTH:
                    TAoutput = movement.south();
                    break;
                case GO_EAST:
                    TAoutput = movement.east();
                    break;
                case INVENTORY:
                    TAoutput = Player.get().showInventory();
                    break;
                case PICK_BRONSE_SWORD:
                    TAoutput = Player.get().pickItem(3);
                    break;
                case PICK_IRON_SWORD:
                    TAoutput = Player.get().pickItem(4);
                    break;
                case PICK_DUSTY_KEY:
                    TAoutput = Player.get().pickItem(1);
                    break;
                case PICK_FIRE_TORCH:
                    TAoutput = Player.get().pickItem(2);
                    break;
                case HELP:
                    TAoutput = help();
                    break;
                case EXIT:
                    TAoutput = exit();
                    break;
                case LOOK:
                    TAoutput = movement.lookAround();
                    break;
                case SAVE:
                    //MISSING ----- SAVE FUNCTION
                    break;
                case NONE:
                    input = input.replace('_', ' ');
                    TAoutput = "Invalid command (\"" + input + "\").\nType \"help\" to see all the avaliable commands."; 
                    break;
                default:
                    input = input.replace('_', ' ');
                    TAoutput = "Invalid command (\"" + input + "\").\nType \"help\" to see all the avaliable commands."; 
        }
        
    }
    
    //Updates the textArea accordingly.
    public void updateTextArea(JTextArea ta, String txt) {
        ta.append(txt);
    }
    
    //Updates the image accordingly.
    public void updateImage(JLabel Limage, ImageIcon img) {
        Limage.setIcon(img);
        
    }
    
    public void updateNight() {
        if(isNight) {
            int[] exits = new int[] {0,9,2,0};
            db.editExit(1,exits);
        }else {
            int[] exits = new int[] {0,0,2,0};
            db.editExit(1,exits);
        }
    }
    
    //A static help message
    public String help() {
        String output = "";
        output += "- help  View all the avaliable commands.\n- exit  Exit the game.\n- go <direction>  Move to another room. Avaliable directions are : North, West, South, East\n";
        output += "- inventory Shows all the items that the player currently has avaliable.\n- pick <item> Pick an item from the ground (if exists).\n";
        output += "- look Displays the current room's description and any item if avaliable.\n";
        return output;
    }
    
    //Exit function
    public String exit() {
        int confirm = JOptionPane.showOptionDialog(null,
            "Are You Sure to Close this Application?",
            "Exit Confirmation", JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE, null, null, null);
            if (confirm == JOptionPane.YES_OPTION) {
                System.exit(0);   
            }
            return "";
    }
    
    //Enum for Commands
    public enum Commands {
        GO_NORTH,
        GO_WEST,
        GO_SOUTH,
        GO_EAST,
        PICK_BRONSE_SWORD,
        PICK_IRON_SWORD,
        PICK_DUSTY_KEY,
        PICK_FIRE_TORCH,
        INVENTORY,
        HELP,
        LOOK,
        EXIT,
        SAVE,
        NONE
    }
    
}
