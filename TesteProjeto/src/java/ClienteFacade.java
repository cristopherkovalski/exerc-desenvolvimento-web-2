
import beans.ClienteBean;
import dao.ClienteDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class ClienteFacade {
        ClienteDao cdao = new ClienteDao();

        
     public List<ClienteBean> listarClientes() throws SQLException{
            return cdao.listar();
                  
}
     public ClienteBean Buscar(int id){
         return cdao.Buscar(id);
     }
     
     public void alterar(ClienteBean c){
         cdao.atualizar(c);
     }
     public void remover(int id){
         cdao.remove(id);
     }
     public void adicionar(ClienteBean c){
         cdao.adicionar(c);
     }
     
}
