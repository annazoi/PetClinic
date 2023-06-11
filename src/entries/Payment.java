package entries;

import java.util.Date;

public abstract class Payment {
    private double paymentAmount;
    private String coin;
    private Date paymentDate;
    
    public Payment () {}

    public Payment(double paymentAmount, String coin, Date paymentDate) {
        this.paymentAmount = paymentAmount;
        this.coin = coin;
        this.paymentDate = paymentDate;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(int paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPeymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
    
    public String toString () {
    	return "[Total Price: " + getPaymentAmount() +"] [Coin: " + getCoin() +"] [Payment Day: " + getPaymentDate() + "] ";
    }
}
