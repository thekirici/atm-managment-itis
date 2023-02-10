import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener {

    JButton back, change;

    JTextField pin, rePin;
    static String pinnumber;
    PinChange(String pinnumber) {
        this.pinnumber = pinnumber;

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image img2 = img.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon img3 = new ImageIcon(img2);
        JLabel image = new JLabel(img3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Измените свой пароль");
        text.setFont(new Font("System", Font.BOLD, 23));
        text.setBounds(300, 250, 350, 30);
        text.setForeground(Color.black);
        image.add(text);

        JLabel pinText = new JLabel("Новый PIN-код: ");
        pinText.setFont(new Font("System", Font.BOLD, 16));
        pinText.setBounds(300, 300, 200, 30);
        pinText.setForeground(Color.black);
        image.add(pinText);

        pin = new JTextField();
        pin.setFont(new Font("Raleway", Font.BOLD, 25));
        pin.setBounds(450, 300, 100, 30);
        image.add(pin);

        JLabel rePinText = new JLabel("Новый PIN-код: ");
        rePinText.setFont(new Font("System", Font.BOLD, 16));
        rePinText.setBounds(300, 350, 200, 30);
        rePinText.setForeground(Color.black);
        image.add(rePinText);

        rePin = new JTextField();
        rePin.setFont(new Font("Raleway", Font.BOLD, 25));
        rePin.setBounds(450, 350, 100, 30);
        image.add(rePin);

        back = new JButton("Назад");
        back.setFont(new Font("Raleway", Font.BOLD, 25));
        back.setBounds(290, 460, 160, 50);
        back.addActionListener(this);
        back.setBackground(Color.white);
        image.add(back);

        change = new JButton("Изменять");
        change.setBounds(470, 460, 160, 50);
        change.setFont(new Font("Raleway", Font.BOLD, 25));
        change.setBackground(Color.white);
        change.addActionListener(this);
        image.add(change);


        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinChange(pinnumber);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==change){
            try {
                String nPin = pin.getText();
                String rPin = pin.getText();
                if (!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Введено неправильно.");
                    return;
                }
                if (nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Введите PIN-код.");
                    return;
                }
                if (rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Введите PIN-код.");
                    return;
                }

                Conn c = new Conn();
                String query = "update bank set pinnumber = '" + rPin + "' where pinnumber ='" + pinnumber + "' ";
                String query2 = "update signup set pinnumber = '" + rPin + "' where pinnumber ='" + pinnumber + "' ";
                String query3 = "update encryption set pinnumber = '" + rPin + "' where pinnumber ='" + pinnumber + "' ";

                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN-код успешно изменен.");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);

            } catch (Exception exception) {
                System.out.println(exception);
            }
        }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }


    }
}
