import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdraw, exit, back;
    String pinnumber;
    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;


        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Введите сумму:");
        text.setBounds(300, 210, 400, 40);
        text.setBackground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 24));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(285, 275, 340, 40);
        amount.setFont(new Font("Raleway", Font.BOLD, 20));
        image.add(amount);
        image.add(amount);

        withdraw = new JButton("Cнять");
        withdraw.setBounds(465, 420, 160, 50);
        withdraw.setBackground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back = new JButton("Back");
        back.setBounds(285, 485, 160, 50);
        back.setBackground(Color.white);
        back.addActionListener(this);
        image.add(back);

        exit = new JButton("exit");
        exit.setBounds(465, 485, 160, 50);
        exit.setBackground(Color.white);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            try {
                Conn c = new Conn();
                String query = "insert into bank values ( '"+pinnumber+"', '"+date+"', 'Withdraw', '"+number+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,number + "Успешно сняли "+number+" рублей.");
                setVisible(false);
            } catch (Exception exception) {
                System.out.println(exception);
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transactions("").setVisible(true);
        } else if (e.getSource() == exit) {
            System.exit(0);
        }


    }
}
