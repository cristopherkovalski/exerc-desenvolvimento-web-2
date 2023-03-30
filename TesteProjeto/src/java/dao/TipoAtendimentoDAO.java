/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.TipoAtendimentoBean;
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
public class TipoAtendimentoDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public TipoAtendimentoDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
    
    
    public TipoAtendimentoBean Buscar(int idTipoAtendimento) throws SQLException {
        try {
            String queryString = "SELECT * FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idTipoAtendimento);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
            TipoAtendimentoBean tipoAtendimento = new TipoAtendimentoBean();
            tipoAtendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
            tipoAtendimento.setNomeTipoAtendimento(rs.getString("nome_tipo_atendimento"));
            return tipoAtendimento;
        }}catch (SQLException e) {
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


    public List<TipoAtendimentoBean> Listar() throws SQLException {
        try {
            List<TipoAtendimentoBean> tiposAtendimento = new ArrayList<>();
		String queryString = "SELECT * FROM tb_tipo_atendimento";
		connection = getConnection();
		ptmt = connection.prepareStatement(queryString);
		ResultSet rs = ptmt.executeQuery();
             while (rs.next()) {
               TipoAtendimentoBean tipoAtendimento = new TipoAtendimentoBean();
               tipoAtendimento.setIdTipoAtendimento(rs.getInt("id_tipo_atendimento"));
               tipoAtendimento.setNomeTipoAtendimento(rs.getString("nome_tipo_atendimento"));
               tiposAtendimento.add(tipoAtendimento);
        }
             return tiposAtendimento;
    }catch (SQLException e) {
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
     
    

    public void adicionarTipoAtendimento(TipoAtendimentoBean tipoAtendimento) throws SQLException {
        try {
            String queryString = "INSERT INTO tb_tipo_atendimento (nome_tipo_atendimento) VALUES (?)";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, tipoAtendimento.getNomeTipoAtendimento());
            ptmt.executeUpdate();
        }catch (SQLException e) {
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
    }
    public void atualizarTipoAtendimento(TipoAtendimentoBean tipoAtendimento) throws SQLException {
         try {
            String queryString = "UPDATE tb_tipo_atendimento SET nome_tipo_atendimento = ? WHERE id_tipo_atendimento = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, tipoAtendimento.getNomeTipoAtendimento());
            ptmt.setInt(2, tipoAtendimento.getIdTipoAtendimento());
            ptmt.executeUpdate();
        }catch (SQLException e) {
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
    }
    

    public void deletarTipoAtendimento(int idTipoAtendimento) throws SQLException {
        try {
            String queryString = "DELETE FROM tb_tipo_atendimento WHERE id_tipo_atendimento = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idTipoAtendimento);
            ptmt.executeUpdate();
        }catch (SQLException e) {
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
    }
    
}
