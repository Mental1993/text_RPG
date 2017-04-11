package Controller;
import Model.Player;
import Model.Movement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class mainController {

    //Declare variables and objects
    Movement movement = new Movement();
    
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
            case HELP:
                TAoutput = help();
                break;
            case EXIT:
                //MISSING ---- User confirm on exit
                System.exit(0);
                break;
            case LOOK:
                TAoutput = movement.lookAround();
                break;
            case NONE:
                TAoutput = "Invalid command (\"" + input + "\").\nType \"help\" to see all the avaliable commands."; 
                break;
            default:
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
    
    //A static help message
    public String help() {
        String output = "";
        output += "- help  View all the avaliable commands.\n- exit  Exit the game.\n- go <direction>  Move to another room. Avaliable directions are : North, West, South, East\n";
        output += "- inventory Shows all the items that the player currently has avaliable.\n- pick <item> Pick an item from the ground (if exists).\n";
        return output;
    }
    
    //Enum for Commands
    public enum Commands {
        GO_NORTH,
        GO_WEST,
        GO_SOUTH,
        GO_EAST,
        PICK_BRONSE_SWORD,
        INVENTORY,
        HELP,
        LOOK,
        EXIT,
        NONE
    }
    
}
