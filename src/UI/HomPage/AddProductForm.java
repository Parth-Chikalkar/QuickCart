package UI.HomPage;

import Controllers.ProductController;
import Models.Product;

import javax.swing.*;
import java.awt.*;

public class AddProductForm extends JPanel {

    public AddProductForm() {
        setLayout(new GridLayout(6,2,10,10));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField name = new JTextField();
        JTextField description = new JTextField();
        JTextField stock = new JTextField();
        JTextField price = new JTextField();

        JButton addBtn = new JButton("Add Product");

        add(new JLabel("Name:"));
        add(name);
        add(new JLabel("Description:"));
        add(description);
        add(new JLabel("Price:"));
        add(price);
        add(new JLabel("Stock:"));
        add(stock);
        add(new JLabel(""));
        add(addBtn);

        addBtn.addActionListener(e -> {
            String n = name.getText().trim();
            String des = description.getText().trim();
             int pr = Integer.parseInt(price.getText().trim());
            int st = Integer.parseInt(stock.getText().trim());

            if(n.isEmpty() || des.isEmpty() || price.getText().trim().isEmpty() || stock.getText().trim().isEmpty() ) {
                JOptionPane.showMessageDialog(this,"All Fields are required ","CAUTION",JOptionPane.WARNING_MESSAGE);
                return;
            }
            ProductController controller = new ProductController();


            boolean bool = controller.addProduct(new Product(n,des,st,pr));

            if(bool){
                JOptionPane.showMessageDialog(this,"Added Product Succesfully !");
                name.setText("");
                description.setText("");
                stock.setText("");
                price.setText("");

            }else{
                JOptionPane.showMessageDialog(this,"Error In adding product Try Again");
            }






        });
    }
}