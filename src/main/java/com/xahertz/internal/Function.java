package com.xahertz.internal;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author XaHertz
 */
public class Function {
    static File dataFolder = new File("data");
    static Path currentDirectory = Paths.get(System.getProperty("user.dir"));
    
    public static void initData() {
        if (!Files.isWritable(currentDirectory))
            dataFolder = new File(System.getenv("appdata") + File.separator + "Sentinel");
        dataFolder.mkdir();
    }
    
    public static DefaultListModel<String> VaultList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        try {
            File listFile = new File(dataFolder + File.separator + "Vaults.lst");
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
