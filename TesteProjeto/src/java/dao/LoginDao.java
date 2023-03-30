package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class LoginDao {
    String sql = " select * from usuario where login_usuario=? and senha_usuario=?";
    String url = "jdbc:mysql://localhost:3306/tb_usuario?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    String username = "root";
    String password = "vivimage";
    
    public boolean check(String login, String pass){
         try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,username,password);
             PreparedStatement st = con.prepareStatement(sql);
             st.setString(1, login);
             st.setString(2, pass);
             ResultSet rs = st.executeQuery();
             if (rs.next())
             {
                 return true;
             }
               
            }catch (Exception e){
             e.printStackTrace();
            }
            return false;
        
    }
}
