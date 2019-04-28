package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Main frame:
 * - left panel : Game panel
 * - right panel : Input panel
 */

public class mainFrame extends JFrame {
    public mainFrame(){
        //MAIN FRAME
        super("Competition");
        //MAIN PANEL
        JPanel p = new JPanel(new BorderLayout());
        //LEFT PANEL
        panelGame gamePane = new panelGame();
        //RIGHT PANEL
        inputPane input = new inputPane();
        p.add(gamePane, BorderLayout.CENTER);
        p.add(input, BorderLayout.EAST);
        add(p);
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 700));
        setVisible(true);
        this.setGuiManager(gamePane, input);

    }

    /**
     * sending the panels to the gui manager
     * @param _panelGame
     * @param input
     */
    public void setGuiManager(panelGame _panelGame, inputPane input){
        GuiManager.getInstance().set_inputPane(input);
        GuiManager.getInstance().set_panelGame(_panelGame);
        GuiManager.getInstance().set_mainFrame(this);
    }

}
