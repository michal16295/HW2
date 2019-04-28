package GUI;

import GUI.leftpanel.InputPane;

import javax.swing.*;
import java.awt.*;

/**
 * Main frame:
 * - left panel : Game panel
 * - right panel : Input panel
 */
public class MainFrame extends JFrame {
    /**
     * Default ctor
     */
    public MainFrame() {
        super("Competition");

        buildFrame();
    }

    /**
     * Creates the frame and creates all the game panels.
     */
    private void buildFrame() {
        //MAIN PANEL
        JPanel p = new JPanel(new BorderLayout());

        //LEFT PANEL
        PanelGame gamePane = new PanelGame();

        //RIGHT PANEL
        InputPane input = new InputPane();

        p.add(gamePane, BorderLayout.CENTER);
        p.add(input, BorderLayout.EAST);

        add(p);
        pack();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 700));
        setVisible(true);

        updateGuiManager(gamePane);
    }

    /**
     * sending the panels to the gui manager
     *
     * @param panelGame the game panel
     */
    private void updateGuiManager(PanelGame panelGame) {
        GuiManager.setPanelGame(panelGame);
        GuiManager.setMainFrame(this);
    }

}
