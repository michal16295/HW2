package GUI.leftpanel;

import GUI.GuiManager;
import game.GameEngine;
import game.competition.Competitor;
import game.entities.sportsman.ColoredSportsman;
import game.entities.sportsman.IWinterSportsman;
import game.entities.sportsman.SpeedySportsman;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class modifyPanel extends JFrame {
    private JLabel playerName;
    private JLabel ColorLabel;
    private JLabel AccelerationLabel;
    private JComboBox ColorComboBox;
    private JTextField AccelerationText;
    private JButton ColorBtn;
    private JButton AccelerationBtn;


    public modifyPanel(IWinterSportsman competitor) {
        super("Modify Competitor");
        createUI(competitor);
        addUI();
        addButtonListener(competitor);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(300, 300));
        setVisible(true);

        setAlwaysOnTop(true);
        GuiManager.getMainFrame().setEnabled(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                GuiManager.getMainFrame().setEnabled(true);
            }
        });
    }

    private void addButtonListener(IWinterSportsman competitor) {
        ColorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String color = ColorComboBox.getSelectedItem().toString();
                IWinterSportsman winterSportsman = new ColoredSportsman(competitor, color);
                ArrayList<Competitor> competitors = GameEngine.getInstance().getComp().getActiveCompetitors();
                competitors.get(competitors.size() - 1).setColor(winterSportsman.getColor());
                GuiManager.getPanelGame().updateUI();
            }
        });
        AccelerationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double acc = Double.parseDouble(AccelerationText.getText());
                IWinterSportsman winterSportsman = new SpeedySportsman(competitor, acc);
                ArrayList<Competitor> competitors = GameEngine.getInstance().getComp().getActiveCompetitors();
                competitors.get(competitors.size() - 1).setAcceleration(winterSportsman.getAcceleration());
                GuiManager.getPanelGame().updateUI();
            }
        });
    }

    private void createUI(IWinterSportsman competitor) {
        setLayout(new GridLayout(7, 1));
        playerName = new JLabel("Player: " + competitor.getName());
        //Setting the color
        String[] colors = {"red", "blue", "black", "pink", "green"};
        ColorLabel = new JLabel("Add a color");
        ColorComboBox = new JComboBox(colors);
        ColorBtn = new JButton("Add Color");

        //setting the acceleration
        AccelerationLabel = new JLabel("Add acceleration");
        AccelerationText = new JTextField();
        AccelerationBtn = new JButton("Add Acceleration");


    }

    private void addUI() {
        add(playerName);
        add(ColorLabel);
        add(ColorComboBox);
        add(ColorBtn);
        add(AccelerationLabel);
        add(AccelerationText);
        add(AccelerationBtn);

    }

}
