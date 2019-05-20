package GUI.leftpanel;

import GUI.GuiManager;
import GUI.PanelGame;
import GUI.leftpanel.infopanel.InfoTable;
import game.GameEngine;
import game.competition.Competitor;
import game.entities.sportsman.WinterSportsman;
import game.entities.sportsman.decorator.IWinterSportsman;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * competition panel - creating and adding competitors to the panel
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class PanelCompetitor extends JPanel {
    private JLabel addCompetitorLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel maxSpeedLabel;
    private JLabel accelerationLabel;
    private JLabel idLabel;
    private JTextField idText;
    private JTextField nameTextField;
    private JTextField ageTextField;
    private JTextField maxSpeedText;
    private JTextField accelerationText;
    private JButton addCompetitorBtn;
    private JButton cloneBtn;
    private Border blackline;

    /**
     * Default ctor
     */
    public PanelCompetitor() {
        createUI();

        addButtonListener();

        addUiToPanel();
    }

    /**
     * Adds action listener to button when clicked
     */
    private void addButtonListener() {
        addCompetitorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (GuiManager.getPanelInfo().isInRace()) {
                    return;
                }
                GameEngine engine = GameEngine.getInstance();
                if (engine.getArena() == null && engine.getComp() == null) {
                    JOptionPane.showMessageDialog(null, "Please build arena, create competition and then add competitors", "Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                if (engine.getComp() == null) {
                    JOptionPane.showMessageDialog(null, "Please create competition and then add competitors", "Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                addCompetitor();

            }
        });
        cloneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (GameEngine.getInstance().getComp().hasActiveCompetitors()) {
                        new CloneCompetitorPanel();
                    } else {
                        JOptionPane.showMessageDialog(null, "There are no competitors", "Message", JOptionPane.ERROR_MESSAGE);
                        return;

                    }
                } catch (NullPointerException ex) {
                    JOptionPane.showMessageDialog(null, "Build Arena, create competition and then create competitors to clone", "Message", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
    }

    /**
     * creating the labels, comboboxes and text fields
     */
    private void createUI() {
        setLayout(new GridLayout(13, 1));
        blackline = BorderFactory.createLineBorder(Color.black);

        //Add competitor label
        addCompetitorLabel = new JLabel("ADD COMPETITOR");
        addCompetitorLabel.setForeground(Color.blue);

        //Setting the name
        nameLabel = new JLabel("Name");
        nameTextField = new JTextField();

        //Setting the age
        ageLabel = new JLabel("Age");
        ageTextField = new JTextField();

        //Setting max speed
        maxSpeedLabel = new JLabel("Max speed");
        maxSpeedText = new JTextField();

        //Setting Acceleration
        accelerationLabel = new JLabel("Acceleration");
        accelerationText = new JTextField();

        //Add competitor button
        addCompetitorBtn = new JButton("Add competitor");

        //Setting id
        idLabel = new JLabel("ID");
        idText = new JTextField();

        //clone button
        cloneBtn = new JButton("Clone Competitor");
    }

    /**
     * Adding the data to the panel
     */
    private void addUiToPanel() {
        add(addCompetitorLabel);
        add(idLabel);
        add(idText);
        add(nameLabel);
        add(nameTextField);
        add(ageLabel);
        add(ageTextField);
        add(maxSpeedLabel);
        add(maxSpeedText);
        add(accelerationLabel);
        add(accelerationText);
        add(addCompetitorBtn);
        add(cloneBtn);
        setBorder(blackline);
    }

    /**
     * Adding the competitor
     */
    private void addCompetitor() {
        PanelGame game = GuiManager.getPanelGame();

        try {
            String name = nameTextField.getText();
            double age = Double.parseDouble(ageTextField.getText());
            double maxSpeed = Double.parseDouble(maxSpeedText.getText());
            double acceleration = Double.parseDouble(accelerationText.getText());
            int id = Integer.parseInt(idText.getText());

            Object o = GameEngine.getInstance().createAndAddSportsman(id, name, age, acceleration, maxSpeed);

            game.setPlayerIcon((WinterSportsman) o);
            game.addCompetitor((Competitor) o);

            //adding the player to the info table
            InfoTable.getModel().addRow(name, 0.0, maxSpeed, 0.0, "No", ((WinterSportsman) o).getState().toString());
            new ModifyFrame((IWinterSportsman) o);


            emptyFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Age, Max Speed and Acceleration must be a number", "Message", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(null, "Illegal competitor", "Message", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(null, "Reached maximum competitors", "Message", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        } catch (IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "Id already exists", "Message", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Invalid input! try again", "Message", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
            return;
        }

    }

    /**
     * Reset all fields
     */
    private void emptyFields() {
        idText.setText("");
        nameTextField.setText("");
        ageTextField.setText("");
        maxSpeedText.setText("");
        accelerationText.setText("");
    }
}
