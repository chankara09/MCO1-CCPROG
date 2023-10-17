import java.util.Scanner;

public class Area {
    private Scanner SInputScanner;
    private Integer rows;
    private Integer columns; 
    private Integer Tracker;
    private Creatures nCreatures;
    boolean exit = false;

    public Area(){
        SInputScanner = new Scanner(System.in);
        rows = 5; //the area 1 rows
        columns = 1; //the area 1 column
        Tracker = 0; //shows where the player is 
        nCreatures = new Creatures(); //instantiates the creatures 
        nCreatures.createCreatures(); //creates the creatures
    }

    /**
     * prints area1 with the tracker in initially at 0,0
     * 
     */
    public void gridArea1(){
        System.out.println(".......................");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i == Tracker) {
                    System.out.print("[*]"); // Print the tracker
                } else {
                    System.out.print("[ ]");
                }
            }
            System.out.println();
        }
        System.out.println(".......................");
    }

     /**
     * randomizes the chance that a creature will appear, 
     * if a wild creature appears, this will make way for Battle Phase (call battle phase that has its own menu/thingy in the battle phase class) (do-while)
     * 
     */
    public void addRandomCreatures(){
        int randomChance = (int)(Math.random()*100) + 1;
        if(randomChance <= 40){
            Creatures randomCreature = nCreatures.getRandomCreature();
            if (randomCreature != null) {
                System.out.println("A WILD CREATURE APPEARED!:\n" + randomCreature);
            } 
            else {
                System.out.println("NO CREATURES AVAILABLE!");
            }
        }
        else{
            System.out.println("NO CREATURES SPAWNED!");
        }
    }

    /**
     * asks for user input whether to go up or down the area 1
     * can return back to the display class, playerArea() if user input is 'R'
     */
    public void userInput(){
        while(!exit){
            gridArea1();
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("MOVE USING 'W' FOR UP AND \n'S' FOR DOWN. \n'R' TO RETURN.");    
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.print("[INPUT] : ");
            String strInput = SInputScanner.nextLine();

            if(strInput.equalsIgnoreCase("W")){
                if (Tracker > 0) {
                    Tracker--;
                    addRandomCreatures();
                }
            }
            else if(strInput.equalsIgnoreCase("S")){
                if (Tracker < rows - 1) {
                    Tracker++;
                    addRandomCreatures();
                }
            }
            else if(strInput.equalsIgnoreCase("R")){
                return;
            }
            else{
                System.out.println("\nINVALID.\nTRY AGAIN!");
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
