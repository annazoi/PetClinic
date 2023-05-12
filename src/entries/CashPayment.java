package entries;

import java.util.Date;

public class CashPayment extends Payment {
    private int cashNumber;

    public CashPayment () {}

    public CashPayment (int paymentAmount, String coin, Date peymentDate, int cashNumber) {
        super(paymentAmount, coin, peymentDate);
        this.cashNumber = cashNumber;
    }
    
    public int getCashNumber () {
        return cashNumber;
    }
    
    public void setCashNumber (int cashNumber) {
        this.cashNumber = cashNumber;
    }  
}
