import java.util.ArrayList;

public class Inventory {
    private String pInventory; //tentative string idk
    private ArrayList<Creatures> pCreatures; //arrays of creatures captured
    private Creatures aCreature; //active creature

    public Inventory(String pInventory){
        this.pCreatures = new ArrayList<Creatures>();
        this.pInventory = pInventory;
    }

    public Inventory(){
        this.pCreatures = new ArrayList<Creatures>();
    }

    /**
     * Constructor
     *  initialize the Inventory with a set of creatures when the inventory object is created 
     * @param initialCreatures creatures to be added to the Creatures[] array
     * i think i did this to "populate" the array list (cud be erased idk)
     */
    public Inventory(Creatures[] initialCreatures) {
        this.pCreatures = new ArrayList<Creatures>();
        for (Creatures creature : initialCreatures) {
            pCreatures.add(creature);
        }
    }

    public void setInitialActiveCreature(Creatures initialActiveCreature) {
        this.aCreature = initialActiveCreature;
        // Add the initial active creature to the captured creatures list if it's not already there.
        if (!pCreatures.contains(initialActiveCreature)) {
            pCreatures.add(initialActiveCreature);
        }
    }


    /**
     * returns the inventory 
     * @return inventory 
     */
    public String getInventory(){
        return pInventory; 
    }

    /**
     * sets the active creative 
     * @param CCreature creature to be set as an active creature 
     */
    public void setActiveCreature(Creatures CCreature){
        this.aCreature = CCreature;
    }

    /**
     * returns the active Creature
     * @return active Creature
     */
    public Creatures getActiveCreature(){
        return aCreature;
    }

    /**
     * checks if the 
     * @param CCreature creature to be added 
     */
    public boolean checkCreatures(){
        Creatures activeCreature = getActiveCreature();
        if (pCreatures.isEmpty()) {
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
        
    /**
     * returns as arraylist of captured creatures 
     * @return captured creatures
     */
    public ArrayList<Creatures> getCapturedCreatures(){
        return pCreatures; 
    }

    /**
     * adds Captured creature to the inventory 
     * @param CCreature creature to be added 
     */
    public void addCaptured(Creatures CCreature){
        pCreatures.add(CCreature);
    }
}
