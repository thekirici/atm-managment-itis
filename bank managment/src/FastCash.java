import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdraw, fastCash, statement, pinChange, balance, exit;
    String pinnumber;

    FastCash(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image img2 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Select your Withdraw amonunt");
        text.setBounds(300, 175, 350, 30);
        text.setFont(new Font("System", Font.BOLD, 24));
        text.setBackground(Color.white);
        image.add(text);

        deposit = new JButton("1 000 руб");
        deposit.setBounds(270, 250, 160, 50);
        deposit.setBackground(Color.white);
        deposit.addActionListener(this);
        deposit.addActionListener(this);
        image.add(deposit);

        withdraw = new JButton("2 000 руб");
        withdraw.setBounds(470, 250, 160, 50);
        withdraw.setBackground(Color.white);
        withdraw.addActionListener(this);
        image.add(withdraw);

        fastCash = new JButton("5 000 руб");
        fastCash.setBounds(270, 320, 160, 50);
        fastCash.setBackground(Color.white);
        fastCash.addActionListener(this);
        image.add(fastCash);

        statement = new JButton("10 000 руб");
        statement.setBounds(470, 320, 160, 50);
        statement.setBackground(Color.white);
        statement.addActionListener(this);
        image.add(statement);

        pinChange = new JButton("20 000 руб");
        pinChange.setBounds(270, 390, 160, 50);
        pinChange.setBackground(Color.white);
        pinChange.addActionListener(this);
        image.add(pinChange);

        balance = new JButton("50 000 руб");
        balance.setBounds(470, 390, 160, 50);
        balance.setBackground(Color.white);
        balance.addActionListener(this);
        image.add(balance);

        exit = new JButton("exit");
        exit.setBounds(470, 460, 160, 50);
        exit.setBackground(Color.white);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(false);
        setVisible(true);

    }


    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == exit) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);

        } else {
            String amount = ((JButton)e.getSource()).getText().replaceAll("\\s", "").replaceAll("руб","");
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("SELECT * from bank where pinnumber ='"+pinnumber+"'");
                int balance = 0;
                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"', '"+date+"', 'Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Успешно сняли" +amount+ "рублей.");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch (Exception ex){
                System.out.println(ex);
            }
        }

    }
}
