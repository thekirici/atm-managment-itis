import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("MiniStatement");

        setLayout(null);

        JLabel mini = new JLabel();
        mini.setBounds(300, 320, 350, 30);
        add(mini);

        JLabel bank = new JLabel("Alfa Bank");
        bank.setBounds(250, 150, 350, 30);
        bank.setFont(new Font("System", Font.BOLD, 24));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(300, 250, 350, 30);
        card.setFont(new Font("System", Font.BOLD, 24));
        add(card);

        back = new JButton("Back");
        back.setBounds(285, 485, 160, 50);
        back.setBackground(Color.white);
        back.addActionListener(this);
        add(back);


        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from encryption where pinnumber = '" + pinnumber + "'");
            while (rs.next()) {
                card.setText("Номер Карта: " + rs.getString("cardnumber"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pinnumber = '" + pinnumber + "'");
            while (rs.next()) {
                mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString("amount"));

            }
        } catch (Exception e) {
            System.out.println(e);
        }


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
