/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.ClienteBean;
import beans.EstadoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T-GAMER
 */
public class EstadoDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public EstadoDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public  List<EstadoBean> listar(){ 
		try {
                        List<EstadoBean> listaEstado = new ArrayList<>();
			String queryString = "SELECT * FROM tb_estado";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
                         while(rs.next()){
                            EstadoBean estado = new EstadoBean();
                            estado.setId(rs.getInt("id_estado"));
                            estado.setNome(rs.getString("nome_estado"));
                            estado.setSigla(rs.getString("sigla_estado"));
                            listaEstado.add(estado);
                 }
                         return listaEstado;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

                }
        return null;

        }
         public EstadoBean Buscar(int id){ 
		try {
			String queryString = "SELECT * FROM tb_estado where id_estado=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
                        EstadoBean estado = new EstadoBean();
                         while(rs.next()){
                            estado.setId(rs.getInt("id_estado"));
                            estado.setNome(rs.getString("nome_estado"));           
                 }
                         return estado;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ptmt != null)
					ptmt.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

                }
        return null;

        }
    
}
    

