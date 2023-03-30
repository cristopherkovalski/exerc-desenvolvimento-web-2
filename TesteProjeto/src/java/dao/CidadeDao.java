/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.CidadeBean;
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
public class CidadeDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public CidadeDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public  List<CidadeBean> listar(){ 
		try {
                        List<CidadeBean> listaCidade = new ArrayList<>();
			String queryString = "SELECT * FROM tb_cidade";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
                         while(rs.next()){
                            CidadeBean cidade = new CidadeBean();
                            cidade.setId(rs.getInt("id_cidade"));
                            cidade.setNome(rs.getString("nome_cidade"));
                            int idEstado = rs.getInt("fk_estado");
                            EstadoDao estado = new EstadoDao();
                            EstadoBean estad = new EstadoBean();
                            estad = estado.Buscar(idEstado);
                            cidade.setEstado(estad);
                            listaCidade.add(cidade);
                 }
                         return listaCidade;
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
          public CidadeBean Buscar(int id){ 
		try {
			String queryString = "SELECT * FROM tb_cidade where id_cidade=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
                        CidadeBean cidade = new CidadeBean();
                         while(rs.next()){
                            cidade.setId(rs.getInt("id_cidade"));
                            cidade.setNome(rs.getString("nome_cidade"));
                            EstadoDao estado = new EstadoDao();
                            int idEstado = rs.getInt("fk_estado");
                            EstadoBean estad = new EstadoBean();
                            estad = estado.Buscar(idEstado);
                            cidade.setEstado(estad);
                 }
                         return cidade;
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
          
        public void atualizar(CidadeBean cidade) throws SQLException {
            String sql = "UPDATE tb_cidade SET nome_cidade = ?, id_estado = ? WHERE id_cidade = ?";
             try (PreparedStatement stmt = connection.prepareStatement(sql)) {
              stmt.setString(1, cidade.getNome());
              stmt.setInt(2, cidade.getEstado().getId());
              stmt.setInt(3, cidade.getId());
              stmt.executeUpdate();
             }
            }
          public List<CidadeBean> getCidadesByEstadoId(int estadoId) {
               try {
                        List<CidadeBean> listaCidade = new ArrayList<>();
			String queryString = "SELECT * FROM tb_cidade WHERE fk_estado = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, estadoId);
			ResultSet rs = ptmt.executeQuery();
                         while(rs.next()){
                        CidadeBean cidade = new CidadeBean();
                        cidade.setId(rs.getInt("id_cidade"));
                        cidade.setNome(rs.getString("nome_cidade"));
                        EstadoDao estado = new EstadoDao();
                        int idEstado = rs.getInt("fk_estado");
                        EstadoBean estad = new EstadoBean();
                        estad = estado.Buscar(idEstado);
                        cidade.setEstado(estad);
                        listaCidade.add(cidade);
                 }
                         return listaCidade;
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
    

