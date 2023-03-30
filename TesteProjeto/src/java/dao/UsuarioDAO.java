/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import beans.UsuarioBean;
import static java.lang.System.out;
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
public class UsuarioDAO {
    Connection connection = null;
    PreparedStatement ptmt = null;
    ResultSet resultSet = null;
    
    public UsuarioDAO() {

	}

	private Connection getConnection() throws SQLException {
		Connection conn;
		conn = ConnectionFactory.getInstance().getConnection();
		return conn;
	}

	public boolean add(UsuarioBean usuarioBean){ 
		try {
			String queryString = "insert into usuario (nome_usuario,login_usuario,senha_usuario) values (?,?,?);";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ptmt.setString(1, usuarioBean.getNome());
			ptmt.setString(2, usuarioBean.getLogin());
			ptmt.setString(3, usuarioBean.getPassword());
			int rs = ptmt.executeUpdate();
                        if (rs != 0){
                            return true;
                        }        
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
    public UsuarioBean buscar(int idUsuario) throws SQLException {
            try { 
                  String queryString = "SELECT * FROM usuario WHERE id_usuario = ?";
                    connection = getConnection();
                     ptmt = connection.prepareStatement(queryString);
                        ptmt.setInt(1, idUsuario);
                         ResultSet rs = ptmt.executeQuery();
                    if (rs.next()){
                        UsuarioBean usuario = new UsuarioBean();
                        usuario.setId(rs.getInt("id_usuario"));
                        usuario.setNome(rs.getString("nome_usuario"));
                        usuario.setLogin(rs.getString("login_usuario"));
                        usuario.setPassword(rs.getString("senha_usuario"));
                        return usuario;
        }
            } catch (SQLException e){
			e.printStackTrace();
		}finally {
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
    
    public  List<UsuarioBean> listar(){ 
		try {
                        List<UsuarioBean> listaUsuario = new ArrayList<>();
			String queryString = "SELECT * FROM usuario";
			connection = getConnection();
			ptmt = connection.prepareStatement(queryString);
			ResultSet rs = ptmt.executeQuery();
                         while(rs.next()){
                            UsuarioBean usuario = new UsuarioBean();
                            usuario.setId(rs.getInt("id_usuario"));
                            usuario.setNome(rs.getString("nome_usuario"));
                            usuario.setLogin(rs.getString("login_usuario"));
                            usuario.setPassword(rs.getString("senha_usuario"));
                            listaUsuario.add(usuario);
                 }
                         return listaUsuario;
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
    
     public UsuarioBean buscarLogado(String log, String pass) throws SQLException {
            try { 
                  String queryString = " select * from usuario where login_usuario=? and senha_usuario=?";
                    connection = getConnection();
                     ptmt = connection.prepareStatement(queryString);
                        ptmt.setString(1, log);
                         ptmt.setString(2, pass);
                         ResultSet rs = ptmt.executeQuery();
                    if (rs.next()){
                        UsuarioBean usuario = new UsuarioBean();
                        usuario.setId(rs.getInt("id_usuario"));
                        usuario.setNome(rs.getString("nome_usuario"));
                        usuario.setLogin(rs.getString("login_usuario"));
                        usuario.setPassword(rs.getString("senha_usuario"));
                        return usuario;
        }
            } catch (SQLException e){
			e.printStackTrace();
		}finally {
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
	
    



