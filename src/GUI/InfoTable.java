package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InfoTable extends JFrame {
    private JTable table;
    private static InfoTableModel model = new InfoTableModel();
    private static InfoTable instance;
    private static boolean opened;

    private InfoTable(){
        super("Competitors information");
        pack();
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(new Dimension(500, 200));
        setVisible(true);

        // Initializing the JTable
        table = new JTable(model);
        table.setBounds(30, 40, 200, 300);

        // adding it to JScrollPane
        JScrollPane sp = new JScrollPane(table);
        add(sp);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                instance = null;
                opened = false;
            }
        });

        opened = true;
    }

    public static InfoTable getInstance() {
        if (instance == null) {
            instance = new InfoTable();
        }
        return instance;
    }

    public static boolean isOpened() {
        return opened;
    }

    public static InfoTableModel getModel() {
        return model;
    }
}
