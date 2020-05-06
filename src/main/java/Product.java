public class Product
{
    private int productID;
    private String prodName,description;
    private double buyPrice;

    public Product(int productID,String prodName,String description,double buyPrice)
    {
        this.productID =productID;
        this.prodName =prodName;
        this.description = description;
        this.buyPrice = buyPrice;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }
}
