public class Order
{
    private int orderID;
    private int paymentID;
    private int empID;
    private String DateREquired;
    private String DateShipped;
    private String status;

    public Order()
    {

    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getDateREquired() {
        return DateREquired;
    }

    public void setDateREquired(String dateREquired) {
        DateREquired = dateREquired;
    }

    public void setDateShipped(String dateShipped) {
        DateShipped = dateShipped;
    }

    public String getDateShipped() {
        return DateShipped;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
