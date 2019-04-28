package GUI;

import GUI.leftpanel.infopanel.PanelInfo;
import GUI.leftpanel.InputPane;
import GUI.leftpanel.PanelArena;
import GUI.leftpanel.PanelCompetition;
import GUI.leftpanel.PanelCompetitor;

/**
 * Combines all the panels and the main frame
 */
public class GuiManager {
    private static PanelGame panelGame;
    private static PanelInfo panelInfo;
    private static MainFrame mainFrame;

    /**
     * Default private ctor
     */
    private GuiManager() {
    }

    /**
     * get main frame
     *
     * @return main frame
     */
    public static MainFrame getMainFrame() {
        return mainFrame;
    }

    /**
     * setting the main frame
     *
     * @param frame
     */
    public static void setMainFrame(MainFrame frame) {
        mainFrame = frame;
    }

    /**
     * get game panel
     *
     * @return game panel
     */
    public static PanelGame getPanelGame() {
        return panelGame;
    }

    /**
     * set game panel
     *
     * @param _panelGame
     */
    public static void setPanelGame(PanelGame _panelGame) {
        panelGame = _panelGame;
    }

    /**
     * get info panel
     *
     * @return info panel
     */
    public static PanelInfo getPanelInfo() {
        return panelInfo;
    }

    /**
     * set info panel
     *
     * @param _panelInfo
     */
    public static void setPanelInfo(PanelInfo _panelInfo) {
        panelInfo = _panelInfo;
    }

}
