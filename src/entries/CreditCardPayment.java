package entries;

import java.util.Date;

public class CreditCardPayment extends Payment {
    private int numberCard;
    private String nameOwner;
    private int securityCode; // 3psifio (elegxos)
   
    public CreditCardPayment () {}

    public CreditCardPayment(int paymentAmount, String coin, Date peymentDate, int numberCard, String nameOwner, int securityCode) {
        super(paymentAmount, coin, peymentDate);
        this.numberCard = numberCard;
        this.nameOwner = nameOwner;
        this.securityCode = securityCode;
    }
    
    public int getNumberCard () {
        return numberCard;
    }
    
    public void setNumberCard (int numberCard) {
        this.numberCard = numberCard;
    }

    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    public int getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(int securityCode) {
        this.securityCode = securityCode;
    }
}
    
