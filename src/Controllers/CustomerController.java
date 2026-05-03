package Controllers;

import Models.Customer;
import Utils.DBConnect;

import java.sql.*;

public class CustomerController {

    /*
    PLAN :
    CREATE USER ENTRY
    GENERATE U_ID
    THEN CREATE CUTOMER ENTRY
    THEN TERMINATE CONNECTION !


     */
    public boolean addCustomer(String name,String address ,String phone ,String email , String pasword){
        String sql1 = "INSERT INTO USERS ( NAME , EMAIL , PASSWORD) VALUES (?,?,?)";
        String sql2 = "INSERT INTO CUSTOMERS ( u_id , address , PHONE ) VALUES (?,?,?)";
        try{
            DBConnect connect = new DBConnect();
            Connection con =  connect.dbCon();
            PreparedStatement stm = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            stm.setString(1,name);
            stm.setString(2,email);
            stm.setString(3,pasword);
            stm.executeUpdate();
            ResultSet rs = stm.getGeneratedKeys();
            int userId = 0;
            if(rs.next()){
                userId =rs.getInt(1);
            }
            PreparedStatement stm2 = con.prepareStatement(sql2);
            stm2.setInt(1,userId);
            stm2.setString(2,address);
            stm2.setString(3,phone);
            stm2.executeUpdate();
            con.close();
            return true;
        } catch (SQLException e){
            System.out.println(e.getMessage());
return false;
        }


    }
}
