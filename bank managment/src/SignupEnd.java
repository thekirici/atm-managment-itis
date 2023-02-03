import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupEnd extends JFrame implements ActionListener {

    JLabel details, card, number, pin, pinnumber, carddetails, pindetails;
    JButton send;
    SignupEnd(){

        setLayout(null);

        JLabel details = new JLabel("Accound Details");
        details.setFont(new Font("Raleway", Font.BOLD, 38));
        details.setBounds(220, 20, 600, 40);
        add(details);

        card = new JLabel("Card Number");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 140, 200, 30);
        add(card);

        number = new JLabel("XXXX-XXXX-XXXX-5001");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(300, 140, 400, 30);
        add(number);

        carddetails = new JLabel("Your 16 digits card number");
        carddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetails.setBounds(100, 170, 200, 20);
        add(carddetails);

        pin = new JLabel("Pin number :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 230, 200, 30);
        add(pin);

        pinnumber = new JLabel("XXXX");
        pinnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pinnumber.setBounds(300, 230, 400, 30);
        add(pinnumber);

        pindetails = new JLabel("Your 4 digits Password");
        pindetails.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetails.setBounds(100, 260, 200, 20);
        add(pindetails);

        send = new JButton("Submit");
        send.setBounds(500, 350, 100, 30);
        send.setBackground(Color.black);
        send.setForeground(Color.white);
        send.addActionListener(this);
        add(send);

        getContentPane().setBackground(Color.white);

        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new SignupEnd();
    }

}
