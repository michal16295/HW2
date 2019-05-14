package GUI.leftpanel;

import GUI.GuiManager;
import GUI.MainFrame;
import GUI.PanelGame;
import GUI.leftpanel.infopanel.InfoTable;
import game.GameEngine;
import game.enums.SnowSurface;
import game.enums.WeatherCondition;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Arena panel - Builds the arena
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class PanelArena extends JPanel {
    private JLabel BuildArenaLabel;
    private JLabel SnowSurfaceLabel;
    private JLabel WeatherConditionLabel;
    private JLabel ArenaLengthLabel;
    private JComboBox arenaTypeComboBox;
    private JLabel arenaTypeLabel;

    private JTextField ArenaLengthText;
    private JComboBox SnowSurfaceCombobox;
    private JComboBox WeatherConditionCombobox;

    private JButton buildArenaBtn;
    private Border blackline;

    /**
     * Default ctor
     */
    public PanelArena() {
        createUI();

        addButtonListener();

        addUiToPanel();
    }

    /**
     * Adds action listener to button when clicked
     */
    private void addButtonListener() {
        //After pressing the button
        buildArenaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelGame game = GuiManager.getPanelGame();
                MainFrame frame = GuiManager.getMainFrame();
                if (ArenaLengthText.getText().isEmpty()) {
                    ArenaLengthText.setText("700");
                }
                try {
                    double len = Double.parseDouble(ArenaLengthText.getText());

                    if (len < 700 || len > 900) {
                        JOptionPane.showMessageDialog(null, "Invalid input values! Please try again.", "Message", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    buildArena(game, frame, len);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Arena length should be a number", "Message", JOptionPane.ERROR_MESSAGE);
                    ex.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    /**
     * creating the labels, comboboxes and text fields
     */
    private void createUI() {
        String[] arenaType = {"Summer", "Winter"};
        //Setting the layout
        setLayout(new GridLayout(10, 1));

        //Setting the border
        blackline = BorderFactory.createLineBorder(Color.black);

        //Setting arena type
        arenaTypeLabel = new JLabel("Arena Type");
        arenaTypeComboBox = new JComboBox(arenaType);

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
        buildArenaBtn = new JButton("Build Arena");
    }

    /**
     * Adding the data to the panel
     */
    private void addUiToPanel() {
        add(BuildArenaLabel);
        add(ArenaLengthLabel);
        add(ArenaLengthText);
        add(SnowSurfaceLabel);
        add(SnowSurfaceCombobox);
        add(WeatherConditionLabel);
        add(WeatherConditionCombobox);
        add(arenaTypeLabel);
        add(arenaTypeComboBox);
        add(buildArenaBtn);
        setBorder(blackline);
    }

    /**
     * Building the arena
     *
     * @param game  the game panel
     * @param frame the main frame
     * @param len   arena length
     */
    private void buildArena(PanelGame game, MainFrame frame, double len) {
        GameEngine.getInstance().buildArena(arenaTypeComboBox.getSelectedItem().toString(),len, (SnowSurface) SnowSurfaceCombobox.getSelectedItem(), (WeatherCondition) WeatherConditionCombobox.getSelectedItem());
        game.setBackgroundImage((WeatherCondition) WeatherConditionCombobox.getSelectedItem(), 1000, (int) len);
        frame.setSize(1000, (int) len);

        game.setRatio(len);
        // Clear all players from all UI
        game.clearCompetitorsArray();
        InfoTable.getModel().deleteData();
    }
}
