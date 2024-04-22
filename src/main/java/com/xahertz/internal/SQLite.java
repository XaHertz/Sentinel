package com.xahertz.internal;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author XaHertz
 */
public class SQLite {
    static Connection vltDB = null;

    public static void createNewVault(String vltName, String vltPass, String vltPath) {
        String rootTable = "CREATE TABLE IF NOT EXISTS Root (\"UID\" TEXT NOT NULL UNIQUE, \"Title\" TEXT, \"Username\" TEXT, \"Password\" TEXT, \"URL\" TEXT, \"Notes\" TEXT, PRIMARY KEY(\"UID\"));";
        String allTables = "CREATE TABLE IF NOT EXISTS AllTables (\"Table ID\" TEXT NOT NULL UNIQUE, \"Table Name\" TEXT, PRIMARY KEY(\"Table ID\"));";
        try (FileWriter listFileWriter = new FileWriter(com.xahertz.internal.Functions.listFile, true); BufferedWriter bufferedListFileWriter = new BufferedWriter(listFileWriter)) {
            vltDB = DriverManager.getConnection("jdbc:sqlite:" + new File(vltPath), org.sqlite.mc.SQLiteMCChacha20Config.getDefault().withKey(vltPass).build().toProperties());
            Statement vltDBquery = vltDB.createStatement();
            vltDBquery.execute(rootTable);
            vltDBquery.execute(allTables);
            bufferedListFileWriter.write(vltPath);
            bufferedListFileWriter.newLine();
        } catch (SQLException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
