package UI.HomPage;

import javax.swing.*;
import java.awt.*;

public class UpdateProductForm extends JPanel {

    public UpdateProductForm() {
        setLayout(new GridLayout(4,2,10,10));

        JTextField id = new JTextField();
        JTextField price = new JTextField();

        JButton update = new JButton("Update");

        add(new JLabel("Product ID:"));
        add(id);
        add(new JLabel("New Price:"));
        add(price);
        add(new JLabel(""));
        add(update);

        update.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Updated (Demo)");
        });
    }
}