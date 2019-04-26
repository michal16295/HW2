package GUI;

import game.enums.Competition;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class panelCompetition extends JPanel {
    private JLabel CreateCompLabel;
    private JLabel ChooseCompLabel;
    private JLabel MaxCompLabel;
    private JLabel DisciplineLabel;
    private JLabel LeagueLabel;
    private JLabel GenderLabel;

    private JComboBox ChooseCompCombobox;
    private JComboBox DisciplineCombobox;
    private JComboBox LeagueCombobox;
    private JComboBox GenderCombobox;

    private JTextField MaxCompText;
    private JButton CreateCompBtn;
    Border blackLine;

    public panelCompetition(){
        this.setSize(new Dimension(300,400));
        //Setting the layout
        setLayout(new GridLayout(12, 1));
        blackLine = BorderFactory.createLineBorder(Color.black);

        //Create competition label
        CreateCompLabel = new JLabel("CREATE COMPETITION");
        CreateCompLabel.setForeground(Color.blue);

        //choose competition
        ChooseCompLabel = new JLabel("Choose Competition");
        ChooseCompCombobox = new JComboBox(Competition.values());
        ChooseCompCombobox.setPreferredSize(new Dimension(140,20));
        ChooseCompCombobox.setMaximumSize(new Dimension(140, 20));

        //Max competitors
        MaxCompLabel = new JLabel("Max Competitors Number");
        MaxCompText = new JTextField("10");
        MaxCompText.setPreferredSize(new Dimension(140,20));
        MaxCompText.setMaximumSize(new Dimension(140, 20));

        //Discipline
        DisciplineLabel = new JLabel("Discipline");
        DisciplineCombobox = new JComboBox(Discipline.values());
        DisciplineCombobox.setPreferredSize(new Dimension(140,20));
        DisciplineCombobox.setMaximumSize(new Dimension(140,20));

        //League
        LeagueLabel = new JLabel("League");
        LeagueCombobox = new JComboBox(League.values());
        LeagueCombobox.setPreferredSize(new Dimension(140, 20));
        LeagueCombobox.setMaximumSize(new Dimension(140, 20));

        //Gender
        GenderLabel = new JLabel("Gender");
        GenderCombobox = new JComboBox(Gender.values());
        GenderCombobox.setPreferredSize(new Dimension(140, 20));
        GenderCombobox.setMaximumSize(new Dimension(140, 20));

        //Create comp button
        CreateCompBtn = new JButton("Create Competition");



        add(CreateCompLabel);
        add(ChooseCompLabel);
        add(ChooseCompCombobox);
        add(MaxCompLabel);
        add(MaxCompText);
        add(DisciplineLabel);
        add(DisciplineCombobox);
        add(LeagueLabel);
        add(LeagueCombobox);
        add(GenderLabel);
        add(GenderCombobox);
        add(CreateCompBtn);
        setBorder(blackLine);

    }
}
