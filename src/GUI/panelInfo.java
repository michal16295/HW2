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

    public panelInfo(panelGame _panelGame){
        setLayout(new GridLayout(2, 1));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        start = new JButton("Start Competition");
        show = new JButton("Show info");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameEngine.getInstance().getComp().startRace();
                _panelGame.startRace();

            }
        });
        add(start);
        add(show);
        setBorder(blackline);
    }
}
