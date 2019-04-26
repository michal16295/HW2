package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class panelInfo extends JPanel {
    private JButton start;
    private JButton show;

    public panelInfo(){
        setLayout(new GridLayout(2, 1));
        Border blackline = BorderFactory.createLineBorder(Color.black);
        start = new JButton("Start Competition");
        show = new JButton("Show info");
        add(start);
        add(show);
        setBorder(blackline);
    }
}
