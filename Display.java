import java.util.Scanner;

public class Display {
    private Scanner SInputScanner; 
    private Player nPlayer;
    private Inventory aInventory;
    private Creatures CCreature;
    private Area aArea;
    boolean exit = false;

    public Display(){
        SInputScanner = new Scanner(System.in);
        CCreature = new Creatures();
        aInventory = new Inventory();
        aArea = new Area();
        nPlayer = new Player("DefaultName", aInventory);
    }
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

    public void playerInventory(){
        Creatures playerActiveCreature = nPlayer.getactiveCreature(); 
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

    public void capturedCreatures(){
        while(!exit){


        }
    }

    public void creaturePedia(){
        while(!exit){
            CCreature.createCreatures(); 
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

    public void closeScanner() {
        SInputScanner.close();
    }
}
