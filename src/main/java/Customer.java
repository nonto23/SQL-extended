public class Customer
{
    private int custID;
    private String firstname,lastname,gender,address,email,city,country;
    private int phone;


    public Customer()
    {

    }
    public Customer(int custID,String firstname,String lastname,String gender,String address,int phone,String email,String city,String country)
    {
       this.address =address;
       this.city = city;
       this.country =country;
       this.gender = gender;
       this.lastname = lastname;
       this.custID = custID;
       this.firstname = firstname;
       this.email = email;
       this.country = country;

    }


    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
