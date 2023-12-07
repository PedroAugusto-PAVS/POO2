/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ProjetoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author pedro
 */
public class ProjetoDAO {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;
    ArrayList<ProjetoDTO> lista = new ArrayList<>();

    public void cadastrarProjeto(ProjetoDTO objProjetoDTO) {
        String sql = "insert into projeto (evento, coordenador, campus, titulo, estudante, matricula, cpf, numBanco, contaCorrente, agencia, celular, email) values (?,?,?,?,?,?,?,?,?,?,?,?)";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProjetoDTO.getEvento());
            pstm.setString(2, objProjetoDTO.getCoordenador());
            pstm.setString(3, objProjetoDTO.getCampus());
            pstm.setString(4, objProjetoDTO.getTitulo());
            pstm.setString(5, objProjetoDTO.getEstudante());
            pstm.setString(6, objProjetoDTO.getMatricula());
            pstm.setString(7, objProjetoDTO.getCPF());
            pstm.setString(8, objProjetoDTO.getnDoBanco());
            pstm.setString(9, objProjetoDTO.getContaCorrente());
            pstm.setString(10, objProjetoDTO.getAgencia());
            pstm.setString(11, objProjetoDTO.getCelular());
            pstm.setString(12, objProjetoDTO.getEmail());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO" + erro);
        }
    }

    public ArrayList<ProjetoDTO> listarProjetos() {
        String sql = "select * from projeto";
        conn = new ConexaoDAO().conectaBD();
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
//              evento, coordenador, campus, titulo, estudante, matricula, cpf, numBanco, contaCorrente, agencia, celular, email
                ProjetoDTO objProjetoDTO = new ProjetoDTO();
                objProjetoDTO.setId_projeto(rs.getInt("id_projeto"));
                objProjetoDTO.setEvento(rs.getString("evento"));
                objProjetoDTO.setCoordenador(rs.getString("coordenador"));
                objProjetoDTO.setCampus(rs.getString("campus"));
                objProjetoDTO.setTitulo(rs.getString("titulo"));
                objProjetoDTO.setEstudante(rs.getString("estudante"));
                objProjetoDTO.setMatricula(rs.getString("matricula"));
                objProjetoDTO.setCPF(rs.getString("cpf"));
                objProjetoDTO.setnDoBanco(rs.getString("numBanco"));
                objProjetoDTO.setContaCorrente(rs.getString("contaCorrente"));
                objProjetoDTO.setAgencia(rs.getString("agencia"));
                objProjetoDTO.setCelular(rs.getString("celular"));
                objProjetoDTO.setEmail(rs.getString("email"));

                lista.add(objProjetoDTO);
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO listarProjetos: " + erro);
        }
        return lista;
    }

    public void alterarProjeto(ProjetoDTO objProjetoDTO) {
        String sql = "update projeto set evento = ?, coordenador = ?, campus = ?, titulo = ?, estudante = ?, matricula = ?, cpf = ?, numBanco = ?, contaCorrente = ?, agencia = ?, celular = ?, email = ? where id_projeto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objProjetoDTO.getEvento());
            pstm.setString(2, objProjetoDTO.getCoordenador());
            pstm.setString(3, objProjetoDTO.getCampus());
            pstm.setString(4, objProjetoDTO.getTitulo());
            pstm.setString(5, objProjetoDTO.getEstudante());
            pstm.setString(6, objProjetoDTO.getMatricula());
            pstm.setString(7, objProjetoDTO.getCPF());
            pstm.setString(8, objProjetoDTO.getnDoBanco());
            pstm.setString(9, objProjetoDTO.getContaCorrente());
            pstm.setString(10, objProjetoDTO.getAgencia());
            pstm.setString(11, objProjetoDTO.getCelular());
            pstm.setString(12, objProjetoDTO.getEmail());
            pstm.setInt(13, objProjetoDTO.getId_projeto());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO alterarProjeto" + erro);
        }
    }

    public void excluirProjeto(ProjetoDTO objProjetoDTO) {
        String sql = "delete from projeto where id_projeto = ?";

        conn = new ConexaoDAO().conectaBD();

        try {
            pstm = conn.prepareStatement(sql);
           
            pstm.setInt(1, objProjetoDTO.getId_projeto());

            pstm.execute();
            pstm.close();

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ProjetoDAO excluirProjeto" + erro);
        }
    }

}
