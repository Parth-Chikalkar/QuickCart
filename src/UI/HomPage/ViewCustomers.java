package UI.HomPage;

import Controllers.CustomerController;
import Models.ViewCustomer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViewCustomers extends JPanel {
    public ViewCustomers(){
        setLayout(new BorderLayout());

        String[] cols = {"NAME", "Email Address", "ADDRESS", "PHONE"};
        List<ViewCustomer> li = new CustomerController().getCustomers();
        Object [][] data = new Object[li.size()][cols.length];
        for (int i = 0; i < li.size() ; i++) {
            ViewCustomer cut = li.get(i);
            data[i][0]= cut.getName();
            data[i][1]= cut.getEmail();
            data[i][2]= cut.getAddress();
            data[i][3]= cut.getPhone();


        }
        JTable table = new JTable(data, cols);
       table.setRowHeight(25);


        add(new JScrollPane(table), BorderLayout.CENTER);
    }
}
