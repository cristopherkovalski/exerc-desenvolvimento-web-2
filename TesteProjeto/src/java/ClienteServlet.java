/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import beans.CidadeBean;
import beans.ClienteBean;
import beans.EstadoBean;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author T-GAMER
 */
@WebServlet(urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            HttpSession session = request.getSession();
            if (session.getAttribute("login") == null) {
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
            request.setAttribute("msg", "Usuário necessita estar logado no Sistema");
            dispatcher.forward(request,response);
        } else {
             String action = request.getParameter("action");
             if (action.equals ("list") || action == null){
                ClienteFacade cfacade = new ClienteFacade();
                List<ClienteBean> listaCliente = new ArrayList<>();
                listaCliente = cfacade.listarClientes();
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clienteListar.jsp");
                request.setAttribute("lista", listaCliente);
                dispatcher.forward(request,response);
             }
             else if(action.equals ("show")){
                    String idm = request.getParameter("id");
                    int id = Integer.parseInt(idm);
                    ClienteFacade cfacade = new ClienteFacade();
                    ClienteBean cliente = new ClienteBean();
                    cliente = cfacade.Buscar(id);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clienteVisualizar.jsp");
                    request.setAttribute("cliente", cliente);
                    dispatcher.forward(request,response);
                    }
            else if(action.equals ("formUpdate")){
                    String idm = request.getParameter("id");
                    int id = Integer.parseInt(idm);
                    ClienteFacade cfacade = new ClienteFacade();
                    ClienteBean cliente = new ClienteBean();
                    List<EstadoBean> listaestado = new ArrayList<>();
                    EstadoFacade efacade = new EstadoFacade();
                    listaestado = efacade.listar();
                    cliente = cfacade.Buscar(id);
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                    request.setAttribute("cliente", cliente);
                    request.setAttribute("estados", listaestado);
                    request.setAttribute("form", "alterar");
                    dispatcher.forward(request,response);
                    }
               else if(action.equals ("update")){
                    String idm = request.getParameter("id");
                    int id = Integer.parseInt(idm);
                    String nome = request.getParameter("nome");
                    String email = request.getParameter("email");
                    String cpf = request.getParameter("cpf");
                    String data = request.getParameter("data");
                    Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(data);
                    String rua = request.getParameter("rua");
                    String nrua = request.getParameter("numerorua");
                    int numrua = Integer.parseInt(nrua);
                    String cidade = request.getParameter("cidade");
                    int cida = Integer.parseInt(cidade);
                    String CEP= request.getParameter("CEP");
                    CidadeFacade cidfacade = new CidadeFacade();
                    CidadeBean cid= new CidadeBean();
                    cid=cidfacade.buscar(cida);
                    ClienteBean cliente = new ClienteBean(); 
                    cliente.setNome(nome);
                    cliente.setEmail(email);
                    cliente.setCEP(CEP);
                    cliente.setData(date1);
                    cliente.setCPF(cpf);
                    cliente.setId(id);
                    cliente.setRua(rua);
                    cliente.setCidade(cid);
                    cliente.setNumerorua(numrua);
                    ClienteFacade cfacade = new ClienteFacade();
                    cfacade.alterar(cliente); 
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/portal.jsp");
                    dispatcher.forward(request,response);
                    }
               else if(action.equals ("remove")){
                   String idm = request.getParameter("id");
                   int id = Integer.parseInt(idm);
                   ClienteFacade cfacade = new ClienteFacade();
                   cfacade.remover(id); 
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/portal.jsp");
                   dispatcher.forward(request,response);
               }
               else if(action.equals("formNew")){
                   List<EstadoBean> listaestado = new ArrayList<>();
                   EstadoFacade efacade = new EstadoFacade();
                   listaestado = efacade.listar();
                   RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/clienteForm.jsp");
                   request.setAttribute("form", "novo");
                   request.setAttribute("estados", listaestado);
                   dispatcher.forward(request,response); 
            }
               else if(action.equals("new")){
                    String nome = request.getParameter("nome");
                    String email = request.getParameter("email");
                    String cpf = request.getParameter("cpf");
                    String data = request.getParameter("data");
                    Date date1 = new SimpleDateFormat("yyyy-mm-dd").parse(data);
                    String rua = request.getParameter("rua");
                    String nrua = request.getParameter("numerorua");
                    int numrua = Integer.parseInt(nrua);
                    String cidade = request.getParameter("cidade");
                    int cida = Integer.parseInt(cidade);
                    CidadeFacade cidfacade = new CidadeFacade();
                    CidadeBean cid= new CidadeBean();
                    cid=cidfacade.buscar(cida);
                    String CEP= request.getParameter("CEP");
                    ClienteBean cliente = new ClienteBean(); 
                    cliente.setNome(nome);
                    cliente.setEmail(email);
                    cliente.setCEP(CEP);
                    cliente.setData(date1);
                    cliente.setCPF(cpf);
                    cliente.setRua(rua);
                    cliente.setCidade(cid);
                    cliente.setNumerorua(numrua);
                    ClienteFacade cfacade = new ClienteFacade();
                    cfacade.adicionar(cliente); 
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/portal.jsp");
                    dispatcher.forward(request,response);
                    }  
               } 
        }catch (Exception e){
             e.printStackTrace();
         }
        }
               // request.setAttribute("lista", listaCliente);
               // RequestDispatcher rd = getServletContext().getRequestDispatcher("/clienteListar.jsp");
               // rd.forward(request, response);
                
                
          
        
    
    
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ClienteServlet.class.getName()).log(Level.SEVERE, null, ex);
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
