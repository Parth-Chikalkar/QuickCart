package UI.HomPage;

import Controllers.CustomerController;

import javax.swing.*;
import java.awt.*;

public class DeleteCustomerForm extends JPanel {


    public DeleteCustomerForm (){
        setLayout(new FlowLayout());

        JTextField id = new JTextField(10);
        JButton delete = new JButton("Delete");

        add(new JLabel("User ID :"));
        add(id);
        add(delete);
        delete.addActionListener(e->{
          int uid = Integer.parseInt(id.getText());
          boolean bool = new CustomerController().deleteCustomer(uid);

          if(bool){
              JOptionPane.showMessageDialog(this,"Deleted Sucessfully !");
              id.setText("");
          }
          else{
              JOptionPane.showMessageDialog(this,"Deletion Failed ");
          }

        });



    }
}
