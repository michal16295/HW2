package GUI;

public class GuiManager {
    private static GuiManager instance;
    private inputPane _inputPane;
    private panelArena _panelArena;
    private GuiManager(){};

    public GuiManager getInstance(){
        if(instance == null){
            instance = new GuiManager();
        }
        return instance;
    }


}
