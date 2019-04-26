package GUI;

import javax.swing.*;
import java.awt.*;


public class mainFrame {
    private JFrame frame;
    public mainFrame(){
        //MAIN FRAME
        frame = new JFrame("Competition");
        //MAIN PANEL
        JPanel p = new JPanel(new BorderLayout());
        //LEFT PANEL
        panelGame gamePane = new panelGame();
        //RIGHT PANEL
        inputPane input = new inputPane(gamePane, this);
        p.add(gamePane, BorderLayout.CENTER);
        p.add(input, BorderLayout.EAST);
        frame.add(p);
        frame.pack();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(1000, 700));
        frame.setVisible(true);
    }
    public void setSize(int w, int h){
        frame.setSize(new Dimension(w, h));
    }


}
