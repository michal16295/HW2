package GUI;

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

    public static GuiManager getInstance(){
        if(instance == null){
            instance = new GuiManager();
        }
        return instance;
    }

    public inputPane get_inputPane() {
        return _inputPane;
    }

    public mainFrame get_mainFrame(){
        return _mainFrame;
    }
    public void set_mainFrame(mainFrame frame){
        this._mainFrame = frame;
    }

    public void set_inputPane(inputPane _inputPane) {
        this._inputPane = _inputPane;
    }

    public panelArena get_panelArena() {
        return _panelArena;
    }

    public void set_panelArena(panelArena _panelArena) {
        this._panelArena = _panelArena;
    }

    public panelCompetition get_panelCompetition() {
        return _panelCompetition;
    }

    public void set_panelCompetition(panelCompetition _panelCompetition) {
        this._panelCompetition = _panelCompetition;
    }

    public panelCompetitor get_panelCompetitor() {
        return _panelCompetitor;
    }

    public void set_panelCompetitor(panelCompetitor _panelCompetitor) {
        this._panelCompetitor = _panelCompetitor;
    }

    public panelGame get_panelGame() {
        return _panelGame;
    }

    public void set_panelGame(panelGame _panelGame) {
        this._panelGame = _panelGame;
    }

    public panelInfo get_panelInfo() {
        return _panelInfo;
    }

    public void set_panelInfo(panelInfo _panelInfo) {
        this._panelInfo = _panelInfo;
    }

}
