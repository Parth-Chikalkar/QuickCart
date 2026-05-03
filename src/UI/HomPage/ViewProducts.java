package UI.HomPage;

import Controllers.ProductController;
import Models.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewProducts extends JPanel {

    public ViewProducts() {

        ProductController controller = new ProductController();
        List<Product> list = controller.getAllProducts();
        setLayout(new BorderLayout());
        String[] cols = {"Name", "Description", "Stock", "Price"};
        Object[][] data = new Object[list.size()][4];
        for (int i = 0; i < list.size(); i++) {
            Product p = list.get(i);
            data[i][0] = p.getName();
            data[i][1] = p.getDescription();
            data[i][2] = p.getStock();
            data[i][3] = p.getPrice();
        }

        JTable table = new JTable(data, cols);
        table.setRowHeight(25);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}