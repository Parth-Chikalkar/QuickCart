package Controllers;

import Models.Product;
import Utils.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductController {
    public boolean addProduct (Product product){
        String sql = "INSERT INTO PRODUCT (NAME , DESCRIPTION ,STOCK ,PRICE) VALUES (?,?,?,?)";
        try{
            DBConnect conn = new DBConnect();
            Connection con = conn.dbCon();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1,product.getName());
            stm.setString(2,product.getDescription());
            stm.setInt(3, product.getStock());
            stm.setInt(4,product.getPrice());

            stm.executeUpdate();
            return true;



        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public List<Product> getAllProducts (){
        String sql = "SELECT NAME NAME, DESCRIPTION, STOCK, PRICE FROM PRODUCT";
        try{
            DBConnect connect = new DBConnect();
            Connection con = connect.dbCon();
            Statement stm = con.createStatement();
            List <Product> list = new ArrayList<>();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()){
                list.add(new Product(rs.getString("NAME"),rs.getString("DESCRIPTION"),rs.getInt("STOCK"),rs.getInt("PRICE")));
            }
            return list;

        } catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }

    }

    public boolean deleteProduct(int id ){
        String sql = "DELETE FROM PRODUCT WHERE p_id = ?";
        try{
            DBConnect con = new DBConnect();
            Connection conc = con.dbCon();
            PreparedStatement stm = conc.prepareStatement(sql);
            stm.setInt(1,id);
            stm.executeUpdate();
            return true;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
            return false;
        }

    }

    public boolean updateProduct(Product pro){
        int id = pro.getStock();
        int price = pro.getPrice();
        String title = pro.getName();
        String description = pro.getDescription();

        String query = "UPDATE PRODUCT SET NAME = ? , PRICE = ? , DESCRIPTION = ?  WHERE p_id = ?";
        try{
            DBConnect conect = new DBConnect();
            Connection con = conect.dbCon();
            PreparedStatement stm = con.prepareStatement(query);
            stm.setString(1,title);
            stm.setInt(2,price);
            stm.setString(3,description);
            stm.setInt(4,id);
            stm.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public ArrayList<String> getProductIdAndStockAndPrice(
            String name){

        String sql =
                "SELECT p_id, price, stock " +
                        "FROM PRODUCT " +
                        "WHERE name = ?";

        ArrayList<String> list = new ArrayList<>();

        try {

            DBConnect connect = new DBConnect();

            Connection con = connect.dbCon();

            PreparedStatement stm = con.prepareStatement(sql);

            stm.setString(1, name);


            ResultSet set = stm.executeQuery();

            if (set.next()) {

                list.add(String.valueOf(set.getInt("p_id")));
                list.add(String.valueOf(set.getInt("price")));
                list.add(String.valueOf(set.getInt("stock")));
            }

            con.close();
        }

        catch (SQLException e) {

            System.out.println(e.getMessage());
        }

        return list;
    }

}
