/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.AtendimentoBean;
import beans.ProdutoBean;
import beans.TipoAtendimentoBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author T-GAMER
 */
public class AtendimentoDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public AtendimentoDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
    
    public AtendimentoBean Buscar(int idAtendimento) throws SQLException {
    try {
         
            String queryString = "SELECT * FROM tb_atendimento WHERE id_atendimento = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idAtendimento);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()){
            AtendimentoBean atendimento = new AtendimentoBean();
            atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
            atendimento.setDataHoraAtendimento(rs.getTimestamp("dt_hr_atendimento"));
            atendimento.setDescricaoAtendimento(rs.getString("dsc_atendimento"));
            ProdutoBean produto= new ProdutoBean();
            ProdutoDAO produt= new ProdutoDAO();
            int idprod = rs.getInt("id_produto");
            produto=produt.Buscar(idprod);
            atendimento.setProduto(produto);
            TipoAtendimentoBean tipoa= new TipoAtendimentoBean();
            TipoAtendimentoDAO tipodao= new TipoAtendimentoDAO();
            int idtipo= rs.getInt("id_tipo_atendimento");
            tipoa=tipodao.Buscar(idtipo);
            atendimento.setTipoAtendimento(tipoa);
            atendimento.setIdUsuario(rs.getInt("id_usuario"));
            atendimento.setIdCliente(rs.getInt("id_cliente"));
            atendimento.setResolvido(rs.getString("res_atendimento").equals("S"));
            return atendimento;
           }} catch (SQLException e) {
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
     public List <AtendimentoBean> listarAtendimentoUsuario(int idUsuario) throws SQLException {
    try {
            List<AtendimentoBean> atendimentos = new ArrayList<>();
            String queryString = "SELECT * FROM tb_atendimento WHERE id_usuario = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idUsuario);
            ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
            AtendimentoBean atendimento = new AtendimentoBean();
               atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
               atendimento.setDataHoraAtendimento(rs.getTimestamp("dt_hr_atendimento"));
               atendimento.setDescricaoAtendimento(rs.getString("dsc_atendimento"));
               ProdutoBean produto= new ProdutoBean();
               ProdutoDAO produt= new ProdutoDAO();
               int idprod = rs.getInt("id_produto");
                            produto=produt.Buscar(idprod);
                          atendimento.setProduto(produto);
                          TipoAtendimentoBean tipoa= new TipoAtendimentoBean();
                          TipoAtendimentoDAO tipodao= new TipoAtendimentoDAO();
                          int idtipo= rs.getInt("id_tipo_atendimento");
                          tipoa=tipodao.Buscar(idtipo);
                          atendimento.setTipoAtendimento(tipoa);
                          atendimento.setIdUsuario(rs.getInt("id_usuario"));
                          atendimento.setIdCliente(rs.getInt("id_cliente"));
                          atendimento.setResolvido(rs.getString("res_atendimento").equals("S"));
                          atendimentos.add(atendimento);
            }
            return atendimentos;
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
    
    public List <AtendimentoBean> Listar() throws SQLException {
        try {
             List<AtendimentoBean> atendimentos = new ArrayList<>();
			String queryString = "SELECT * FROM tb_atendimento";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
               AtendimentoBean atendimento = new AtendimentoBean();
               atendimento.setIdAtendimento(rs.getInt("id_atendimento"));
               atendimento.setDataHoraAtendimento(rs.getTimestamp("dt_hr_atendimento"));
               atendimento.setDescricaoAtendimento(rs.getString("dsc_atendimento"));
               ProdutoBean produto= new ProdutoBean();
               ProdutoDAO produt= new ProdutoDAO();
               int idprod = rs.getInt("id_produto");
                         produto=produt.Buscar(idprod);
                          atendimento.setProduto(produto);
                          TipoAtendimentoBean tipoa= new TipoAtendimentoBean();
                          TipoAtendimentoDAO tipodao= new TipoAtendimentoDAO();
                             int idtipo= rs.getInt("id_tipo_atendimento");
                             tipoa=tipodao.Buscar(idtipo);
                             atendimento.setTipoAtendimento(tipoa);
                              atendimento.setIdUsuario(rs.getInt("id_usuario"));
                          atendimento.setIdCliente(rs.getInt("id_cliente"));
                          atendimento.setResolvido(rs.getString("res_atendimento").equals("S"));
                          atendimentos.add(atendimento);
            }
        return atendimentos;
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
    
    public void inserirAtendimento(AtendimentoBean atendimento) throws SQLException {
       try {
           String queryString = "INSERT INTO tb_atendimento (dt_hr_atendimento, dsc_atendimento, id_produto, id_tipo_atendimento, id_usuario, id_cliente, res_atendimento) VALUES (?, ?, ?, ?, ?, ?, ?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
           ptmt.setTimestamp(1, (Timestamp) atendimento.getDataHoraAtendimento());
           ptmt.setString(2, atendimento.getDescricaoAtendimento());
           ptmt.setInt(3, atendimento.getProduto().getIdProduto());
            ptmt.setInt(4, atendimento.getTipoAtendimento().getIdTipoAtendimento());
            ptmt.setInt(5, atendimento.getIdUsuario());
            ptmt.setInt(6, atendimento.getIdCliente());
            ptmt.setString(7, atendimento.isResolvido() ? "S" : "N");
            ptmt.executeUpdate();         
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
    }
    public void atualizarAtendimento(AtendimentoBean atendimento) throws SQLException {
        try {
            String queryString= "UPDATE tb_atendimento SET dt_hr_atendimento = ?, dsc_atendimento = ?, id_produto = ?, id_tipo_atendimento = ?, id_usuario = ?, id_cliente = ?, res_atendimento = ? WHERE id_atendimento = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setTimestamp(1, (Timestamp) atendimento.getDataHoraAtendimento());
            ptmt.setString(2, atendimento.getDescricaoAtendimento());
            ptmt.setInt(3, atendimento.getProduto().getIdProduto());
            ptmt.setInt(4, atendimento.getTipoAtendimento().getIdTipoAtendimento());
            ptmt.setInt(5, atendimento.getIdUsuario());
            ptmt.setInt(6, atendimento.getIdCliente());
            ptmt.setString(7, atendimento.isResolvido() ? "S" : "N");
            ptmt.setInt(8, atendimento.getIdAtendimento());
            ptmt.executeUpdate();
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
    }
    public void excluirAtendimento(int idAtendimento) throws SQLException {
    String sql = "DELETE FROM tb_atendimento WHERE id_atendimento = ?";
    connection = getConnection();
    try (PreparedStatement ptmt = connection.prepareStatement(sql)) {
        ptmt.setInt(1, idAtendimento);
        ptmt.executeUpdate();
    }
}
    
    
}
