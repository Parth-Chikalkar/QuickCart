package UI.HomPage;

import Controllers.UserController;
import Models.User;
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
                if(role.equals("USER")) showUserPanel();
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
    private void showUserPanel(){
        JPanel panel = new JPanel();
        JLabel labl = new JLabel("Hello Parth");
        panel.add(labl);
        this.setContentPane(panel);
        this.revalidate();
    }
}
