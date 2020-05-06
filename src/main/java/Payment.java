public class Payment
{
//    `CustomerId` INT NOT NULL ,
//        `PaymentID` INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
//`PaymentDate` DATETIME NOT NULL ,
//        `Amount` DATETIME NOT NULL

    private int custID;
    private int paymentID;
    private String paymentDate;
    private double amount;

    public Payment() {
    }

    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
