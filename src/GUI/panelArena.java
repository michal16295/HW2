package GUI;

import game.GameEngine;
import game.arena.WinterArena;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;
import sun.java2d.Surface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private GameEngine game;
    private Border blackline;


    public panelArena() {
        //Setting the layout
        setLayout(new GridLayout(8,1));

        //Setting the border
        blackline = BorderFactory.createLineBorder(Color.black);

        //Build arena label
        BuildArenaLabel = new JLabel("BUILD ARENA");
        BuildArenaLabel.setForeground(Color.blue);

        //Arena length label
        ArenaLengthLabel = new JLabel("Arena Length");

        //Snow surface label
        SnowSurfaceLabel = new JLabel("Snow Surface");

        //Weather condition label
        WeatherConditionLabel = new JLabel("Weather Condition");

        //Arena Length text field
        ArenaLengthText = new JTextField("700");


        //Snow surface combobox
        SnowSurfaceCombobox = new JComboBox();
        SnowSurfaceCombobox.setModel(new DefaultComboBoxModel(SnowSurface.values()));
        SnowSurfaceCombobox.setPreferredSize(new Dimension(140, 20));
        SnowSurfaceCombobox.setMaximumSize(new Dimension(140,20));

        //Weather condition combobox
        WeatherConditionCombobox = new JComboBox();
        WeatherConditionCombobox.setModel(new DefaultComboBoxModel(WeatherCondition.values()));

        //Build arena button
        BuildArenaBtn = new JButton("Build Arena");
        BuildArenaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ArenaLengthText.getText().isEmpty()){
                    ArenaLengthText.setText("700");
                }
                try{
                    double len = Double.parseDouble(ArenaLengthText.getText());
                    ARENA = new WinterArena(len, (SnowSurface)SnowSurfaceCombobox.getSelectedItem(), (WeatherCondition)WeatherConditionCombobox.getSelectedItem());
                    game.setArena(ARENA);
                    panelGame img = new panelGame();
                    img.setImage((WeatherCondition)WeatherConditionCombobox.getSelectedItem());


                }catch (Exception ex){
                    ex.printStackTrace();

                }
            }
        });

        //adding to the panel
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


}
