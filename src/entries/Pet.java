package entries;

import java.util.Date;

// Me tin abstract class mporoume na orisoume metavlites alla oxi ena new object
public abstract class Pet {
    
    private String name;
    private String owner;
    private String address;
    private int age;
//    private Date introDate;
    private Boolean male;

    /**
     * @return the name
     */
    
    public Pet() {}
    
    public Pet (String name, String owner, String address, int age, boolean male) {
        this.name = name;
        this.owner = owner;
        this.address = address;
        this.age = age;
//        this.introDate = introDate;
        this.male = male;   
    }
            
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the introDate
     */
//    public Date getIntroDate() {
//        return introDate;
//    }

    /**
     * @param introDate the introDate to set
     */
//    public void setIntroDate(Date introDate) {
//        this.introDate = introDate;
//    }

    /**
     * @return the male
     */
    public Boolean getMale() {
        return male;
    }

    /**
     * @param male the male to set
     */
    public void setMale(Boolean male) {
        this.male = male;
    }
    
    public String toString () {
    	String gender = male ? "male" : "female";
    	return name + " [Owner: "+ owner +"] [Address: " +address+ "] [Age: "+age+ "] ";
    }
    
    public abstract void getPetInfo ();
        
}

