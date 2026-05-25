package UI.HomPage;

import Controllers.ProductController;
import Models.Product;

import javax.swing.*;
import java.awt.*;

public class UpdateProductForm extends JPanel {

    public UpdateProductForm() {
        setLayout(new GridLayout(6,2,10,10));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField id = new JTextField();
        JTextField price = new JTextField();
        JTextField title = new JTextField();
        JTextField description = new JTextField();

        JButton update = new JButton("Update");

        add(new JLabel("Product ID : "));
        add(id);
        add(new JLabel("New Name : "));
        add(title);
        add(new JLabel("New Description : "));
        add(description);
        add(new JLabel("New Price : "));
        add(price);
        add(new JLabel(""));
        add(update);

        update.addActionListener(e -> {




            Product pro = new Product(title.getText(),description.getText(),Integer.parseInt(id.getText()),Integer.parseInt(price.getText()));
            boolean bool = new ProductController().updateProduct(pro);
            if(bool) {
                JOptionPane.showMessageDialog(this, "Updated Sucessfully");
                description.setText("");
                price.setText("");
                id.setText("");
                title.setText("");

            }
            else JOptionPane.showMessageDialog(this,"Update Failed");

        });
    }
}