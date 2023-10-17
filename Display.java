import java.util.Scanner;

public class Display {
    private Scanner SInputScanner; // the whole class' scanner of the user input
    private Player nPlayer; //access modifier of the player class
    private Inventory aInventory; //access modifier of the inventory class
    private Creatures CCreature; //access modifier of the creature class
    private Area aArea; //access modifier of the area class
    boolean exit = false; //the whole class' boolean 

    /**
     * The Display's own constructor
     * 
     */
    public Display(){
        SInputScanner = new Scanner(System.in); //scanner
        CCreature = new Creatures(); //instantiates the playing new creatures
        aInventory = new Inventory(); //instantiates the playing new inv
        aArea = new Area(); //instantiates the playing new area
        nPlayer = new Player("DefaultName", aInventory); //the player's default name and inv
    }

    /**
     * Displays the start Menu 
     * Takes the user input to either start or exit the game
     */
    public void startMenu(){
        while(!exit){
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(" WELCOME TO POKEMON(TM)");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 1 |    START GAME   |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 2 |      EXIT       |");
            System.out.println(".......................");
 

            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1: getNewPlayerName(); break;
                case 2: exit = true; break;
                default: System.out.println("INVALID CHOICE!"); 
            }
        }
    }

    /**
     * Displays getting the player's Name
     * Takes the user input to get the player name if the input is not null, 
     * if null returns to the startMenu()
     */
    public void getNewPlayerName(){
        while(!exit){
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("    ENTER YOUR NAME    ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.print("[INPUT] : ");
            SInputScanner.nextLine();
            String strInput = SInputScanner.nextLine();
            if(!strInput.isEmpty()){
                Player newPlayer = new Player(strInput, aInventory);
                newPlayer.setPlayerName(strInput);
                System.out.println("WELCOME, " + newPlayer.getPlayerName() + "!");
                starterMenu();
                break;
            }
            else{
                System.out.println("INVALID NAME!"); 
                return;
            }
        }
    }

    /**
     * Displays the starterMenu
     * Takes the user input to get the player's starter creature, 
     * returns to startMenu() if user input is 4
     */
    public void starterMenu(){
        while(!exit){
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("PICK A STARTER CREATURE");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 1 |    STRAWANDER   |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 2 |    BROWNISAUR   |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 3 |     SQUIRPIE    |");
            System.out.println(".......................");
            System.out.println(".................................");
            System.out.println("PRESS '4' RETURN TO START MENU...");
            System.out.println(".................................");


            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1: Creatures Strawander = new Creatures("Strawander", "Fire", "A", 1);
                        nPlayer.setactiveCreature(Strawander);
                        System.out.print("\nYOUR ACTIVE CREATURE NOW IS: STRAWANDER"); playerMenu(); break;
                case 2: Creatures Brownisaur = new Creatures("Brownisaur", "Grass", "D", 1);
                        nPlayer.setactiveCreature(Brownisaur);
                        System.out.print("\nYOUR ACTIVE CREATURE NOW IS: BROWNISAUR"); playerMenu(); break;
                case 3: Creatures Squirpie = new Creatures("Squirpie", "Water", "G", 1);
                        nPlayer.setactiveCreature(Squirpie);
                        System.out.print("\nYOUR ACTIVE CREATURE NOW IS: SQUIRPIE"); playerMenu(); break;
                case 4: startMenu(); break;
                default: System.out.println("INVALID CHOICE!"); 
            }
        }
    }

    /**
     * Displays the playerMenu
     * Takes the user input to either go to Area or Inventory
     * returns to startMenu() if user input is 3
     */
    public void playerMenu(){
        while(!exit){
            System.out.println("\n");
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("      PLAYER MENU      ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 1 |      AREA       |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 2 |    INVENTORY    |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 3 |   START MENU    |");
            System.out.println(".......................");
            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1: playerArea(); break;
                case 2: playerInventory(); break;
                case 3: startMenu(); break;
                default: System.out.println("INVALID CHOICE!");
            }
        }
    }

    /**
     * Displays the playerArea Menu
     * Takes the user input to either go to 1st Area or
     * returns to playerMenu() if user input is 2
     */
    public void playerArea(){
        while(!exit){
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("          AREA         ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 1 |        1        |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 2 |      RETURN     |");
            System.out.println(".......................");
            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1: aArea.userInput(); break;
                case 2: return;
                default: System.out.println("INVALID CHOICE!");
            }
        
        }
    }

    /**
     * Displays the playerInventory Menu and Active Creature
     * Takes the user input to either change active creature, check creaturepedia, and see the captured creatures
     * returns to playerMenu() if user input is 5
     */
    public void playerInventory(){
        Creatures playerActiveCreature = nPlayer.getactiveCreature(); //shows the current active creature
        while(!exit){
            System.out.println("...............................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("           INVENTORY           ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("...............................");
            System.out.println("|CURRENT AC: " + playerActiveCreature + " |");
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("| 1 |  CHANGE ACTIVE CREATURE |");
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("| 2 |      CREATUREPEDIA      |");
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("| 3 |    CAPTURED CREATURES   |"); //not yet done       
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("| 4 |      EVOLUTION *soon    |");
            System.out.println("...............................");
            System.out.println("...............................");
            System.out.println("| 5 |          RETURN         |");
            System.out.println("...............................");

            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1:  changeActiveCreature(); break;
                case 2:  creaturePedia(); break;
                case 3:  System.out.print("\nTEST3"); break;
                case 4:  System.out.print("\nTEST4"); break;
                case 5:  return;
                default: System.out.println("INVALID CHOICE!");
            }
        }
    }

    /**
     * Displays the active Creture
     * Checks if he current creature array only has the current Active creature, if yes only says you have the current active creature and returns 
     * else, it displays the list of captured creatures for the player to choose 
     * (to be modified to take a creature and set it as current active creature and has the option to return)
     */
    public void changeActiveCreature(){
        while(!exit){
            if (!aInventory.checkCreatures()) {
                System.out.println("You only have " + aInventory.getActiveCreature());
                return;
            }
            else{
                System.out.println("...............................");
                System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                System.out.println("   LIST OF CAPTURED CREATURES  ");
                System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
                System.out.println("...............................");
                //display captured creatures thru arraylist
                System.out.println("...............................");
                return;
            }
        }
    }

    /**
     * Displays the player's captured creatures 
     * Similar to changeActiveCreature()'s list of captured creatures
     * Should be able to return
     */
    public void capturedCreatures(){
        while(!exit){


        }
    }

    /**
     * Displays the creaturePedia
     * Takes the user input to check the list of catchable creatures (currently level 1 only)
     * returns to playerMenu() if user input is 2
     */
    public void creaturePedia(){
        while(!exit){
            CCreature.createCreatures(); //creates the creatures
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("   LIST OF CREATURES   ");
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println("| 1 |     LEVEL 1     |");
            System.out.println(".......................");
            System.out.println(".......................");
            System.out.println("| 2 |     RETURN      |");
            System.out.println(".......................");
            System.out.print("[INPUT] : ");
            int strInput = SInputScanner.nextInt();

            switch(strInput){
                case 1: CCreature.creaturesMenu(); break;
                case 2: return;
                default: System.out.println("INVALID CHOICE!");
            }
        }
    }

     /**
     * 
     * Closes the input scanner
     */
    public void closeScanner() {
        SInputScanner.close();
    }
}
