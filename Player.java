/**
 * The Player class represents a player in the game. 
 * It includes properties for the player's name, active creature, and inventory.
 * The class provides methods for getting and setting these properties.
 * 
 * Each player has an active creature and an inventory. The active creature is the one currently in use or in battle.
 * The inventory is a collection of creatures that the player has collected.
 * 
 * This class is a part of the game's player management system and is used to keep track of each player's state.
 */
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
