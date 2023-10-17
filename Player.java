public class Player {
    private Creatures activeCreatures; 
    private String strName;
    private Inventory aInventory;

    /**
     * Constructor
     *  initialize the player with name and inventory
     * @param strName the name of player
     * @param aInventory the inventory of player
     */
    public Player(String strName,Inventory aInventory){
        this.strName = strName;
        this.aInventory = aInventory;
    }

    /**
     * Sets the inventory of the player.
     * @param aInventory The inventory to be set.
     */
    public void setInventory(Inventory aInventory){
        this.aInventory = aInventory;
    }
    /**
     * gets the inventory
     * @return the inventory 
     */
    public Inventory getInventory(){
        return aInventory;
    }

    /**
     * Sets the name of the player.
     * @param strName The name to be set.
     */
    public void setPlayerName(String strName){
        this.strName = strName;
    }

    /**
     * Gets the name of the player.
     * @return The name of the player.
     */
    public String getPlayerName(){
        return strName;
    }

    /**
     * Sets the player's active creature and automatically sets it in the inventory.
     * @param creature The creature to be set as active.
     */
    public void setactiveCreature(Creatures creature){
        activeCreatures = creature;
        aInventory.setActiveCreature(creature); 
    }

    /**
     * Gets the active creature of the player.
     * @return The active creature of the player.
     */
    public Creatures getactiveCreature(){
        return activeCreatures;
    }
    
}
