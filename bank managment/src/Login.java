import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JButton login, signup, clear;
    JTextField cardTextField;
    JPasswordField pinPasswField;

    Login() {
        setTitle("ATM");
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/banklogo.png"));
        Image i2 = i1.getImage().getScaledInstance(120, 75, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(50, 10, 150, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Calibri", Font.BOLD, 38));
        text.setBounds(220, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Calibri", Font.BOLD, 30));
        cardno.setBounds(80, 120, 200, 30);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(240, 120, 210, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 18));
        add(cardTextField);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Calibri", Font.BOLD, 30));
        pin.setBounds(80, 170, 400, 30);
        add(pin);

        Login.this.pinPasswField = new JPasswordField();
        Login.this.pinPasswField.setBounds(240, 170, 210, 30);
        Login.this.pinPasswField.setFont(new Font("Arial", Font.BOLD, 18));
        add(Login.this.pinPasswField);

        login = new JButton("Войти");
        login.setBounds(240, 230, 90, 35);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Очистить");
        clear.setBounds(360, 230, 90, 35);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("Зарегистрироваться");
        signup.setBounds(240, 280, 210, 35);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            cardTextField.setText("");
            Login.this.pinPasswField.setText("");
        } else if (e.getSource() == login) {

            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinPasswField.getText();
            String query = "select * from encryption where cardnumber = '" + cardnumber + "' and pinnumber = '" + pinnumber + "'";

            try {
                ResultSet rs = conn.s.executeQuery(query);
                if (rs.next()) {
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Error incorrect pin or card number.");
                }

            } catch (Exception exception) {
                System.out.println(exception);
            }

        } else if (e.getSource() == signup) {
            setVisible(false);
            new Signup().setVisible(true);
        }

    }
}
