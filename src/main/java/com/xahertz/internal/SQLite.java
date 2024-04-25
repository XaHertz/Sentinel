package com.xahertz.internal;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author XaHertz
 */
public class SQLite {
    static Connection vltDB = null;
    static Connection listDB = null;
    static File dataFolder = new File("data");
    static Path currentDirectory = Paths.get(System.getProperty("user.dir"));
    
    public static void initVaultList() {
        if (!Files.isWritable(currentDirectory))
            dataFolder = new File(System.getenv("appdata") + File.separator + "Sentinel");
        dataFolder.mkdir();
        try {
            listDB = DriverManager.getConnection("jdbc:sqlite:" + dataFolder + File.separator + "vaults.lst");
            String vltsTable = "CREATE TABLE IF NOT EXISTS Vaults (Path TEXT NOT NULL UNIQUE, PRIMARY KEY(Path));";
            Statement listDBquery = listDB.createStatement();
            listDBquery.execute(vltsTable);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static DefaultListModel<String> getVaultList() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        String vltsTable = "SELECT Path FROM Vaults;";
        try {
            Statement listDBquery = listDB.createStatement();
            ResultSet listResult = listDBquery.executeQuery(vltsTable);
            while (listResult.next()) {
                listModel.addElement(listResult.getString("Path"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listModel;
    }
    
    public static void setVaultList(String vltPath) {
        String vltsTable = "REPLACE INTO Vaults (Path) VALUES(?);";
        try {
            PreparedStatement listDBquery = listDB.prepareStatement(vltsTable);
            listDBquery.setString(1, vltPath);
            listDBquery.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void closeVaultList() {
        if (listDB != null) {
            try {
                if (listDB.isValid(5)) {
                    listDB.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void createNewVault(String vltName, String vltPass, String vltPath) {
        String rootTable = "CREATE TABLE IF NOT EXISTS Root (\"UID\" TEXT NOT NULL UNIQUE, \"Title\" TEXT, \"Username\" TEXT, \"Password\" TEXT, \"URL\" TEXT, \"Notes\" TEXT, PRIMARY KEY(\"UID\"));";
        String allTables = "CREATE TABLE IF NOT EXISTS AllTables (\"Table ID\" TEXT NOT NULL UNIQUE, \"Table Name\" TEXT, PRIMARY KEY(\"Table ID\"));";
        try {
            File vltFile = new File(vltPath);
            if (vltFile.exists())
                vltFile.delete();
            vltDB = DriverManager.getConnection("jdbc:sqlite:" + vltFile, org.sqlite.mc.SQLiteMCChacha20Config.getDefault().withKey(vltPass).build().toProperties());
            Statement vltDBquery = vltDB.createStatement();
            vltDBquery.execute(rootTable);
            vltDBquery.execute(allTables);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void openVault(String vltPath, String vltPass) {
        try {
            vltDB = DriverManager.getConnection("jdbc:sqlite:" + new File(vltPath), org.sqlite.mc.SQLiteMCChacha20Config.getDefault().withKey(vltPass).build().toProperties());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static void closeVault() {
        if (vltDB != null) {
            try {
                if (vltDB.isValid(5)) {
                    vltDB.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static DefaultTreeModel allTablesList() {
        DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("Root");
        DefaultMutableTreeNode treeNode2;
        String allTables = "SELECT \"Table Name\" FROM AllTables;";
        try {
            Statement vltDBquery = vltDB.createStatement();
            ResultSet vltResult = vltDBquery.executeQuery(allTables);
            while (vltResult.next()) {
                treeNode2 = new DefaultMutableTreeNode(vltResult.getString("Table Name"));
                treeNode1.add(treeNode2);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return new DefaultTreeModel(treeNode1);
    }
    
    public static ResultSet vltTableData(String vltTableName) {
        ResultSet vltResult = null;
        String vltTable = "SELECT * FROM \"" + vltTableName + "\";";
        try {
            Statement vltDBquery = vltDB.createStatement();
            vltResult = vltDBquery.executeQuery(vltTable);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return vltResult;
    }
    
    public static void newTableEntry(String vltTableName, String UID, String Title, String Username, String Password, String URL, String Notes) {
        String vltTable = "REPLACE INTO \"" + vltTableName + "\" (\"UID\", \"Title\", \"Username\", \"Password\", \"URL\", \"Notes\") VALUES(?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement vltDBquery = vltDB.prepareStatement(vltTable);
            vltDBquery.setString(1, UID);
            vltDBquery.setString(2, Title);
            vltDBquery.setString(3, Username);
            vltDBquery.setString(4, Password);
            vltDBquery.setString(5, URL);
            vltDBquery.setString(6, Notes);
            vltDBquery.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
