package GUI;

import game.GameEngine;
import game.arena.WinterArena;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Arena panel - Builds the arena
 */
public class panelArena extends JPanel {
    private JLabel BuildArenaLabel;
    private JLabel SnowSurfaceLabel;
    private JLabel WeatherConditionLabel;
    private JLabel ArenaLengthLabel;

    private JTextField ArenaLengthText;
    private JComboBox SnowSurfaceCombobox;
    private JComboBox WeatherConditionCombobox;

    private JButton BuildArenaBtn;
    private WinterArena ARENA;
    private Border blackline;


    public panelArena() {
        createData();
        //After pressing the button
        BuildArenaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGame game = GuiManager.getInstance().get_panelGame();
                mainFrame frame = GuiManager.getInstance().get_mainFrame();
                if(ArenaLengthText.getText().isEmpty()){
                    ArenaLengthText.setText("700");
                }
                GameEngine.getInstance().setComp(null);
                game.setIcon(null);
                try{
                    double len;
                    try{
                        len = Double.parseDouble(ArenaLengthText.getText());
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, "Arena length should be a number", "Message", JOptionPane.ERROR_MESSAGE);
                        ex.printStackTrace();
                        return;
                    }
                    if(len < 700 || len > 900){
                        JOptionPane.showMessageDialog(null, "Invalid input values! Please try again.", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    buildArena(game, frame, len);

                }catch (Exception ex){
                    ex.printStackTrace();

                }
            }
        });

        //adding to the panel
        addData();

    }

    /**
     * creating the labels, comboboxes and text fields
     */
    public void createData(){
        //Setting the layout
        setLayout(new GridLayout(8,1));

        //Setting the border
        blackline = BorderFactory.createLineBorder(Color.black);

        //Build arena label
        BuildArenaLabel = new JLabel("BUILD ARENA");
        BuildArenaLabel.setForeground(Color.blue);

        //Arena length
        ArenaLengthLabel = new JLabel("Arena Length");
        ArenaLengthText = new JTextField("700");

        //Snow surface
        SnowSurfaceLabel = new JLabel("Snow Surface");
        SnowSurfaceCombobox = new JComboBox(SnowSurface.values());

        //Weather condition label
        WeatherConditionLabel = new JLabel("Weather Condition");
        WeatherConditionCombobox = new JComboBox(WeatherCondition.values());

        //Build arena button
        BuildArenaBtn = new JButton("Build Arena");
    }

    /**
     * adding the data to the panel
     */
    public void addData(){
        add(BuildArenaLabel);
        add(ArenaLengthLabel);
        add(ArenaLengthText);
        add(SnowSurfaceLabel);
        add(SnowSurfaceCombobox);
        add(WeatherConditionLabel);
        add(WeatherConditionCombobox);
        add(BuildArenaBtn);
        setBorder(blackline);
    }

    /**
     * Building the arena
     * @param game
     * @param frame
     * @param len
     */
    public void buildArena(panelGame game, mainFrame frame, double len){
        ARENA = new WinterArena(len, (SnowSurface)SnowSurfaceCombobox.getSelectedItem(), (WeatherCondition)WeatherConditionCombobox.getSelectedItem());
        GameEngine.getInstance().setArena(ARENA);
        game.setImage((WeatherCondition)WeatherConditionCombobox.getSelectedItem());
        game.setImage(game.resizeImage(1000, (int)len,game.getImage()));
        frame.setSize(1000,(int)len);
        game.clearArray();
        game.setRatio();
        InfoTable.getModel().deleteData();
    }


}
