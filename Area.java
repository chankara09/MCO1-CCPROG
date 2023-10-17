import java.util.Scanner;
/**
 * The Area class represents an area in the game.
 * Each area has a grid with rows and columns, a tracker to show where the player is, a list of creatures, and a player.
 * 
 * The class provides methods for printing the area grid, adding random creatures, handling user input, and closing the input scanner.
 * 
 * The area is a 5x1 grid where the player can move up and down. The player can encounter creatures in the area, which triggers a battle phase.
 */
public class Area {
    private Scanner SInputScanner;
    private Integer rows;
    private Integer columns; 
    private Integer Tracker;
    private Creatures nCreatures;
    private Player player;
    boolean exit = false;

    /**
     * Constructor for the Area class.
     * Initializes an Area with a given player, a 5x1 grid, a tracker set at position (0,0), and a set of creatures.
     *
     * @param player The player for whom the Area is being created.
     */
    public Area(Player player){
        SInputScanner = new Scanner(System.in);
        rows = 5; //the area 1 rows
        columns = 1; //the area 1 column
        Tracker = 0; //shows where the player is 
        nCreatures = new Creatures(); //instantiates the creatures 
        nCreatures.createCreatures(); //creates the creatures
        this.player = player; 
    }

    /**
     * Prints the grid for area 1 with the tracker in initially at (0,0)
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
     * if a wild creature appears, this will make way for Battle Phase 
     * @return the randomCreature if 
     */
    public Creatures addRandomCreatures(){
        int randomChance = (int)(Math.random()*100) + 1;
        if(randomChance <= 40){
            Creatures randomCreature = nCreatures.getRandomCreature();
            if (randomCreature != null) {
                System.out.println("A WILD CREATURE APPEARED!:\n" + randomCreature);
                return randomCreature;
            } 
            else{
                System.out.println("NO CREATURES AVAILABLE!");
                return null;
            }
        }
        else{
            System.out.println("NO CREATURES SPAWNED!");
            return null;
        }
    }

    /**
     * asks for user input whether to go up or down the area 1
     * can return back to the display class, playerArea() if user input is 'R'
     */
    public void userInput(){
        Creatures CEnemy = null;
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
                    CEnemy = addRandomCreatures();
                }
            }
            else if(strInput.equalsIgnoreCase("S")){
                if (Tracker < rows - 1) {
                    Tracker++;
                    CEnemy = addRandomCreatures();
                }
            }
            else if(strInput.equalsIgnoreCase("R")){
                return;
            }else if(strInput.isEmpty()){
                System.out.println("[SYSTEM MESSAGE]: No Input provided. \n TRY AGAIN");
            }else{
                System.out.println("\nINVALID.\nTRY AGAIN!");
            }
            if(CEnemy != null){
                BattlePhase battle = new BattlePhase(player, CEnemy, SInputScanner);
                battle.startBattle(player, CEnemy);
            }else{
                continue; 
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
