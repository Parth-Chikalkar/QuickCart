package Models;

public class Customer {
    private int u_id ;
    private int cu_id;
    private String address;
    private String phone;

    public Customer(int u_id,int cu_id , String address , String phone){
        this.u_id = u_id;
        this.cu_id=cu_id;
        this.address=address;
        this.phone = phone;
    }

    public int getCustomerId (){
        return this.cu_id;
    }
    public int getCustomerUserId (){
        return this.cu_id;
    }
    public String getCustomerAddress(){
        return this.address;
    }
    public String getCustomerPhoneNo(){
        return this.phone;
    }



}
