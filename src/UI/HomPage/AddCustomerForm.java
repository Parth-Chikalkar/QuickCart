package UI.HomPage;

import Controllers.CustomerController;
import Models.Customer;
import Models.User;

import javax.swing.*;
import java.awt.*;

public class AddCustomerForm extends JPanel {

    public AddCustomerForm() {


        setLayout(new GridLayout(6, 2, 10, 10));
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        JTextField name = new JTextField();
        JTextField address = new JTextField();
        JTextField phone  = new JTextField();
        JTextField email = new JTextField();
        JPasswordField password = new JPasswordField();

        JButton addBtn = new JButton("Add Customer");

        add(new JLabel("Name:"));
        add(name);

        add(new JLabel("Address:"));
        add(address);

        add(new JLabel("Phone:"));
        add(phone);

        add(new JLabel("Email:"));
        add(email);

        add(new JLabel("Password:"));
        add(password);

        add(new JLabel(""));
        add(addBtn);



        addBtn.addActionListener(e -> {
            String n = name.getText().trim();
            String ad = address.getText().trim();
            String ph = phone.getText().trim();
            String em = email.getText().trim();
            String pass = new String(password.getPassword());

            if(n.isEmpty() || ad.isEmpty() || ph.isEmpty() || em.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields are required");
                return;
            }


            CustomerController controller = new CustomerController();


           boolean bool =  controller.addCustomer(n,ad,ph,em,pass);
           if(bool){
               JOptionPane.showMessageDialog(this,"Added Succesfully");
               name.setText("");
               address.setText("");
               phone.setText("");
               email.setText("");
               password.setText("");
           }
           else{
               JOptionPane.showMessageDialog(this, "Failed to Add","Caution",JOptionPane.WARNING_MESSAGE);
           }



        });
    }
}