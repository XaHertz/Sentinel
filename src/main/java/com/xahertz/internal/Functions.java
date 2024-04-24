package com.xahertz.internal;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author XaHertz
 */
public class Functions {
    public static void openVault() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Existing Vault");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Sentinel Vault File", "vault"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String vltPass = JOptionPane.showInputDialog(null, "Vault File: " + fileChooser.getSelectedFile().getAbsolutePath(), "Enter Password", JOptionPane.PLAIN_MESSAGE);
            if (!vltPass.equals("")) {
                com.xahertz.internal.SQLite.openVault(fileChooser.getSelectedFile().getAbsolutePath(), vltPass);
            }
        }
    }

    public static void importVaultData() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Import from CSV");
        fileChooser.setFileFilter(new FileNameExtensionFilter("CSV File", "csv"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, fileChooser.getSelectedFile(), "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static TableModel vltTableModel(String vltTableName) {
        ResultSet vltResult = com.xahertz.internal.SQLite.vltTableData(vltTableName);
        DefaultTableModel vltTableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return false;
            }
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
                java.lang.Object.class, java.lang.Object.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        };
        try {
            ResultSetMetaData vltMeta = vltResult.getMetaData();
            vltTableModel.addColumn(vltMeta.getColumnLabel(1));
            vltTableModel.addColumn(vltMeta.getColumnLabel(2));
            vltTableModel.addColumn(vltMeta.getColumnLabel(3));
            vltTableModel.addColumn(vltMeta.getColumnLabel(5));
            vltTableModel.addColumn(vltMeta.getColumnLabel(6));
            Object[] row = new Object[5];
            while (vltResult.next()) {
                row[0] = vltResult.getObject(1);
                row[1] = vltResult.getObject(2);
                row[2] = vltResult.getObject(3);
                row[3] = vltResult.getObject(5);
                row[4] = vltResult.getObject(6);
                vltTableModel.addRow(row);
            }
            return vltTableModel;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
