package GUI.leftpanel;

import GUI.GuiManager;
import GUI.PanelGame;
import GUI.leftpanel.infopanel.InfoTable;
import game.GameEngine;
import game.competition.Competitor;
import game.entities.sportsman.WinterSportsman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clone panel- the user enters the number of players he wants to clone
 */
public class CloneCompetitorPanel extends JFrame{
    private JTextField idText;
    private JLabel newIdLabel;
    private JLabel idLabel;
    private JLabel colorLabel;
    private JTextField newIdText;
    private JComboBox colorText;
    private JLabel cloneCompetitorLabel;
    private JButton cloneBtn;

    /**
     * default ctor
     */
    public CloneCompetitorPanel() {
        super("Clone Competitor");
        createUI();

        addButtonListener();

        addUiToPanel();

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(300, 300));
        setVisible(true);
    }

    /**
     * adding all of the UI to the panel
     */
    private void addUiToPanel() {
        add(cloneCompetitorLabel);
        add(idLabel);
        add(idText);
        add(newIdLabel);
        add(newIdText);
        add(colorLabel);
        add(colorText);
        add(cloneBtn);
    }

    /**
     * The clone button
     * @throws NullPointerException
     */
    private void addButtonListener() throws NullPointerException {
        cloneBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PanelGame game = GuiManager.getPanelGame();
                    int oldId = Integer.parseInt(idText.getText());
                    int newId = Integer.parseInt(newIdText.getText());
                    String color = colorText.getSelectedItem().toString();
                    try {
                        //cloning and creating a new player from the id that was given
                        Competitor newComp = GameEngine.getInstance().getComp().cloneCompetitor(oldId,newId,color);
                        game.addCompetitor(newComp);
                        game.setPlayerIcon((WinterSportsman) newComp);

                        //adding the player to the info table
                        InfoTable.getModel().addRow(newComp.getName(), 0.0, newComp.getMaxSpeed(), 0.0, "No", ((WinterSportsman) newComp).getState().toString());
                    }
                    catch (IllegalStateException ex){
                        JOptionPane.showMessageDialog(null, "There are no competitors", "Message", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }

                    catch (IllegalArgumentException ex) {
                        JOptionPane.showMessageDialog(null, "Id already exists", "Message", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }
                    catch (IllegalAccessException ex) {
                        JOptionPane.showMessageDialog(null, "Id doesnt exists", "Message", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                    }

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Id must be a number", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Invalid input!", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                }
                dispose();
            }
        });
    }

    /**
     * crating the UI
     */
    private void createUI() {
        setLayout(new GridLayout(8, 1));
        String [] colors = {"red", "blue","black","pink","green"};

        cloneCompetitorLabel = new JLabel("CLONE COMPETITOR");
        cloneCompetitorLabel.setForeground(Color.blue);
        //Setting the id
        idLabel = new JLabel("Enter competitor ID you wish to clone:");
        idText = new JTextField();
        newIdLabel = new JLabel("New ID:");
        newIdText = new JTextField();
        //Setting the color
        colorLabel = new JLabel("Set a new Color");
        colorText = new JComboBox(colors);
        //Setting the button
        cloneBtn = new JButton("Clone Competitor");
    }

}
