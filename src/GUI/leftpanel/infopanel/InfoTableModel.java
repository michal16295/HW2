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
    private static HashMap<Integer, Integer> indexer = new HashMap<>();

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

        indexer.put(data.size() - 1, data.size() - 1);
    }

    /**
     * updating the data during the competition
     *
     * @param index
     * @param speed
     * @param location
     * @param isFinished
     */
    public void updateRow(int index, double speed, double location, boolean isFinished) {
        int idx = indexer.get(index);

        ArrayList<Object> player = data.get(idx);
        player.set(1, speed);
        player.set(3, location);
        player.set(4, isFinished ? "Yes" : "No");
        fireTableCellUpdated(idx, 1);
        fireTableCellUpdated(idx, 3);
        fireTableCellUpdated(idx, 4);
    }

    /**
     * Sorts the info table by location in real time
     * from top to bottom
     * the winner placed first in the table
     */
    public void sortTable() {
        for(int i = 0 ; i < data.size() - 1; i++) {
            for (int j = 0; j < data.size() - i - 1 ; j++) {
                ArrayList<Object> player1 = data.get(j);
                ArrayList<Object> player2 = data.get(j + 1);
                if (player1.get(4).equals("Yes"))
                    continue;
                if ((Double)player1.get(3) < (Double)player2.get(3)) {
                    Collections.swap(data, j, j+1);
                    swapIndexes(j, j+1);
                }
            }
        }
        fireTableDataChanged();
    }

    /**
     * swaps between 2 indexes to keep the table info correct according to players position
     * @param idx1 first index
     * @param idx2 second index
     */
    private void swapIndexes(int idx1, int idx2) {
        int p1 = indexer.get(idx1);
        int p2 = indexer.get(idx2);
        indexer.put(idx1, p2);
        indexer.put(idx2, p1);
    }

    /**
     * deletes table data - when resetting the competition
     */
    public void deleteData() {
        data = new ArrayList<>();
        fireTableDataChanged();
    }
}
