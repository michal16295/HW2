package GUI;

import utilities.Point;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InfoTableModel extends AbstractTableModel {
    private static ArrayList<ArrayList<Object>> data = new ArrayList<>();

    private final String[] columnNames = {"Name", "Speed", "Max Speed", "Location", "Finished"};

    public String getColumnName(int col) {
        return columnNames[col];
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    /*
     * Don't need to implement this method unless your table's
     * data can change.
     */
    public void setValueAt(Object value, int row, int col) {
        data.get(row).set(col, value);
        fireTableCellUpdated(row, col);
    }

    public void addRow(String name, Double speed, Double maxSpeed, Double location, String finished) {
        ArrayList<Object> player = new ArrayList<>();
        player.add(name);
        player.add(speed);
        player.add(maxSpeed);
        player.add(location);
        player.add(finished);
        data.add(player);
        fireTableRowsInserted(data.size()-1, data.size()-1);
    }

    public void updateRow(int index, double speed, double location, boolean isFinished) {
        ArrayList<Object> player = data.get(index);
        player.set(1, speed);
        player.set(3, location);
        player.set(4, isFinished ? "Yes" : "No");
        fireTableCellUpdated(index, 1);
        fireTableCellUpdated(index, 3);
        fireTableCellUpdated(index, 4);
    }

    public void deleteData() {
        data = new ArrayList<>();
        fireTableDataChanged();
    }
}
