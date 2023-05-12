package entries;

import java.util.Date;

public class BitcoinPayment extends Payment {
    private int extraCharge;

    public BitcoinPayment () {}

    public BitcoinPayment (int paymentAmount, String coin, Date peymentDate, int extraCharge) {
        super(paymentAmount, coin, peymentDate);
        this.extraCharge = extraCharge;
    }

    public int getExtraCharge() {
        return extraCharge;
    }

    public void setExtraCharge(int extraCharge) {
        this.extraCharge = extraCharge;
    }
    
}

