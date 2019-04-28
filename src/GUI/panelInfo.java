package GUI;

import game.GameEngine;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class panelInfo extends JPanel {
    private JButton start;
    private JButton show;
    private boolean inRace;

    public panelInfo(panelGame _panelGame){
        setLayout(new GridLayout(2, 1));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        start = new JButton("Start Competition");
        show = new JButton("Show info");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!inRace){
                    GameEngine.getInstance().getComp().startRace();
                    _panelGame.startRace();
                    inRace = true;
                }
            }
        });
        add(start);
        add(show);
        setBorder(blackline);
    }
    public void setInRace(boolean inRace){
        this.inRace = inRace;
    }
}
