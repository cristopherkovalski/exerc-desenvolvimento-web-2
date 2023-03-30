/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.ProdutoBean;
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
public class ProdutoDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public ProdutoDAO() {

    }

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}
    
       public ProdutoBean Buscar(int idProduto) throws SQLException {
        try {
            String queryString = "SELECT * FROM tb_produto WHERE id_produto = ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idProduto);
            ResultSet rs = ptmt.executeQuery();
            if (rs.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                return produto;
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
        
    

    public List<ProdutoBean> Listar() throws SQLException {
        try {
             List<ProdutoBean> produtos = new ArrayList<>();
			String queryString = "SELECT * FROM tb_produto";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
            while (rs.next()) {
                ProdutoBean produto = new ProdutoBean();
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produtos.add(produto);
            }
              return produtos;
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

    public void adicionarProduto(ProdutoBean produto) throws SQLException {
   
        
        try {
           String queryString = "INSERT INTO tb_produto (nome_produto) VALUES (?)";
           connection = getConnection();
           ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, produto.getNomeProduto());
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

    public void atualizarProduto(ProdutoBean produto) throws SQLException {
        try  {
            String queryString = "UPDATE tb_produto SET nome_produto = ? WHERE id_produto = ?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
            ptmt.setString(1, produto.getNomeProduto());
            ptmt.setInt(2, produto.getIdProduto());
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

    public void deletarProduto(int idProduto) throws SQLException {
        try {
            String queryString = "DELETE FROM tb_produto WHERE id_produto= ?";
            connection = getConnection();
            ptmt = connection.prepareStatement(queryString);
            ptmt.setInt(1, idProduto);
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
