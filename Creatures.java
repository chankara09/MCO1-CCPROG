import java.util.Random;

public class Creatures {
    private String strName;
    private String strType;
    private String strFamily;
    private int intLevel;
    private double intHealth;
    private Creatures[] arrCreatures; //array of instantiated creatures

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
     * Creates array of Creatures 
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
     * prints the creatures if the int level is 1
     */
    public void creaturesMenu(){
        for (Creatures creature : arrCreatures){
            if(creature.getintLevel() == 1){ //if equals to 1
                System.out.println(creature + "\n");
            }
        }
    }

    /**
     * randomizes the creatures by taking it from the array of instantialized creatures
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
     * setter of inthealth
     */
    public void setintHealth(double intHealth){
        this.intHealth = intHealth;
    }
    /**
     * getter of inthealth
     * @return integer
     */
    public double getintHealth(){
        return intHealth;
    }

    /**
     * setter of creature name
     */
    public void setstrName(String strName){
        this.strName = strName;
    }
    /**
     * getter of creature name
     * @return string
     */
    public String getstrName(){
        return strName;
    }

    /**
     * setter of creature type
     */
    public void setstrType(String strType){
        this.strType = strType;
    }
    /**
     * getter of creature type
     * @return string
     */
    public String getstrType(){
        return strType;
    }

    /**
     * setter of creature family
     */
    public void setstrFamily(String strFamily){
        this.strFamily = strFamily;
    }
    /**
     * getter of creature family
     * @return string
     */
    public String getstrFamily(){
        return strFamily;
    }
    
    /**
     * setter of int level
     */
    public void setintLevel(int intLevel){
        this.intLevel = intLevel;
    }
    /**
     * getter of int level
     * @return int
     */
    public double getintLevel(){
        return intLevel;
    }

    /**
     * reruns a string representation of Creature 
     * @return A string that contains the name, type, family, and level of Creature.
     */
    public String toString(){
        return "CREATURE NAME: " + strName + "\nTYPE: " + strType + "\nFAMILY: " + strFamily + "\nLEVEL: " + intLevel;
    }
}
