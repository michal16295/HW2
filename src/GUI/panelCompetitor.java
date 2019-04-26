package GUI;

import game.enums.Discipline;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelCompetitor extends JPanel {
    private JLabel AddCompetitorLabel;
    private JLabel NameLabel;
    private JLabel AgeLabel;
    private JLabel MaxSpeedLabel;
    private JLabel AccelerationLabel;

    private JTextField NameTextField;
    private JTextField AgeTextField;
    private JTextField MaxSpeedText;
    private JTextField AccelerationText;
    private JButton AddCompetitorBtn;


    public panelCompetitor(){
        setLayout(new GridLayout(10 ,1));
        Border blackline = BorderFactory.createLineBorder(Color.black);

        //Add competitor label
        AddCompetitorLabel = new JLabel("ADD COMPETITOR");
        AddCompetitorLabel.setForeground(Color.blue);

        //Setting the name
        NameLabel = new JLabel("Name");
        NameTextField = new JTextField();

        //Setting the age
        AgeLabel = new JLabel("Age");
        AgeTextField = new JTextField();

        //Setting max speed
        MaxSpeedLabel = new JLabel("Max speed");
        MaxSpeedText = new JTextField();

        //Setting Acceleration
        AccelerationLabel = new JLabel("Acceleration");
        AccelerationText = new JTextField();

        //Add competitor button
        AddCompetitorBtn = new JButton("Add competitor");
        AddCompetitorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Name
                String name = (String)NameTextField.getText();

                //Age
                double age = Double.parseDouble(AgeTextField.getText());

                //Max Speed
                double maxSpeed = Double.parseDouble(MaxSpeedText.getText());

                //Acceleration
                double acceleration = Double.parseDouble(AccelerationText.getText());
            }
        });


        add(AddCompetitorLabel);
        add(NameLabel);
        add(NameTextField);
        add(AgeLabel);
        add(AgeTextField);
        add(MaxSpeedLabel);
        add(MaxSpeedText);
        add(AccelerationLabel);
        add(AccelerationText);
        add(AddCompetitorBtn);
        setBorder(blackline);
    }
}
