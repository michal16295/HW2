package GUI;

import GUI.leftpanel.infopanel.PanelInfo;

/**
 * Combines all the panels and the main frame
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
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
     * @param frame the main frame
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
     * @param _panelGame the panel game
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
     * @param _panelInfo the panel info
     */
    public static void setPanelInfo(PanelInfo _panelInfo) {
        panelInfo = _panelInfo;
    }

}
