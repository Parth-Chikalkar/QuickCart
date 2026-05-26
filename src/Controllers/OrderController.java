package Controllers;

import Utils.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderController {
    public boolean addOrder(String name ,String description , int quantity ){
        String sql = "INSERT INTO ORDER_ITEMS (p_id , quantity , price ) values (?,?,?)";
        ///Product cha stock pn update kr re parth obv

        String sql2 = "UPDATE PRODUCT SET STOCK = ? WHERE P_ID = ? ";
      ///price = quantity * single price



        try{
            DBConnect connect = new DBConnect();
            Connection con = connect.dbCon();
            PreparedStatement stm =con.prepareStatement(sql);
            ArrayList<String> productData =
                    new ProductController()
                            .getProductIdAndStockAndPrice(name);

            if(productData.isEmpty()) {

                System.out.println("Product Not Found");

                return false;
            }

            int p_id = Integer.parseInt(productData.get(0));

            int price = Integer.parseInt(productData.get(1));

            int stock = Integer.parseInt(productData.get(2));

            if(quantity>stock) return false;

            int total_Price_Of_Pro = quantity * price;

            stm.setInt(1,p_id);
            stm.setInt(2,quantity);
            stm.setInt(3,total_Price_Of_Pro);
            stm.executeUpdate();

            //Stock update kela
            PreparedStatement stm1 = con.prepareStatement(sql2);
            stm1.setInt(1,stock-quantity);
            stm1.setInt(2,p_id);
            stm1.executeUpdate();

            return true;


        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }
}
