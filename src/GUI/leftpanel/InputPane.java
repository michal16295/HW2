package GUI.leftpanel;

import GUI.GuiManager;
import GUI.leftpanel.infopanel.PanelInfo;

import javax.swing.*;
import java.awt.*;

/**
 * The right panel - holds: Build arena, Create competition, Add competitor, Start competition and show info
 */
public class InputPane extends JPanel {
    private PanelInfo info;

    /**
     * Input panel ctor
     */
    public InputPane() {
        info = new PanelInfo();
        PanelArena arena = new PanelArena();
        PanelCompetition comp = new PanelCompetition();
        PanelCompetitor competitor = new PanelCompetitor();

        // Setting the layout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 2;
        add(arena, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        add(comp, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(competitor, gbc);


        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 0.1;
        add(info, gbc);

        updateGuiManager();
    }

    /**
     * Setting the panels in the Gui manager
     */
    private void updateGuiManager() {
        GuiManager.setPanelInfo(info);
    }
}
