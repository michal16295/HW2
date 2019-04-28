package GUI;

import game.GameEngine;
import game.arena.IArena;
import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.WinterSportsman;
import game.enums.Discipline;
import game.enums.Gender;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

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

    public panelCompetitor(panelGame _panelGame){
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
                try{
                    if(GameEngine.getInstance().getArena() == null && GameEngine.getInstance().getComp() == null){
                        JOptionPane.showMessageDialog(null, "Please build arena, create competition and then add competitors", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    if(GameEngine.getInstance().getComp() == null){
                        JOptionPane.showMessageDialog(null, "Please create competition and then add competitors", "Message", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                    Competition comp = GameEngine.getInstance().getComp();
                    //Name
                    String name = NameTextField.getText();
                    NameTextField.setText("");

                    //Age
                    double age = Double.parseDouble(AgeTextField.getText());
                    AgeTextField.setText("");

                    //Max Speed
                    double maxSpeed = Double.parseDouble(MaxSpeedText.getText());
                    MaxSpeedText.setText("");

                    //Acceleration
                    double acceleration = Double.parseDouble(AccelerationText.getText());
                    AccelerationText.setText("");

                    String type = GameEngine.getInstance().getPlayerType();
                    Class aClass = getClass().getClassLoader().loadClass(type);
                    Constructor ctor = aClass.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class, IArena.class);
                    Object o = ctor.newInstance(name, age, comp.getGender(),acceleration ,maxSpeed ,comp.getDiscipline(),GameEngine.getInstance().getArena());
                    GameEngine.getInstance().addtSportsman((WinterSportsman)o);
                    _panelGame.playerIcon((WinterSportsman)o);
                    _panelGame.addCompetitor((Competitor)o);


                }catch (IllegalStateException ex){
                    JOptionPane.showMessageDialog(null, "Reached maximum competitors", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();

                }
                catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Invalid input! try again", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
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
