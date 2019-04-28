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

/**
 * competition panel - creating and adding competitors to the panel
 */

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
    private Border blackline;

    public panelCompetitor(){
        createData();
        //After pressing the button
        AddCompetitorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GuiManager.getInstance().get_panelInfo().isInRace()) {
                    return;
                }
                panelGame game = GuiManager.getInstance().get_panelGame();
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
                    addCompetitor(game, comp);

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
        addData();

    }

    /**
     * creating the labels, comboboxes and text fields
     */
    public void createData(){
        setLayout(new GridLayout(10 ,1));
        blackline = BorderFactory.createLineBorder(Color.black);

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
    }

    /**
     * adding the data to the panel
     */
    public void addData(){
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

    /**
     * adding the competitor
     * @param game
     * @param comp
     */
    public void addCompetitor(panelGame game,Competition comp){
        try{
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

            //dynamic class
            String type = GameEngine.getInstance().getPlayerType();
            Class aClass = getClass().getClassLoader().loadClass(type);
            Constructor ctor = aClass.getConstructor(String.class, double.class, Gender.class, double.class, double.class, Discipline.class, IArena.class);
            Object o = ctor.newInstance(name, age, comp.getGender(),acceleration ,maxSpeed ,comp.getDiscipline(),GameEngine.getInstance().getArena());
            GameEngine.getInstance().addSportsman((WinterSportsman)o);
            game.playerIcon((WinterSportsman)o);
            game.addCompetitor((Competitor)o);
            //adding the player to the info table
            InfoTable.getModel().addRow(name, 0.0, maxSpeed, 0.0, "No");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
