package entries;

import java.util.Date;

public class Dog extends Pet{
    private Boolean needsHaircat;
    
    public Dog () {}
    
    public Dog (String name) {}
    
    public Dog (String name, String owner, String address, int age, Date introDate,boolean male, boolean needsHaircat) {
    	super(name, owner, address, age, introDate, male);
        this.needsHaircat = needsHaircat;
    }

    /**
     * @return the needsHaircat
     */
    public Boolean getNeedsHaircat() {
        return needsHaircat;
    }

    /**
     * @param needsHaircat the needsHaircat to set
     */
    public void setNeedsHaircat(Boolean needsHaircat) {
        this.needsHaircat = needsHaircat;
    }
    
    @Override
    public String toString () {
    	String gender = getMale() ? "Male" : "Female";
    	String haircat = needsHaircat ? "Needs Haircat" : "Doesn't need Haircat";
    	return getName() + " [Owner: "+ getOwner() +"] [Address: " +getAddress()+ "] [Age: "+getAge()+ "] [IntroDate: " +getIntroDate()+ "] [Male: " +getMale()+"] [Needs Haircat: " +needsHaircat+ "] ";
    }
    
    @Override
    public void getPetInfo() {
        System.out.println(" [Name: " +getName()+ "] [Owner: " +getOwner()+ "] [Address: " +getAddress()+ "] [Age: " +getAge()+ "] [IntroDate: "  +getIntroDate()+ "] [Male: " +getMale()+"] [Needs Haircat: " +needsHaircat+ "] ");
    }
}