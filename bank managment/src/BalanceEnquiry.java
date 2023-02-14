import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ExecutionException;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    static String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image img2 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Назад");
        back.setFont(new Font("Raleway", Font.BOLD, 25));
        back.setBounds(290, 460, 160, 50);
        back.addActionListener(this);
        back.setBackground(Color.white);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("SELECT * from bank where pinnumber ='" + pinnumber + "'");
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        JLabel text = new JLabel("Your current account balace is: " + balance);
        text.setBounds(300, 200, 350, 30);
        text.setFont(new Font("System", Font.BOLD, 18));
        text.setBackground(Color.white);
        image.add(text);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry(pinnumber);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
