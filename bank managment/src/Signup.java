import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

public class Signup extends JFrame {

    Signup() {

        setLayout(null);

        Random ran = new Random();
        long no = Math.abs((ran.nextLong() % 9000L) + 1000L);


        JLabel formno = new JLabel("ЗАЯВЛЕНИЕ № : " + no);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(220, 20, 600, 40);
        add(formno);

        JLabel personalDetails = new JLabel("Page 1: Личная Информация");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);

        JLabel name = new JLabel("Имя :");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 150, 30);
        add(name);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(new Font("Raleway", Font.BOLD,20));
        nameTextField.setBounds(300,140,400,30);
        add(nameTextField);

        JLabel surname = new JLabel("Фамилия :");
        surname.setFont(new Font("Raleway", Font.BOLD, 22));
        surname.setBounds(100, 190, 150, 30);
        add(surname);

        JTextField surnameTextField = new JTextField();
        surnameTextField.setFont(new Font("Raleway", Font.BOLD,20));
        surnameTextField.setBounds(300,190,400,30);
        add(surnameTextField);

        JLabel birthday = new JLabel("День рождения :");
        birthday.setFont(new Font("Raleway", Font.BOLD, 22));
        birthday.setBounds(100, 240, 200, 30);
        add(birthday);

        JTextField birthdayTextField = new JTextField();
        birthdayTextField.setFont(new Font("Raleway", Font.BOLD,20));
        birthdayTextField.setBounds(300,240,400,30);
        add(birthdayTextField);

        JLabel gender = new JLabel("Пол :");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        JRadioButton male = new JRadioButton("Мужчина");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.WHITE);
        add(male);

        JRadioButton female = new JRadioButton("Женщина");
        female.setBounds(400,290,100,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);


        JLabel email = new JLabel("Почта :");
        email.setFont(new Font("Raleway", Font.BOLD, 22));
        email.setBounds(100, 340, 200, 30);
        add(email);

        JTextField emailTextField = new JTextField();
        emailTextField.setFont(new Font("Raleway", Font.BOLD,20));
        emailTextField.setBounds(300,340,400,30);
        add(emailTextField);

        JLabel adress = new JLabel("Адрес :");
        adress.setFont(new Font("Raleway", Font.BOLD, 22));
        adress.setBounds(100, 390, 200, 30);
        add(adress);

        JTextField adressTextField = new JTextField();
        adressTextField.setFont(new Font("Raleway", Font.BOLD,20));
        adressTextField.setBounds(300,390,400,30);
        add(adressTextField);

        JLabel city = new JLabel("Город :");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 440, 200, 30);
        add(city);

        JTextField cityTextField = new JTextField();
        cityTextField.setFont(new Font("Raleway", Font.BOLD,20));
        cityTextField.setBounds(300,440,400,30);
        add(cityTextField);

        JLabel pin = new JLabel("Пин Код :");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 490, 200, 30);
        add(pin);

        JTextField pinTextField = new JTextField();
        pinTextField.setFont(new Font("Raleway", Font.BOLD,20));
        pinTextField.setBounds(300,490,400,30);
        add(pinTextField);

        JButton next = new JButton("Next");
        next.setBounds(600, 550, 100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 850);
        setLocation(350, 10);
        setVisible(true);


    }

    public static void main(String[] args) {

        new Signup();
    }

}

