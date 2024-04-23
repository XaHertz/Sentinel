package com.xahertz.internal;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

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
}
