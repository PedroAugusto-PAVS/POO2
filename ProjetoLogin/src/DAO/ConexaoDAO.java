package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 20221050100070
 */
public class ConexaoDAO {
    public Connection conectaBD() {
        Connection conn = null;

        try {
            String url = "jdbc:mysql://localhost:3306/projeto_login_poo2?user=root&password=";
            conn = DriverManager.getConnection(url);
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ConexaoDAO" + erro.getMessage());
        }
        return conn;
    }
    
}
