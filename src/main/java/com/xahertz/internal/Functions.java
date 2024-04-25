package com.xahertz.internal;

import java.security.SecureRandom;
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
    static String Seed = "0123456789";
    static SecureRandom random = new SecureRandom();
    
    public static String randomID(int length) {
        StringBuilder builder = new StringBuilder(length);
        for (int i=0; i<length; i++)
            builder.append(Seed.charAt(random.nextInt(Seed.length())));
        return builder.toString();
    }
    
    public static boolean openVault() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Existing Vault");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Sentinel Vault File", "vault"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            String vltPass = JOptionPane.showInputDialog(null, "Vault File: " + fileChooser.getSelectedFile().getAbsolutePath(), "Enter Password", JOptionPane.PLAIN_MESSAGE);
            if (vltPass != null) {
                if (!vltPass.equals("")) {
                    SQLite.openVault(fileChooser.getSelectedFile().getAbsolutePath(), vltPass);
                    return true;
                }
            }
        }
        return false;
    }
    
    public static TableModel vltTableModel(String vltTableName) {
        ResultSet vltResult = SQLite.vltTableData(vltTableName);
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
