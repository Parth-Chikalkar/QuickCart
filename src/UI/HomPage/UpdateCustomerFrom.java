package UI.HomPage;

import Controllers.CustomerController;
import Models.ViewCustomer;

import javax.swing.*;
import java.awt.*;

public class UpdateCustomerFrom extends JPanel {
    public UpdateCustomerFrom (){
        setLayout(new GridLayout(6,2,10,10));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField id = new JTextField();
        JTextField name = new JTextField();
        JTextField email = new JTextField();
        JTextField address = new JTextField();
        JTextField phoneNo = new JTextField();

        JButton update = new JButton("Update");
        add(new JLabel("User ID : "));
        add(id);
        add(new JLabel("New Name : "));
        add(name);
        add(new JLabel("New Email : "));
        add(email);
        add(new JLabel("New Address : "));
        add(address);
        add(new JLabel("New Phone No : "));
        add(phoneNo);
        add(new JLabel(""));
        add(update);



        update.addActionListener(e -> {
             int u_id = Integer.parseInt(id.getText());
            ViewCustomer cu = new ViewCustomer(name.getText(),email.getText(),address.getText(),phoneNo.getText());

            boolean bool = new CustomerController().updateCustomer(u_id,cu);
            if(bool){
                JOptionPane.showMessageDialog(this,"Update Sucessfull");
                name.setText("");
                email.setText("");
                address.setText("");
                phoneNo.setText("");

            }
            else{
                JOptionPane.showMessageDialog(this,"Update Failed !");
            }

        });


    }
}
