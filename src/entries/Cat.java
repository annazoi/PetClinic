package entries;

import java.util.Date;

public class Cat extends Pet {
    
    /**
     * @constructor (default) of Cat class
     */
    public Cat () {}
    
    public Cat (String name) {}
    
    public Cat (String name, String owner, String address, int age, Date introDate, boolean male) {
        super(name, owner, address, age, introDate,male);
    	
    }
 
    @Override
    public String toString () {
    	String gender = getMale() ? "Male" : "Female";
    	return getName() + " [Owner: "+ getOwner() +"] [Address: " +getAddress()+ "] [Age: "+getAge()+ "] [IntroDate: " +getIntroDate()+ "] [Male: " +getMale()+"] ";
    }

	@Override
        public void getPetInfo() {
        System.out.println(" [Name: " +getName()+ "] [Owner: " +getOwner()+ "] [Address: " +getAddress()+ "] [Age: " +getAge()+ "] [IntroDate: "  +getIntroDate()+ "] [Male: " +getMale()+"] ");
    }
}