import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastCash, statement, pinChange, balance, exit;
    String pinnumber;
    Transactions(String pinnumber){
        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image img2 = img.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please Select your Transaction");
        text.setBounds(300,175,350,30);
        text.setFont(new Font("System", Font.BOLD, 24));
        text.setBackground(Color.white);
        image.add(text);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(270,250,160,50);
        deposit.setBackground(Color.white);
        deposit.addActionListener(this);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(470,250,160,50);
        withdraw.setBackground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(270,320,160,50);
        fastCash.setBackground(Color.white);
        fastCash.addActionListener(this);
        image.add(fastCash);

        statement = new JButton("statement");
        statement.setBounds(470,320,160,50);
        statement.setBackground(Color.white);
        statement.addActionListener(this);
        image.add(statement);

        pinChange = new JButton("PIN Change");
        pinChange.setBounds(270,390,160,50);
        pinChange.setBackground(Color.white);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("Balance Enqury");
        balance.setBounds(470,390,160,50);
        balance.setBackground(Color.white);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("exit");
        exit.setBounds(470,460,160,50);
        exit.setBackground(Color.white);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(false);
        setVisible(true);

    }


    public static void main(String[] args) {
        new Transactions("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {
            System.exit(0);

        } else if (e.getSource()==deposit) {
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);

        }


    }
}
