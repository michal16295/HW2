package GUI.leftpanel.infopanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Information table
 * hold the information on each competitor before, during and after the competition
 */
public class InfoTable extends JFrame {
    private static InfoTableModel model = new InfoTableModel();
    private static InfoTable instance;

    /**
     * Info table ctor
     */
    private InfoTable() {
        super("Competitors information");

        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(500, 200));
        setVisible(true);

        // Initializing the JTable
        JTable table = new JTable(model);
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        add(sp);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                instance = null;
            }
        });
    }

    /**
     * creates instance if not exists
     */
    public static void createInstance() {
        if (instance == null) {
            instance = new InfoTable();
        }
    }

    public static InfoTableModel getModel() {
        return model;
    }
}
