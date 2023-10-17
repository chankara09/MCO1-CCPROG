import java.util.ArrayList;

public class Inventory {
    private String pInventory; //tentative string idk
    private ArrayList<Creatures> pCreatures;
    private Creatures A_Creature; 

    public Inventory(String pInventory){
        this.pCreatures = new ArrayList<Creatures>();
        this.pInventory = pInventory;
       // iPlayer.setactiveCreature(creature); // Set the active creature here
    }

    public Inventory(){
        //normal constructor
    }

    public String getInventory(){
        return pInventory; 
    }

    public void setActiveCreature(Creatures CCreature){
        this.A_Creature = CCreature;
    }

    public Creatures getActiveCreature(){
        return A_Creature;
    }

    public boolean checkCreatures(){
        Creatures activeCreature = getActiveCreature();
        if (pCreatures == null) {
            //System.out.println("The ArrayList is null.");
            return false;
        } else {
            if (pCreatures.size() == 1 && pCreatures.contains(activeCreature)) {
                System.out.println("The ArrayList only contains the activeCreature.");
                return false;
            } else {
                System.out.println("The ArrayList contains other creatures.");
                return true;
            }
        }
    }

    public void playerCreatures(Creatures CCreature){
        pCreatures.add(CCreature);
    }
}
