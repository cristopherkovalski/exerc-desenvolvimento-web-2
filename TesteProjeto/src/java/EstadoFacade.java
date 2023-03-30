
import beans.EstadoBean;
import dao.EstadoDao;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class EstadoFacade {
      EstadoDao estdao= new EstadoDao();
    
    public EstadoBean buscar(int id){
       return estdao.Buscar(id);   
    }
    public List <EstadoBean> listar(){
       return estdao.listar();   
    }
}

    
