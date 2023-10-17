public class Player {
    private Creatures activeCreatures; 
    private String strName;
    private Inventory aInventory;

    /**
     * Constructor
     *  initialize the player with name and inventory
     * @param strName and @param aInventory
     */
    public Player(String strName,Inventory aInventory){
        this.strName = strName;
        this.aInventory = aInventory;
    }

    /**
     * setter of inventory
     */
    public void setInventory(Inventory aInventory){
        this.aInventory = aInventory;
    }

    /**
     * setter of player name
     */
    public void setPlayerName(String strName){
        this.strName = strName;
    }

    /**
     * getter of player name
     * @return string 
     */
    public String getPlayerName(){
        return strName;
    }

    /**
     * sets the player's active creature and automatically sets it in the inventory
     * @param creature - active creature
     */
    public void setactiveCreature(Creatures creature){
        activeCreatures = creature;
        aInventory.setActiveCreature(creature); 
    }

    /**
     * getter of player name
     * @return active creature 
     */
    public Creatures getactiveCreature(){
        return activeCreatures;
    }
    
}
