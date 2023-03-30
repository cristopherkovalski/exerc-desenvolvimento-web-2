/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-GAMER
 */
@WebServlet(urlPatterns = {"/PortalServlet"})
public class PortalServlet extends HttpServlet {    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário necessita estar Logado no Sistema");
            dispatcher.forward(request,response);
        } else {
            /* TODO output your page here. You may use following sample code. */
          out.println("<!DOCTYPE html>");   
             out.println("<html>");     
             out.println("<head>");
            out.println("<title>PortalServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div> <form action=\"logout\" method=\"get\">\n" +
"  \n" +
"        <br> <input type=\"submit\" value=\"Logout\" />\n" +
"    </form>");  
             String sql = " select nome_usuario, login_usuario, senha_usuario from usuario";
             String url = "jdbc:mysql://localhost:3306/tb_usuario?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
             String username = "root";
             String password = "vivimage";
             Class.forName("com.mysql.cj.jdbc.Driver");
             Connection con = DriverManager.getConnection(url,username,password);
             PreparedStatement st = con.prepareStatement(sql);
             ResultSet rs = st.executeQuery(sql);
             out.println("<table border=1 width=50% height=50%>");  
             out.println("<tr><th>Nome</th><th>Login</th><th>Senha</th><tr>");  
             while (rs.next()) 
             {  
                 String n = rs.getString("nome_usuario");  
                 String nm = rs.getString("login_usuario");  
                 String s = rs.getString("senha_usuario");   
                 out.println("<tr><td>" + n + "</td><td>" + nm + "</td><td>" + s + "</td></tr>");   
             }  
             out.println("</table>");  
            out.println("  <div><form action=\"CadastrarUsuarioServlet\" method=\"post\">  \n" +
"        Nome:<input type=\"text\" name=\"username\"/><br/><br/>  \n" +           
"        Login:<input type=\"text\" name=\"login\"/><br/><br/>  \n" +
"        Senha:<input type=\"password\" name=\"userpass\"/><br/><br/>  \n" +
"        <input type=\"submit\" value=\"Salvar\"/>  \n" +
"        </form></div>");
            out.println("</body>");
            out.println("</html>");
            }}catch (Exception e){
             e.printStackTrace();
         }
        }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
