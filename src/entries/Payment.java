package entries;

import java.util.Date;

public abstract class Payment {
    private int paymentAmount;
    private String coin;
    private Date peymentDate;
    
    public Payment () {}

    public Payment(int paymentAmount, String coin, Date peymentDate) {
        this.paymentAmount = paymentAmount;
        this.coin = coin;
        this.peymentDate = peymentDate;
    }

    public int getPaymentAmount() {
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

    public Date getPeymentDate() {
        return peymentDate;
    }

    public void setPeymentDate(Date peymentDate) {
        this.peymentDate = peymentDate;
    }
    
    
}
