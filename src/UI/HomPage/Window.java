package UI.HomPage;

import Controllers.CustomerController;
import Controllers.UserController;
import Models.User;
import UI.CustomerPages.Customer;

import javax.swing.*;

public class Window extends JFrame {
    public Window (){
        this.setSize(500,500);
        this.setTitle("E-COMM");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Login log = new Login();
        log.addLoginListener(e -> {
            String email = log.getEmail();
            String pass = log.getPassword();
            UserController controller = new UserController();
            User user = controller.Login(email,pass);
            if(user == null){
                JOptionPane.showMessageDialog(null, "Invalid credentials");
            }
            else{
                String role = user.getRole();
                if(role.equals("USER")){
int cu_id = new CustomerController().getCustomerId(email);
                    showUserPanel(cu_id);
                }
                else showAdminPane();
            }
        });


        this.setVisible(true);
        this.setContentPane(log);
    }
    private void showAdminPane(){
        Admin admin = new Admin();
        this.setContentPane(admin);
        this.revalidate();
    }
    private void showUserPanel(int id ){
        Customer cu= new Customer(id);
        this.setContentPane(cu);
        this.revalidate();
    }
}
