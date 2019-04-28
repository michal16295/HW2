package GUI;

import javax.swing.*;
import java.awt.*;

public class inputPane extends JPanel {
    private panelArena arena;
    private panelCompetition comp;
    private panelCompetitor competitor;
    private panelInfo info;

    public inputPane(){
        info = new panelInfo();
        arena = new panelArena();
        comp = new panelCompetition();
        competitor = new panelCompetitor();


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

        this.setGuiManager();

    }
    public void setGuiManager(){
        GuiManager.getInstance().set_panelInfo(info);
        GuiManager.getInstance().set_panelArena(arena);
        GuiManager.getInstance().set_panelCompetition(comp);
        GuiManager.getInstance().set_panelCompetitor(competitor);
    }
}
