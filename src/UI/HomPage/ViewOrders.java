package UI.HomPage;

import Controllers.OrderController;
import Models.ViewOrder;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ViewOrders extends JPanel {

    public ViewOrders() {
        setLayout(new BorderLayout());

        String[] cols = {"Order ID", "Customer Id" , "Customer", "Product", "Qty", "Total"};
       ArrayList <ViewOrder> order = new OrderController().getAllOrder();
        Object[][] data = new Object[order.size()][6];
        for (int i = 0; i < order.size(); i++) {
            ViewOrder ord = order.get(i);
            data[i][0] = ord.getOid() ;
            data[i][1] = ord.getCu_id();
            data[i][2] = ord.getCustomer_name();
            data[i][3] = ord.getProduct_name();
            data[i][4] = ord.getQuantity();
            data[i][5] = ord.getTotal();

        }


        JTable table = new JTable(data, cols);
        table.setRowHeight(25);

        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}