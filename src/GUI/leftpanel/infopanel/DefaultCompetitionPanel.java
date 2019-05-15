package GUI.leftpanel.infopanel;

import GUI.GuiManager;
import GUI.PanelGame;
import game.GameEngine;
import game.arena.IArena;
import game.competition.Competition;
import game.competition.Competitor;
import game.entities.sportsman.Skier;
import game.entities.sportsman.WinterSportsman;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Quick Competition panel - creates default competition.
 * Creating a default Arena , Competition and competitors
 */

public class DefaultCompetitionPanel extends JFrame {
    private JLabel numOfCompetitorsLabel;
    private JTextField numOfCompText;
    private JButton createBtn;

    /**
     * default ctor
     */
    public DefaultCompetitionPanel(){
        super("Default Competition");
        createUI();

        addButtonListener();

        addUiToPanel();

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(300, 150));
        setVisible(true);
    }

    /**
     * creating the UI
     * Number of competitors the player wishes to clone
     */
    private void createUI() {
        setLayout(new GridLayout(3, 1));
        numOfCompetitorsLabel = new JLabel("Enter the number of competitors (Max Competitors: 10)");
        numOfCompText = new JTextField();
        createBtn = new JButton("Create Competition");

    }

    /**
     * create competition button
     */
    private void addButtonListener(){
        createBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    GuiManager.getPanelInfo().setInRace(false);
                    PanelGame game = GuiManager.getPanelGame();
                    int numOfCompetitors = Integer.parseInt(numOfCompText.getText());
                    //Building the competition
                    GameEngine.getInstance().buildDefaultComp();
                    if(numOfCompetitors > GameEngine.getInstance().getComp().getMaxCompetitors()){
                        JOptionPane.showMessageDialog(null, "Reached maximum competitors", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    //Getting the arena
                    IArena arena = GameEngine.getInstance().getArena();
                    game.setBackgroundImage(arena.getCondition(), 1000, (int)arena.getLength());
                    createDefaultCompetitors(numOfCompetitors,arena,game);

                }catch (Exception ex){
                    ex.printStackTrace();
                }
                dispose();
            }

        });
    }

    /**
     * adding the UI to the panel
     */
    private void addUiToPanel(){
        add(numOfCompetitorsLabel);
        add(numOfCompText);
        add(createBtn);
    }

    /**
     * Creating a quick competition, the user enters the number of competitors
     * @param numOfCompetitors users input
     * @param arena default arena - Winter Arena
     * @param game the game panel
     */
    private void createDefaultCompetitors(int numOfCompetitors, IArena arena, PanelGame game){
        Competition comp = GameEngine.getInstance().getComp();
        //creating the first competitor- from him we will clone
        Skier skier = new Skier(arena);
        skier.setId(0);
        game.setPlayerIcon(skier);
        //adding the first player to the competition
        try{
            comp.addCompetitor(skier);
        }catch (IllegalAccessException ex){
            JOptionPane.showMessageDialog(null, "Id already exists", "Message", JOptionPane.ERROR_MESSAGE);

        }
        //adding the player to the game panel
        game.addCompetitor(skier);
        //adding the player to the info table
        InfoTable.getModel().addRow(skier.getName(), 0.0, skier.getMaxSpeed(), 0.0, "No");
        //loop that adds players by the number of players the user has chosen
        for(int i = 1 ; i < numOfCompetitors  ; i++){
           try{
               //using the clone method to clone players from the first player we created
                Competitor skier1 = comp.cloneCompetitor(i-1, i, "red");
                game.setPlayerIcon((WinterSportsman) skier1);
                game.addCompetitor(skier1);
                InfoTable.getModel().addRow(skier.getName(), 0.0, skier.getMaxSpeed(), 0.0, "No");
            }catch (Exception ex){
               ex.printStackTrace();
           }
        }
    }

}
