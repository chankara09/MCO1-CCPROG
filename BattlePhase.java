import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class BattlePhase {
    private Player player;
    private Creatures CEnemy;
    private Scanner SC;

    public BattlePhase(Player player, Creatures CEnemy, Scanner SC){
        this.player = player;
        this.CEnemy = CEnemy; 
        this.SC = SC;
        CEnemy.setintHealth(50);
    }

    /**
     * starts the battle between players active creature and the encountered creature
     * @param player the player instance 
     * @param CEnemy the encountered creature
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
                        break;
                case 4: return; 
            };
            nActions--;
            if(nActions == 0 && catchResult == false){
                System.out.println("[ENEMY RAN AWAY!!]");
            }
            SC.nextLine();
        }
    }

    /**
     * deducts the Enemy’s health by a damage value computed
     * @param A_Creature the active creature 
     */
    public void Attack(Creatures A_Creature){
        double dDamage = new Random().nextInt(10) + 1 * A_Creature.getintLevel();
        dDamage *= 1.5;
        //not yet implemented if the enemy is stronger than active creature condition
        CEnemy.setintHealth(CEnemy.getintHealth() - dDamage);
        System.out.println("[ATTACK SUCCESFUL]: YOU DEALT " + dDamage + " DAMAGE TO THE ENEMY");
    } 

    /**
     * allows player to swap
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

