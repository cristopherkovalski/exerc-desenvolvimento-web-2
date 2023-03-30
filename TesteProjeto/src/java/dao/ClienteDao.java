/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.CidadeBean;
import beans.ClienteBean;
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
public class ClienteDao {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public ClienteDao() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public  List<ClienteBean> listar(){ 
		try {
                        List<ClienteBean> listaCliente = new ArrayList<>();
			String queryString = "SELECT * FROM tb_cliente";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
                         while(rs.next()){
                            ClienteBean cliente = new ClienteBean();
                            cliente.setId(rs.getInt("id_cliente"));
                            cliente.setNome(rs.getString("nome_cliente"));
                            cliente.setCPF(rs.getString("cpf_cliente"));
                            cliente.setEmail(rs.getString("email_cliente"));
                            cliente.setData(rs.getDate("data_cliente")); 
                            cliente.setRua(rs.getString("rua_cliente"));
                            cliente.setNumerorua(rs.getInt("nr_cliente"));
                            CidadeBean cidade= new CidadeBean();
                            CidadeDao cidad = new CidadeDao();
                            int idCidade = rs.getInt("fk_cidade");
                            cidade = cidad.Buscar(idCidade);
                            cliente.setCidade(cidade);
                            listaCliente.add(cliente);
                 }
                         return listaCliente;
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
    public ClienteBean Buscar(int id){ 
		try {
			String queryString = "SELECT * FROM tb_cliente where id_cliente=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, id);
			ResultSet rs = ptmt.executeQuery();
                        ClienteBean cliente = new ClienteBean();
                         while(rs.next()){
                            cliente.setId(rs.getInt("id_cliente"));
                            cliente.setNome(rs.getString("nome_cliente"));
                            cliente.setCPF(rs.getString("cpf_cliente"));
                            cliente.setEmail(rs.getString("email_cliente"));
                            cliente.setData(rs.getDate("data_cliente")); 
                            cliente.setRua(rs.getString("rua_cliente"));
                            cliente.setNumerorua(rs.getInt("nr_cliente"));
                            CidadeBean cidade= new CidadeBean();
                            CidadeDao cidad = new CidadeDao();
                            int idCidade = rs.getInt("fk_cidade");
                            cidade = cidad.Buscar(idCidade);
                            cliente.setCidade(cidade);
                            
                 }
                         return cliente;
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
   public boolean atualizar(ClienteBean cliente){
        try {
			String queryString = "UPDATE tb_cliente set nome_cliente=?,cpf_cliente=?,email_cliente=?,data_cliente=?,rua_cliente=?,nr_cliente=?,fk_cidade=? where id_cliente=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setString(1,cliente.getNome());
                        ptmt.setString(2,cliente.getCPF());
                        ptmt.setString(3,cliente.getEmail());
                        ptmt.setDate(4, new java.sql.Date(cliente.getData().getTime()));
                        ptmt.setString(5,cliente.getRua());   
                        ptmt.setInt(6,cliente.getNumerorua());
                        ptmt.setInt(7,cliente.getCidade().getId());    
                        ptmt.setInt(8,cliente.getId()); 
                        ptmt.executeUpdate();   
                        return true;
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
        return false;

        }
   public boolean remove(int id){
       try {
			String queryString = "Delete FROM tb_cliente where id_cliente=?";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, id);
			ptmt.executeUpdate();        
                        return true;
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
        return false;

        }
     public boolean adicionar(ClienteBean cliente){
        try {
			String queryString = "INSERT INTO tb_cliente (nome_cliente,cpf_cliente,email_cliente,data_cliente,rua_cliente,nr_cliente,cidade_cliente) values (?,?,?,?,?,?,?)";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
                        ptmt.setString(1,cliente.getNome());
                        ptmt.setString(2,cliente.getCPF());
                        ptmt.setString(3,cliente.getEmail());
                        ptmt.setDate(4, new java.sql.Date(cliente.getData().getTime()));
                        ptmt.setString(5,cliente.getRua());   
                        ptmt.setInt(6,cliente.getNumerorua());
                        ptmt.setInt(7,cliente.getCidade().getId());       
                        int rs = ptmt.executeUpdate();
                        if (rs != 0){
                            return true;
                        }  
                        return true;
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
        return false;

        }
   }
    
    

