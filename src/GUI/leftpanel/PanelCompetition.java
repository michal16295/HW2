package GUI.leftpanel;

import GUI.GuiManager;
import GUI.PanelGame;
import GUI.leftpanel.infopanel.InfoTable;
import GUI.leftpanel.infopanel.PanelInfo;
import game.GameEngine;
import game.enums.Competition;
import game.enums.Discipline;
import game.enums.Gender;
import game.enums.League;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Competition panel - Creates the competition
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class PanelCompetition extends JPanel {
    private JLabel createCompLabel;
    private JLabel chooseCompLabel;
    private JLabel maxCompLabel;
    private JLabel disciplineLabel;
    private JLabel leagueLabel;
    private JLabel genderLabel;
    private JLabel threadsLabel;

    private JComboBox chooseCompCombobox;
    private JComboBox disciplineCombobox;
    private JComboBox leagueCombobox;
    private JComboBox genderCombobox;

    private JTextField maxCompText;
    private JTextField threadsText;
    private JButton createCompBtn;
    private Border blackLine;

    /***
     * panel competition ctor
     */
    public PanelCompetition() {
        createUI();

        addButtonListener();

        addUiToPanel();
    }

    /**
     * Adds action listener to button when clicked
     */
    private void addButtonListener() {
        createCompBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGame game = GuiManager.getPanelGame();
                PanelInfo info = GuiManager.getPanelInfo();
                String type = chooseCompCombobox.getSelectedItem().toString();

                //check if arena exists
                if (GameEngine.getInstance().getArena() == null) {
                    JOptionPane.showMessageDialog(null, "Please build arena first", "Message", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int maxComp;
                try {
                    //max competitors
                    maxComp = Integer.parseInt(maxCompText.getText());
                    if (maxComp < 1 || maxComp > 20) {
                        JOptionPane.showMessageDialog(null, "Max competitors should be a between 1 to 20", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Max competitors should be a number", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }

                int threads;
                try {
                    threads = Integer.parseInt(threadsText.getText());
                    if (threads < 1 || threads > 10) {
                        JOptionPane.showMessageDialog(null, "Threads should be a between 1 to 10", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Threads should be a number", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                    return;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    return;
                }

                createCompetition(info, game, type, maxComp, threads);
            }
        });
    }

    /**
     * creating the labels, comboboxes and text fields
     */
    private void createUI() {
        this.setSize(new Dimension(300, 400));
        //Setting the layout
        setLayout(new GridLayout(14, 1));
        blackLine = BorderFactory.createLineBorder(Color.black);

        //Create competition label
        createCompLabel = new JLabel("CREATE COMPETITION");
        createCompLabel.setForeground(Color.blue);

        //choose competition
        chooseCompLabel = new JLabel("Choose Competition");
        chooseCompCombobox = new JComboBox(Competition.values());

        //Max competitors
        maxCompLabel = new JLabel("Max Competitors Number");
        maxCompText = new JTextField("10");

        //Discipline
        disciplineLabel = new JLabel("Discipline");
        disciplineCombobox = new JComboBox(Discipline.values());

        //League
        leagueLabel = new JLabel("League");
        leagueCombobox = new JComboBox(League.values());

        //Gender
        genderLabel = new JLabel("Gender");
        genderCombobox = new JComboBox(Gender.values());

        //Threads
        threadsLabel = new JLabel("Threads");
        threadsText = new JTextField("5");

        //Create comp button
        createCompBtn = new JButton("Create Competition");
    }

    /**
     * adding the data to the panel
     */
    private void addUiToPanel() {
        add(createCompLabel);
        add(chooseCompLabel);
        add(chooseCompCombobox);
        add(maxCompLabel);
        add(maxCompText);
        add(disciplineLabel);
        add(disciplineCombobox);
        add(leagueLabel);
        add(leagueCombobox);
        add(genderLabel);
        add(genderCombobox);
        add(threadsLabel);
        add(threadsText);
        add(createCompBtn);
        setBorder(blackLine);
    }

    /**
     * creating the competition
     *
     * @param info    the info panel
     * @param game    the game panel
     * @param type    the class type
     * @param maxComp maximum competitors
     */
    private void createCompetition(PanelInfo info, PanelGame game, String type, int maxComp, int threads) {
        Discipline discipline = (Discipline) disciplineCombobox.getSelectedItem();
        League league = (League) leagueCombobox.getSelectedItem();
        Gender gender = (Gender) genderCombobox.getSelectedItem();

        GameEngine engine = GameEngine.getInstance();
        engine.setType((Competition) chooseCompCombobox.getSelectedItem());
        engine.buildCompetition(type, maxComp, discipline, league, gender, threads);

        //init the race
        game.clearCompetitorsArray();
        InfoTable.getModel().deleteData();
        info.setInRace(false);
    }
}
