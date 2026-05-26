package Controllers;

import Models.Customer;
import Models.ViewCustomer;
import Utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<ViewCustomer> getCustomers (){
        String query = "SELECT U.NAME , U.EMAIL , C.ADDRESS , C.PHONE FROM USERS U JOIN CUSTOMERS C ON U.u_id = C.u_id;";
        try{
            DBConnect con = new DBConnect();
            Connection conecct = con.dbCon();
            PreparedStatement stm = conecct.prepareStatement(query);
            ResultSet set = stm.executeQuery();
            ArrayList<ViewCustomer> list = new ArrayList<>();
            while (set.next()){
                list.add(new ViewCustomer(set.getString(1),set.getString(2),set.getString(3),set.getString(4)));
            }
            return list;
        }
        catch (SQLException e ){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean updateCustomer(int u_id , ViewCustomer cus){
        String name = cus.getName();
        String address = cus.getAddress();;
        String email = cus.getEmail();
        String phone= cus.getPhone();;
        String sql1 = "UPDATE USERS SET NAME = ? , EMAIL = ? WHERE u_id = ? ";
        String sql2 = "UPDATE CUSTOMERS SET ADDRESS = ? , PHONE = ? WHERE u_id = ? ";

        try{
            Connection con = new DBConnect().dbCon();
            PreparedStatement stm = con.prepareStatement(sql1);
            stm.setString(1,name);
            stm.setString(2,email);
            stm.setInt(3,u_id);
            stm.executeUpdate();

            PreparedStatement stm2 = con.prepareStatement(sql2);
            stm2.setString(1,address);
            stm2.setString(2,phone);
            stm2.setInt(3,u_id);
            stm2.executeUpdate();
            return true;

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }


    public boolean deleteCustomer (int id ){
        String sql1 = "DELETE FROM USERS WHERE u_id = ?";
        try{
            DBConnect connect = new DBConnect();
            Connection con = connect.dbCon();
            PreparedStatement stm = con.prepareStatement(sql1);

            stm.setInt(1,id);
            stm.executeUpdate();
            return true;

        } catch (SQLException e ){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public int getCustomerId(String email){
        String sql = "SELECT c.cu_id from CUSTOMERS C JOIN USERS U ON C.u_id = U.u_id WHERE U.email = ? ";
        try{
            DBConnect connect = new DBConnect();
            Connection con = connect.dbCon();
            PreparedStatement srm = con.prepareStatement(sql);
            srm.setString(1,email);
            ResultSet set = srm.executeQuery();
            if(set.next()) {
                return set.getInt("cu_id");
            }




        } catch (SQLException e){
            System.out.println(e.getMessage());

        }
        return -1;

    }



}
