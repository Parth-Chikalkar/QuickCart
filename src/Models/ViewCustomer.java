package Models;

public class ViewCustomer {
    private String name;
    private String email;
    private String address;
    private String phone;
    public ViewCustomer(String name , String email, String address , String phone){
        this.name = name;
        this.email=email;
        this.address =address;
        this.phone = phone;

    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}
