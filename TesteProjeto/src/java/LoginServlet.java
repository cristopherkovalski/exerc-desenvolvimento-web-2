/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


import dao.LoginDao;
import beans.LoginBean;
import beans.UsuarioBean;
import jakarta.servlet.RequestDispatcher;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author T-GAMER
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public LoginServlet() {
        super();
    }

    /*  public boolean check(String login, String pass){
         try{
             Class.forName("com.mysql.jdbc.Driver");
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
             
    //         HttpSession session = request.getSession();
      //       session.setAttribute ("logado", login);
      //       out.println("Usuário logado com sucesso </body>");
      //  } else{
     //           out.println("Usuário inválido </body>");    
     //   }
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            if (request.getParameter("user") == null || request.getParameter("userpass") == null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário ou Senha inválido!");
                dispatcher.forward(request, response);
            } else {
                String log = request.getParameter("user");
                String passw = request.getParameter("userpass");
                LoginDao dao = new LoginDao();
                if (dao.check(log, passw)) {
                    LoginBean loginBean = new LoginBean();
                    UsuarioBean usuario = new UsuarioBean();
                    AtendimentoFacade atd = new AtendimentoFacade();
                    loginBean.setUserName(log);
                    loginBean.setPassword(passw);
                    HttpSession session = request.getSession();
                    session.setAttribute("login", log);
                    usuario = atd.listarLogado(log, passw);
                    int id = usuario.getId();
                    session.setAttribute("logado", id);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/portal.jsp");
                    dispatcher.forward(request, response);
                } else {
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    request.setAttribute("msg", "Usuário ou Senha inválido!");
                    dispatcher.forward(request, response);
                }

            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

