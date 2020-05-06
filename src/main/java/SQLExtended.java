import java.sql.Connection;

import java.sql.*;
import java.util.ArrayList;

//import  java.
public class SQLExtended
{
    Connection conn = null;


    public static void  main(String[] args)
    {
        try
        {
            new SQLExtended();
        }
        catch (ClassNotFoundException | SQLException ex) {System.err.println(ex.getMessage());}

    }

    public  SQLExtended() throws SQLException, ClassNotFoundException {



            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/UmuziDB";
            //Connects to the database
            conn = DriverManager.getConnection(url, "admin", "admin");

            //calling all functions
            doTests();

            conn.close();



    }
    private void doTests() throws SQLException {
        //invoking fuctions

        System.out.println("Record of All Customers");
        System.out.println("======================================");
        for (Customer customer:SelectALL()) {
            System.out.println(
                    customer.getCustID() + "\t" +
                            customer.getFirstname() + "\t" +
                            customer.getGender() + "\t" +
                            customer.getGender() + "\t" +
                            customer.getEmail() + "\t" +
                            customer.getPhone() + "\t" +
                            customer.getAddress() + "\t" +
                            customer.getCity() + "\t" +
                            customer.getCountry() + "\t"
            );
        }

        System.out.println("Dsplaying the first names of Customers");
        System.out.println("======================================");
        String firtstnsme =selectRecord();
        System.out.println(firtstnsme);

        System.out.println("Dsplaying the first  and last names of Customers");
        System.out.println("======================================");
        Customer customer =selectnameOfCustomer();
        System.out.println(customer.getFirstname() + "\t" + customer.getLastname());


        System.out.println("Updating customer");
        System.out.println("======================================");
        System.out.println(upodateCustomer());

        System.out.println("Deleting customer");
        System.out.println("======================================");
        System.out.println(deleteRecordcustomer());

        System.out.println("Total number of status on order table");
        System.out.println("======================================");
        System.out.println ( countNumberOfStatus());

        System.out.println("Maximum amount of payment");
        System.out.println("======================================");
        System.out.println(maxPrice());

        System.out.println("Displaying Customer record orded by country");
        System.out.println("======================================");
        for (Customer customers:orderByCountry())
        {
            System.out.println(customers.getFirstname() + "\t" + customers.getLastname() + "\t" + customers.getGender() + "\t" +
                            customers.getEmail() + "\t" + customers.getPhone() + "\t" + customers.getAddress() + "\t" + customers.getCity() + "\t" +
                            customers.getCountry() + "\t"
            );
        }

        System.out.println("Displaying product with the price between 100 and 600 ");
        System.out.println("======================================");
        for (Product products:productBetween())
        {
            System.out.println(
                    products.getProductID() + "\t" + products.getProdName() + "\t" + products.getDescription() + "\t" +
                            products.getBuyPrice()
            );
        }


    }

    //function to retrieve all customers
    private ArrayList<Customer> SelectALL()throws SQLException
    {
        Customer customer =null;
        //query data from the customer table

        String sql ="SELECT * FROM customertable ";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        ArrayList<Customer> list = new ArrayList();

        if(rs.next())
        {
            list.add(new Customer(0,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)) );
        }

        return list;

    }

    //function to retrieve a particular column which is name
    private String selectRecord() throws SQLException {

        String  firstname =null;
        //query data from the customer table
        String sql ="SELECT firstname FROM customertable";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next())
        {
             firstname = rs.getString(0);
        }

        return firstname;


    }

    //function to retrieve a specific customer
    private Customer selectnameOfCustomer() throws SQLException {
        //query data from the customer table
        Customer customer =null;
        String sql = "SELECT *FROM customertable where Customer-ID="+ 1;
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next())
        {
            customer = new Customer(0,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8));
        }

        return customer;
    }

    //function to update customer
    private int upodateCustomer() throws SQLException
    {

        //query for updating data
        String sql = "UPDATE customertable set  SET FirstName = 'Lerato', LastName = 'Mabitso' WHERE Customer-ID ="+ 1;
        Statement st = conn.createStatement();
        int rows = st.executeUpdate(sql);

        return rows;

    }


    private int deleteRecordcustomer() throws SQLException//function to delete record customer
    {

        //query for deleting specific record
        String sql = "DELETE FROM customertable WHERE Customer-ID="+2;
        Statement st = conn.createStatement();
        int rows = st.executeUpdate(sql);

        return rows;

    }

    //Retrieve the total number of status in order table
    private int  countNumberOfStatus() throws SQLException {
        //query data from the customer table
        String sql = "SELECT count(Status) FROM orderTbl ";
        Statement st = conn.createStatement();
        int totalNum = st.executeUpdate(sql);

        return totalNum;

    }

    //Retrieve maximum amount from payment table
   private Double maxPrice() throws SQLException {

       String sql = "SELECT MAX(Amount) FROM PaymentsTbl";
       Statement st = conn.createStatement();
       Double maximum = Double.parseDouble(String.valueOf(st.executeUpdate(sql)));

       return maximum;
   }
    //Returns all the customers from customer table sorted by country
    private ArrayList<Customer> orderByCountry() throws SQLException {

        String sql = "SELECT * FROM Customers ORDER BY Country";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        ArrayList<Customer> list = new ArrayList();

        if(rs.next())
        {
            list.add(new Customer(0,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                    rs.getInt(5),rs.getString(6),rs.getString(7),rs.getString(8)) );
        }

        return list;
    }

    //Returns all products with the price between a specified range from products table
    private ArrayList<Product> productBetween() throws SQLException {

        Product product =null;
        String sql = "SELECT * FROM Products WHERE BuyPrice BETWEEN 100 AND 600";
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        ArrayList<Product> list = new ArrayList();

        if(rs.next())
        {
            list.add(new Product(0,rs.getString(1),rs.getString(2),rs.getDouble(3) )) ;
        }


        return list;
    }


}
