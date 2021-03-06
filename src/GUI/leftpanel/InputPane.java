package GUI.leftpanel;

import GUI.GuiManager;
import GUI.leftpanel.infopanel.PanelInfo;

import javax.swing.*;
import java.awt.*;

/**
 * The right panel - holds: Build arena, Create competition, Add competitor, Start competition and show info
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
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
        gbc.weighty = 1;
        add(arena, gbc);


        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 1.5;
        add(comp, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.6;
        add(competitor, gbc);


        gbc.gridx = 0;
        gbc.gridy = 4;
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
