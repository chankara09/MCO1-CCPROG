public class Player {
    private Creatures activeCreatures; 
    private String strName;
    private Inventory aInventory;

    public Player(String strName,Inventory aInventory){
        this.strName = strName;
        this.aInventory = aInventory;
    }

    public void setInventory(Inventory aInventory){
        this.aInventory = aInventory;
    }

    public void setPlayerName(String strName){
        this.strName = strName;
    }

    public String getPlayerName(){
        return strName;
    }

    public void setactiveCreature(Creatures creature){
        activeCreatures = creature;
        aInventory.setActiveCreature(creature); 
    }
    public Creatures getactiveCreature(){
        return activeCreatures;
    }
    
}
