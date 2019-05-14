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

public class DefaultCompetitionPanel extends JFrame {
    private JLabel numOfCompetitorsLabel;
    private JTextField numOfCompText;
    private JButton createBtn;

    public DefaultCompetitionPanel(){
        super("Default Competition");
        createUI();

        addButtonListener();

        addUiToPanel();

        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(250, 150));
        setVisible(true);
    }

    private void createUI() {
        setLayout(new GridLayout(3, 1));
        numOfCompetitorsLabel = new JLabel("Enter the number of competitors (Max Competitors: 10)");
        numOfCompText = new JTextField();
        createBtn = new JButton("Create Competition");

    }
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
    private void addUiToPanel(){
        add(numOfCompetitorsLabel);
        add(numOfCompText);
        add(createBtn);
    }
    private void createDefaultCompetitors(int numOfCompetitors, IArena arena, PanelGame game){
        Competition comp = GameEngine.getInstance().getComp();
        Skier skier = new Skier(arena);
        skier.setId(0);
        game.setPlayerIcon(skier);
        comp.addCompetitor(skier);
        game.addCompetitor(skier);
        InfoTable.getModel().addRow(skier.getName(), 0.0, skier.getMaxSpeed(), 0.0, "No");
        for(int i = 1 ; i < numOfCompetitors  ; i++){
           try{
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
