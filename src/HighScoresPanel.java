import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.ArrayList;

public class HighScoresPanel extends JPanel {
    private JScrollPane scrollPane;
    private JTable table;

    public HighScoresPanel() {
        create();
    }

    @Override
    public void setVisible(boolean flag) {
        super.setVisible(flag);
        if (flag)
            loadList();
    }

    private void loadList() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setNumRows(0);
        for (HighScores.Row row : HighScores.getList())
            model.addRow(new Object[]{row.name, row.score});
    }

    private void create() {
        setMaximumSize(new Dimension(220, 400));
        setPreferredSize(new Dimension(220, 400));
        setLayout(new BorderLayout());

        scrollPane = new JScrollPane();
        scrollPane.setMinimumSize(new Dimension(220, 20));
        scrollPane.setPreferredSize(new Dimension(220, 20));

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Name", "Score"}
        ) {
            Class[] types = new Class[]{
                    String.class, Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
        });
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);
        ArrayList<RowSorter.SortKey> sortKeys = new ArrayList<>(2);
        sortKeys.add(new RowSorter.SortKey(1, SortOrder.DESCENDING));
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);

        scrollPane.setViewportView(table);
        add(scrollPane, BorderLayout.LINE_END);
    }
}