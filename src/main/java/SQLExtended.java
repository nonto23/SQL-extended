import java.sql.Connection;

import java.sql.*;

//import  java.
public class SQLExtended
{
    Connection conn = null;


    public static void  main(String[] args)
    {
        System.out.println("Hellow world");

        new SQLExtended();
    }

    public  SQLExtended()
    {

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/UmuziDB";
            //Connects to the database
            conn = DriverManager.getConnection(url, "admin", "admin");

            //calling all functions
            doTests();

            conn.close();
        }
        catch (ClassNotFoundException | SQLException ex) {System.err.println(ex.getMessage());}

    }
    private void doTests()
    {
        //invoking fuctions
        SelectALL();
        selectRecord();
        selectnameOfCustomer();
        upodateCustomer();
        deleteRecordcustomer();
        selectUniqueStatus();



    }

    //function to retrieve all customers
    private void SelectALL()
    {
        //query data from the customer table
        String sql = "SELECT * FROM customertable";
        try
        {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

            //Printing customer data from customer table
            while (result.next()){

                int cudtomerID =result.getInt(0);
                String firstname = result.getString("firstname");
                String  lastname = result.getString("lastname");
                String gender = result.getString("gender");
                String address = result.getString("address");
                int phone  =result.getInt(00000000000);
                String email = result.getString("email");
                String city = result.getString("city");
                String country = result.getString("country");


                System.out.println(cudtomerID+" "+ firstname+","+ lastname+" ,"+ gender+" ,"+ address+", "+","+
                        email+","+phone+","+city+","+country);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    //function to retrieve a particular column which is name
    private void selectRecord()
    {
        //query data from the customer table
        String sql = "SELECT firstname FROM customertable";
        try
        {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

            //Printing customer data from customer table
            while (result.next()){

                String firstname = result.getString("firstname");
                System.out.println(" Names:"+ firstname);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }

    //function to retrieve a specific customer
    private void selectnameOfCustomer()
    {
        //query data from the customer table
        String sql = "SELECT First-name FROM customertable where Customer-ID="+ 1;
        try
        {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

            //Printing customer data from customer table
            while (result.next()){

                String firstname = result.getString("First-name");
                System.out.println(" Names:"+ firstname);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }

    }

    //function to update customer
    private void upodateCustomer()
    {
        try
        {
            //query for updating data
            String sql = "UPDATE customertable SET First-name=?, name=?,  WHERE Customer-ID=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "lerato");  //updating data
            statement.setString(2, "mabitso");
            statement.setInt(3,1);

            int rowsUpdated = statement.executeUpdate(sql);
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }

        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }


    private void deleteRecordcustomer()//function to delete record customer
    {
        try
        {
            //query for deleting specific record
            String sql = "DELETE FROM customertable WHERE Customer-ID=?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 2);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("A user was deleted successfully!");
            }

        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }
//
    //Retrieve a all orders with unique status from order table
    private void selectUniqueStatus()
    {
        //query data from the customer table
        String sql = "SELECT * FROM orderTbl where Status="+ "'unique'";
        try
        {
            Statement st = conn.createStatement();
            ResultSet result = st.executeQuery(sql);

            //Printing all the status that are unique from order table
            while (result.next()){

                String status = result.getString("Status");
                System.out.println(" status:"+ status);
            }
        }
        catch (SQLException ex)
        {
            System.err.println(ex.getMessage());
        }
    }




}
