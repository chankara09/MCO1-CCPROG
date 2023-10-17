public class Creatures {
    private String strName;
    private String strType;
    private String strFamily;
    private Integer intLevel;
    private Integer intHealth;
    private Creatures[] arrCreatures;

    public Creatures(String strName, String strType, String strFamily, Integer intLevel){
        this.strName = strName;
        this.strType = strType;
        this.strFamily = strFamily;
        this.intLevel = intLevel;
    }

    public Creatures() {
             // Default constructor
    }

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
    }

    public void creaturesMenu(){
        for (Creatures creature : arrCreatures){
            if(creature.getintLevel().equals(1)){ //if equals to 1
                System.out.println(creature + "\n");
            }
        }
    }

    public void setintHealth(Integer intHealth){
        this.intHealth = intHealth;
    }
    public Integer getintHealth(){
        return intHealth;
    }

    public void setstrName(String strName){
        this.strName = strName;
    }
    public String getstrName(){
        return strName;
    }
    public void setstrType(String strType){
        this.strType = strType;
    }
    public String getstrType(){
        return strType;
    }

    public void setstrFamily(String strFamily){
        this.strFamily = strFamily;
    }
    public String getstrFamily(){
        return strFamily;
    }
    
    public void setintLevel(Integer intLevel){
        this.intLevel = intLevel;
    }
    public Integer getintLevel(){
        return intLevel;
    }

    public String toString(){
        return "CREATURE NAME: " + strName + "\nTYPE: " + strType + "\nFAMILY: " + strFamily + "\nLEVEL: " + intLevel;
    }
}
