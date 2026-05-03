package UI.HomPage;

import javax.swing.*;
import java.awt.*;

public class ViewOrders extends JPanel {

    public ViewOrders() {
        setLayout(new BorderLayout());

        String[] cols = {"Order ID", "Customer", "Product", "Qty", "Total"};

        Object[][] data = {
                {101, "Parth", "T-Shirt", 2, 1000},
                {101, "Parth", "Shoes", 1, 2000},
                {102, "Amit", "Watch", 1, 3000}
        };

        JTable table = new JTable(data, cols);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}