/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import beans.AtendimentoBean;
import beans.ClienteBean;
import beans.ProdutoBean;
import beans.TipoAtendimentoBean;
import beans.UsuarioBean;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-GAMER
 */
@WebServlet(urlPatterns = {"/AtendimentoServlet"})
public class AtendimentoServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                request.setAttribute("msg", "Usuário necessita estar logado no Sistema");
                dispatcher.forward(request, response);
            } else {
                String action = request.getParameter("action");
                if (action.equals("efetuar") || action == null) {
                    AtendimentoFacade atendimentof = new AtendimentoFacade();
                    List<ProdutoBean> produto = new ArrayList<>();
                    List<TipoAtendimentoBean> tipoAtend = new ArrayList<>();
                    tipoAtend = atendimentof.listaTipoAtendimento();
                    produto = atendimentof.listaProduto();
                    ClienteFacade cfacade = new ClienteFacade();
                    List<ClienteBean> listaCliente = new ArrayList<>();
                    listaCliente = cfacade.listarClientes();
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atendimento.jsp");
                    request.setAttribute("listaCliente", listaCliente);
                    request.setAttribute("listaProduto", produto);
                    request.setAttribute("listaTipoAtend", tipoAtend);
                    dispatcher.forward(request, response);
                } else if (action.equals("listar")) {
                    AtendimentoFacade atendimentof = new AtendimentoFacade();
                    List<AtendimentoBean> atendimentos = new ArrayList<>();
                    UsuarioBean usuario = new UsuarioBean();
                    int i = (int) session.getAttribute("logado");
                    atendimentos = atendimentof.listaAtendimentoUsuario(i);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/atendimentoVisualizar.jsp");
                    request.setAttribute("listaatd", atendimentos);
                    dispatcher.forward(request, response);
                }
            }
        } catch (Exception e) {
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AtendimentoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
    
