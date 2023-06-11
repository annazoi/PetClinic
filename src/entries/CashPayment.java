package entries;

import java.util.Date;

public class CashPayment extends Payment {
    private int cashNumber;

    public CashPayment () {}

    public CashPayment (double paymentAmount, String coin, Date paymentDate, int cashNumber) {
        super(paymentAmount, coin, paymentDate);
        this.cashNumber = cashNumber;
    }
    
    public int getCashNumber () {
        return cashNumber;
    }
    
    public void setCashNumber (int cashNumber) {
        this.cashNumber = cashNumber;
    }  
    
    @Override
    public String toString() {
    	return "[Total Price: " + getPaymentAmount() +"] [Coin: " + getCoin() +"] [Payment Day: " + getPaymentDate() + "] [" + getCashNumber() + "] " ;
    }
}
