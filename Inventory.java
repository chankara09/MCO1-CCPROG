import java.util.ArrayList;
/**
 * The Inventory class represents an inventory of creatures in the game.
 * Each inventory has an identifier, a list of captured creatures, and an active creature.
 * 
 * The class provides three constructors: one for creating an inventory with a specific identifier, 
 * one for creating an empty inventory, and one for creating an inventory with a set of initial creatures.
 * 
 * The class provides methods for setting and getting the active creature, checking if the inventory contains other creatures, 
 * getting the list of captured creatures, and adding a captured creature to the inventory.
 */
public class Inventory {
    private String pInventory; //tentative string idk
    private ArrayList<Creatures> pCreatures; //arrays of creatures captured
    private Creatures aCreature; //active creature

    /**
     * Constructor
     * Initializes the Inventory with a specific inventory identifier.
     * 
     * @param pInventory The identifier for the inventory.
     */
    public Inventory(String pInventory){
        this.pCreatures = new ArrayList<Creatures>();
        this.pInventory = pInventory;
    }
    /**
     * Constructor
     * Initializes an empty Inventory.
     */
    public Inventory(){
        this.pCreatures = new ArrayList<Creatures>();
    }

    /**
     * Constructor
     * Initialize the Inventory with a set of creatures when the inventory object is created 
     * 
     * @param initialCreatures creatures to be added to the Creatures[] array
     */
    public Inventory(Creatures[] initialCreatures) {
        this.pCreatures = new ArrayList<Creatures>();
        for (Creatures creature : initialCreatures) {
            pCreatures.add(creature);
        }
    }
    /**
     * Sets the initial active creature.
     * @param initialActiveCreature The creature to be set as an initial active creature.
 */
    public void setInitialActiveCreature(Creatures initialActiveCreature) {
        this.aCreature = initialActiveCreature;
        // Add the initial active creature to the captured creatures list if it's not already there.
        if (!pCreatures.contains(initialActiveCreature)) {
            pCreatures.add(initialActiveCreature);
        }
    }

    /**
     * gets the inventory 
     * @return inventory 
     */
    public String getInventory(){
        return pInventory; 
    }

    /**
     * Sets the active creature.
     * 
     * @param CCreature The creature to be set as an active creature.
     */
    public void setActiveCreature(Creatures CCreature){
        this.aCreature = CCreature;
    }

    /**
     * gets the active Creature
     * @return active Creature
     */
    public Creatures getActiveCreature(){
        return aCreature;
    }

    /**
     * Checks if the inventory contains other creatures besides the active one.
     * 
     * @return true if the inventory contains other creatures, false otherwise.
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
     * gets an arraylist of captured creatures 
     * @return an arraylist of captured creatures
     */
    public ArrayList<Creatures> getCapturedCreatures(){
        return pCreatures; 
    }

    /**
     * Adds a captured creature to the inventory.
     * 
     * @param CCreature The creature to be added to the inventory.
     */
    public void addCaptured(Creatures CCreature){
        pCreatures.add(CCreature);
    }
}
