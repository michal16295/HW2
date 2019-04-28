package GUI.leftpanel.infopanel;

import GUI.GuiManager;
import game.GameEngine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInfo extends JPanel {
    private JButton start;
    private JButton show;
    private boolean inRace;

    public PanelInfo() {
        setLayout(new GridLayout(2, 1));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        start = new JButton("Start Competition");
        show = new JButton("Show info");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        add(start);
        add(show);
        setBorder(blackline);
    }

    public void setInRace(boolean inRace) {
        this.inRace = inRace;
    }

    public boolean isInRace() {
        return inRace;
    }
}
