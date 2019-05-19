package GUI.leftpanel.infopanel;

import GUI.GuiManager;
import GUI.PanelGame;
import game.GameEngine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Panel info - holds start competition and show info buttons
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class PanelInfo extends JPanel {
    private boolean inRace;

    /**
     * Default ctor
     */
    public PanelInfo() {
        setLayout(new GridLayout(3, 1));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        JButton start = new JButton("Start Competition");
        JButton show = new JButton("Show info");
        JButton defaultBtn = new JButton("Create Default Competition");

        defaultBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiManager.getPanelGame().clearCompetitorsArray();
                InfoTable.getModel().deleteData();
                new DefaultCompetitionPanel();
            }
        });
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameEngine.getInstance().getComp().destiny();
                if (!inRace) {
                    GameEngine.getInstance().getComp().startRace();
                    GuiManager.getPanelGame().startRace();
                    inRace = true;
                }
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InfoTable.createInstance();
            }
        });
        add(defaultBtn);
        add(start);
        add(show);
        setBorder(blackline);
    }

    /**
     * Updates the is the competition began
     *
     * @param inRace true if the competition began, false otherwise
     */
    public void setInRace(boolean inRace) {
        this.inRace = inRace;
    }

    /**
     * @return if competition has began
     */
    public boolean isInRace() {
        return inRace;
    }
}
