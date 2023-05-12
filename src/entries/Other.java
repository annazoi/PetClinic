package entries;

import java.util.Date;

public class Other extends Pet {
    /**
     * @constructor (default) of Cat class
     */
    public Other () {}
    
    
    public Other (String name, String owner, String address, int age, boolean male) {
    	super(name, owner, address, age, male);
        
    }
    
    @Override
    public String toString () {
    	String gender = getMale() ? "Male" : "Female";
    	return getName() + " [Owner: "+ getOwner() +"] [Address: " +getAddress()+ "] [Age: "+getAge()+ "] ";
    }

	@Override
	public void getPetInfo() {
		// TODO Auto-generated method stub
		
	}
    
}



