package UI.HomPage;

import javax.swing.*;
import java.awt.*;

public class DeleteProductForm extends JPanel {

    public DeleteProductForm() {
        setLayout(new FlowLayout());

        JTextField id = new JTextField(10);
        JButton delete = new JButton("Delete");

        add(new JLabel("Product ID:"));
        add(id);
        add(delete);

        delete.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Deleted (Demo)");
        });
    }
}