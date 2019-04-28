package GUI;

/**
 * Combines all the panels and the main frame
 */

public class GuiManager {
    private static GuiManager instance;
    private inputPane _inputPane;
    private panelArena _panelArena;
    private panelCompetition _panelCompetition;
    private panelCompetitor _panelCompetitor;
    private panelGame _panelGame;
    private panelInfo _panelInfo;
    private mainFrame _mainFrame;

    private GuiManager() {}

    /**
     * get instance
     * @return instance
     */
    public static GuiManager getInstance(){
        if(instance == null){
            instance = new GuiManager();
        }
        return instance;
    }

    /**
     * get input panel
     * @return input panel
     */
    public inputPane get_inputPane() {
        return _inputPane;
    }

    /**
     * get main frame
     * @return main frame
     */
    public mainFrame get_mainFrame(){
        return _mainFrame;
    }

    /**
     * setting the main frame
     * @param frame
     */
    public void set_mainFrame(mainFrame frame){
        this._mainFrame = frame;
    }

    /**
     * setting the input panel
     * @param _inputPane
     */

    public void set_inputPane(inputPane _inputPane) {
        this._inputPane = _inputPane;
    }

    /**
     * get arena panel
     * @return arena panel
     */

    public panelArena get_panelArena() {
        return _panelArena;
    }

    /**
     * setting arena panel
     * @param _panelArena
     */

    public void set_panelArena(panelArena _panelArena) {
        this._panelArena = _panelArena;
    }

    /**
     * get competition panel
     * @return competition panel
     */
    public panelCompetition get_panelCompetition() {
        return _panelCompetition;
    }

    /**
     * set competition panel
     * @param _panelCompetition
     */
    public void set_panelCompetition(panelCompetition _panelCompetition) {
        this._panelCompetition = _panelCompetition;
    }

    /**
     * get competitor panel
     * @return competitor panel
     */
    public panelCompetitor get_panelCompetitor() {
        return _panelCompetitor;
    }

    /**
     * set competitor panel;
     * @param _panelCompetitor
     */
    public void set_panelCompetitor(panelCompetitor _panelCompetitor) {
        this._panelCompetitor = _panelCompetitor;
    }

    /**
     * get game panel
     * @return game panel
     */
    public panelGame get_panelGame() {
        return _panelGame;
    }

    /**
     * set game panel
     * @param _panelGame
     */
    public void set_panelGame(panelGame _panelGame) {
        this._panelGame = _panelGame;
    }

    /**
     * get info panel
     * @return info panel
     */
    public panelInfo get_panelInfo() {
        return _panelInfo;
    }

    /**
     * set info panel
     * @param _panelInfo
     */
    public void set_panelInfo(panelInfo _panelInfo) {
        this._panelInfo = _panelInfo;
    }

}
