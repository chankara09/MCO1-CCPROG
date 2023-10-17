import java.util.Random;
/**
 * The Creatures class represents a creature in the game.
 * Each creature has a name, type, family, level, and health.
 * 
 * The class provides two constructors: one for creating a specific creature with a given name, type, family, and level, 
 * and another for creating an array of predefined creatures.
 * 
 * The class provides methods for creating the array of creatures, displaying a menu of creatures with level 1, 
 * getting a random creature from the array, and setting and getting the name, type, family, level, and health of a creature.
 * 
 * The class also overrides the toString method to provide a string representation of a creature.
 */
public class Creatures {
    private String strName;
    private String strType;
    private String strFamily;
    private int intLevel;
    private double intHealth;
    private Creatures[] arrCreatures; //array of instantiated creatures

    /**
     * Constructor
     * Initializes a creature with a name, type, family, and level.
     *
     * @param strName The name of the creature.
     * @param strType The type of the creature.
     * @param strFamily The family of the creature.
     * @param intLevel The level of the creature.
     */
    public Creatures(String strName, String strType, String strFamily, Integer intLevel){
        this.strName = strName;
        this.strType = strType;
        this.strFamily = strFamily;
        this.intLevel = intLevel;
    }

    /**
     * Constructor
     *  initializes to create the array list of creatures
     */
    public Creatures() {
            createCreatures();

    }

    /**
     * Creates array of Creatures with predefined names, types, family, and level
     */
    public void createCreatures(){
        arrCreatures = new Creatures[] {
             new Creatures("Strawander", "Fire", "A", 1),
             new Creatures("Chocowool", "Fire", "B", 1),
             new Creatures("Parfwit", "Fire", "C", 1),
             new Creatures("Brownisaur", "Grass", "D", 1),
             new Creatures("Frubat", "Grass", "E", 1),
             new Creatures("Malts", "Grass", "F", 1),
             new Creatures("Squirpie", "Water", "G", 1),
             new Creatures("Chocolite", "Water", "H", 1),
             new Creatures("Oshacone", "Water", "I", 1)
         };

         for (Creatures creature : arrCreatures){
            creature.setintHealth(50);
        }
    }

    /**
     * Prints the creatures if their level is 1.
     * Iterates through the array of creatures and prints each creature whose level is 1.
     */
    public void creaturesMenu(){
        for (Creatures creature : arrCreatures){
            if(creature.getintLevel() == 1){ //if equals to 1
                System.out.println(creature + "\n");
            }
        }
    }

    /**
     * gets a random creature from the array of instantiated creatures.
     * If the array is not null and has at least one creature, a random index is generated and the creature at that index is returned.
     * If the array is null or empty, a message is printed and null is returned.
     *
     * @return A random creature, or null if the array is null or empty.
     */
    public Creatures getRandomCreature(){
        if (arrCreatures != null && arrCreatures.length > 0) {
            Random random = new Random();
            int randomIndex = random.nextInt(arrCreatures.length);
            return arrCreatures[randomIndex];
        }
        else{
            System.out.println("NO CREATURES");
            return null;
        }
       
    }
    /**
     * sets the creature's health 
     * @param intHealth the creatur's health 
     */
    public void setintHealth(double intHealth){
        this.intHealth = intHealth;
    }
    /**
     * gets health of creature
     * @return health of creature 
     */
    public double getintHealth(){
        return intHealth;
    }

    /**
     * sets creature's name
     * @param strName creature's name
     */
    public void setstrName(String strName){
        this.strName = strName;
    }
    /**
     * gets creature's name
     * @return string
     */
    public String getstrName(){
        return strName;
    }

    /**
     * sets the creature's type
     * @param strType creature's type
     */
    public void setstrType(String strType){
        this.strType = strType;
    }
    /**
     * gets creature's type
     * @return creature's type
     */
    public String getstrType(){
        return strType;
    }

    /**
     * sets the creatures family
     * @param strFamily creature's family
     */
    public void setstrFamily(String strFamily){
        this.strFamily = strFamily;
    }
    /**
     * gets creature's family
     * @return string creature's family
     */
    public String getstrFamily(){
        return strFamily;
    }
    
    /**
     * sets creature's evolution level
     * @param intLevel creature'e evolution level
     */
    public void setintLevel(int intLevel){
        this.intLevel = intLevel;
    }
    /**
     * Gets the level of the creature.
     8
     * @return The level of the creature as a double.
     */
    public double getintLevel(){
        return intLevel;
    }

    /**
     * returns a string representation of Creature 
     * @return A string that contains the name, type, family, and level of Creature.
     */
    public String toString(){
        return "CREATURE NAME: " + strName + "\nTYPE: " + strType + "\nFAMILY: " + strFamily + "\nLEVEL: " + intLevel;
    }
}
