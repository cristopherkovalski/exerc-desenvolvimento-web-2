
import beans.CidadeBean;
import dao.CidadeDao;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class CidadeFacade {
    CidadeDao cidao= new CidadeDao();
    
    public CidadeBean buscar(int id){
       return cidao.Buscar(id);   
    }
    public List <CidadeBean> listar(){
       return  cidao.listar();   
    }
    public List <CidadeBean> listarCidadesEstado(int id){
        return cidao.getCidadesByEstadoId(id);
    }
    
}
