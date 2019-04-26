package GUI;

import game.enums.Discipline;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class panelCompetitor extends JPanel {
    private JLabel label;
    private JLabel name;
    private JLabel age;
    private JLabel maxSpeed;
    private JLabel acceleration;

    private JTextField nameText;
    private JTextField ageText;
    private JTextField maxSpeedText;
    private JTextField acceText;
    private JButton addBtn;


    public panelCompetitor(){
        setLayout(new GridLayout(10 ,1));
        Border blackline = BorderFactory.createLineBorder(Color.black);

        label = new JLabel("ADD COMPETITOR");
        label.setForeground(Color.blue);
        name = new JLabel("Name");
        nameText = new JTextField();
        age = new JLabel("Age");
        ageText = new JTextField();
        maxSpeed = new JLabel("Max speed");
        maxSpeedText = new JTextField();
        acceleration = new JLabel("Acceleration");
        acceText = new JTextField();
        addBtn = new JButton("Add competitor");


        add(label);
        add(name);
        add(nameText);
        add(age);
        add(ageText);
        add(maxSpeed);
        add(maxSpeedText);
        add(acceleration);
        add(acceText);
        add(addBtn);
        setBorder(blackline);
    }
}
