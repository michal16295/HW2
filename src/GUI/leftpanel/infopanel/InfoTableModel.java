package GUI.leftpanel.infopanel;

import javax.swing.table.AbstractTableModel;
import java.util.*;


/**
 * Holds the data of the table - Table manager
 *
 * @author Dima Zagorodny - 320552243
 * @author Michal Barski - 205870934
 */
public class InfoTableModel extends AbstractTableModel {
    private static ArrayList<ArrayList<Object>> data = new ArrayList<>();

    private final String[] columnNames = {"Name", "Speed", "Max Speed", "Location", "Finished"};

    /**
     * Returns the column name of index 'col'
     *
     * @param col the index of column
     * @return the column name
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * @return num of rows
     */
    @Override
    public int getRowCount() {
        return data.size();
    }

    /**
     * @return num of cols
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    /**
     * return the value at data[row][col]
     *
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    /**
     * adding a player to the table with his initial data
     *
     * @param name
     * @param speed
     * @param maxSpeed
     * @param location
     * @param finished
     */
    public void addRow(String name, Double speed, Double maxSpeed, Double location, String finished) {
        ArrayList<Object> player = new ArrayList<>();
        player.add(name);
        player.add(speed);
        player.add(maxSpeed);
        player.add(location);
        player.add(finished);
        data.add(player);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    /**
     * updating the data during the competition
     *
     * @param index      index in the table
     * @param name       player name
     * @param speed      player current speed
     * @param maxSpeed   player max speed
     * @param location   player location
     * @param isFinished player is finished race
     */
    public void updateRow(int index, String name, double speed, double maxSpeed, double location, boolean isFinished) {
        ArrayList<Object> player = data.get(index);
        player.set(0, name);
        player.set(1, speed);
        player.set(2, maxSpeed);
        player.set(3, location);
        player.set(4, isFinished ? "Yes" : "No");

        fireTableCellUpdated(index, 0);
        fireTableCellUpdated(index, 1);
        fireTableCellUpdated(index, 2);
        fireTableCellUpdated(index, 3);
        fireTableCellUpdated(index, 4);
    }

    /**
     * deletes table data - when resetting the competition
     */
    public void deleteData() {
        data = new ArrayList<>();
        fireTableDataChanged();
    }
}
