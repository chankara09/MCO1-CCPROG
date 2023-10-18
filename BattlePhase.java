import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
/**
 * The BattlePhase class represents a battle phase in the game.
 * Each battle phase involves a player, an enemy creature, and a scanner for user input.
 * 
 * The class provides methods for starting a battle, attacking the enemy creature, swapping the active creature, and attempting to catch the enemy creature.
 * 
 * The battle phase continues until the player has no actions left or the enemy creature is caught.
 */
public class BattlePhase {
    private Player player;
    private Creatures CEnemy;
    private Scanner SC;

    /**
     * Constructor
     * Initializes the BattlePhase with a specific player, enemy creature, and scanner.
     * 
     * @param player The player participating in the battle.
     * @param CEnemy The enemy creature in the battle.
     * @param SC The scanner for user input.
     */
    public BattlePhase(Player player, Creatures CEnemy, Scanner SC){
        this.player = player;
        this.CEnemy = CEnemy; 
        this.SC = SC;
        CEnemy.setintHealth(50);
    }

    /**
     * Starts a battle between the player's active creature and the encountered creature.
     * The battle continues until the player has no actions left or the enemy creature is caught.
     *
     * @param player - the player instance participating in the battle
     * @param CEnemy - the encountered creature the player is battling against
     */
    public void startBattle(Player player, Creatures CEnemy){
        Creatures A_Creature = player.getInventory().getActiveCreature();
        int nActions = 3;
        boolean catchResult = false;
        CEnemy.setintHealth(50);
        
        while(nActions > 0){
            System.out.println(".......................");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println("    CHOOSE AN ACTION    ");
            System.out.println("~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~");
            System.out.println(".......................");
            System.out.println("[1]:      ATTACK       |");
            System.out.println(".......................");
            System.out.println("[2]:      SWAP         |");
            System.out.println(".......................");
            System.out.println("[3]:      CATCH        |");
            System.out.println(".......................");
            System.out.println("[4]      RUNAWAY       |");
            System.out.println(".......................");
            System.out.print("[INPUT]:");
            int nAction = SC.nextInt();

            switch(nAction){
                case 1: Attack(A_Creature);
                    break;
                case 2: if(player.getInventory().checkCreatures()){
                    Swap();
                }else{
                    System.out.println("[SYSTEM MESSAGE]: NO AVAILABLE CREATURES TO SWAP");
                    continue;
                }
                break;
                case 3: catchResult = isCaught();
                        if(catchResult == true && nActions > 0){
                            nActions = 0;
                        }
                        break;
                case 4: nActions = 0;
                return; 
            };
            nActions--;
            if(nActions == 0 && catchResult == false){
                System.out.println("[ENEMY RAN AWAY!!]");
            }
            SC.nextLine();
        }
    }

    /**
     * Attacks the enemy creature, deducting its health by a damage value computed based on the active creature's level.
     * The damage is calculated as a random number between 1 and 10, multiplied by the active creature's level, and then multiplied by 1.5.
     * The enemy's health is then reduced by this damage value.
     *
     * @param A_Creature - the active creature that is attacking
     */
    public void Attack(Creatures A_Creature){
        double dDamage = new Random().nextInt(10) + 1 * A_Creature.getintLevel();
        dDamage *= 1.5;
        //not yet implemented if the enemy is stronger than active creature condition
        CEnemy.setintHealth(CEnemy.getintHealth() - dDamage);
        System.out.println("[ATTACK SUCCESFUL]: YOU DEALT " + dDamage + " DAMAGE TO THE ENEMY");
    } 

    /**
     * Allows the player to swap their active creature with another creature from their captured creatures list.
     * The player is presented with a list of their captured creatures and asked to select one to set as the active creature.
     * If the player's choice is valid, the selected creature becomes the active creature.
     */
    public void Swap(){
        ArrayList<Creatures> capturedCreatures = player.getInventory().getCapturedCreatures();
        for (int i = 0; i < capturedCreatures.size(); i++) {
            System.out.println((i+1) + ": " + capturedCreatures.get(i).getstrName()); 
        }
        // Ask the user to select a creature
        System.out.println("SELECT A CREATURE TO SET AS ACTIVE (enter the number): ");
        int creatureChoice = SC.nextInt();
        // Set the selected creature as active
        if (creatureChoice > 0 && creatureChoice <= capturedCreatures.size()) {
            Creatures selectedCreature = capturedCreatures.get(creatureChoice - 1);
            player.getInventory().setActiveCreature(selectedCreature);
            System.out.println("ACTIVE CREATURE IS NOW: " + selectedCreature.getstrName());
        } else {
            System.out.println("INVALID CHOICE! NO CHANGES MADE");
        }
    }
    
    /**
     * Attempts to catch the enemy creature.
     * The catch rate is calculated based on the enemy's health, and a random number is generated.
     * If the random number is less than the catch rate, the enemy is caught and added to the player's inventory.
     *
     * @return true if the enemy is caught, false otherwise
     */
    public boolean isCaught(){
        double nCatchRate = 40 + 50 - CEnemy.getintHealth();
        int nRand = new Random().nextInt(100);
        if(nRand < nCatchRate){
            player.getInventory().addCaptured(CEnemy);
            System.out.println("SUCCESSFULLY CAUGHT THE ENEMY!");
            return true;
        }else {
            System.out.println("CATCH UNSUCCESSFUL");
            return false;
        }
        
    }

}

