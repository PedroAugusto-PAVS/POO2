/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 20221050100070
 */
public class UsuarioDAO {

    Connection conn;
    PreparedStatement pstm;
    
    public ResultSet autenticacaoUsuario (UsuarioDTO objusuariodto){
        conn = new ConexaoDAO().conectaBD();
        try {
            String sql = "select * from usuario where nome_usuario = ? and senha_usuario = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
        
        
        
    public void cadastarNovoUser(UsuarioDTO objusuariodto){
        String sql = "insert into usuario (nome_usuario, senha_usuario) values (?,?)";
        
        conn = new ConexaoDAO().conectaBD();
        
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());
            
            pstm.execute();
            pstm.close();
        } catch  (Exception erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO" + erro);
        }
        
    }
}
