package com.xahertz.internal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author XaHertz
 */
public class Functions {
    static File dataFolder = new File("data");
    static Path currentDirectory = Paths.get(System.getProperty("user.dir"));
    
    public static void initData() {
        if (!Files.isWritable(currentDirectory))
            dataFolder = new File(System.getenv("appdata") + File.separator + "Sentinel");
        dataFolder.mkdir();
    }
    
    public static void openVault() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Existing Vault");
        fileChooser.setFileFilter(new FileNameExtensionFilter("Sentinel Vault File", "vault"));
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(null, fileChooser.getSelectedFile(), "Success", JOptionPane.INFORMATION_MESSAGE);
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
    
    public static DefaultListModel<String> VaultList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            File listFile = new File(dataFolder + File.separator + "vaults.lst");
            listFile.createNewFile();
            java.util.Scanner vaultScanner = new java.util.Scanner(listFile);
            while (vaultScanner.hasNextLine()) {
                String line = vaultScanner.nextLine();
                listModel.addElement(line);
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listModel;
    }
}
