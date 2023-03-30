
import beans.AtendimentoBean;
import beans.ProdutoBean;
import beans.TipoAtendimentoBean;
import beans.UsuarioBean;
import dao.AtendimentoDAO;
import dao.ProdutoDAO;
import dao.TipoAtendimentoDAO;
import dao.UsuarioDAO;
import java.sql.SQLException;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class AtendimentoFacade {
    AtendimentoDAO atendimento =  new AtendimentoDAO();
    ProdutoDAO produto= new ProdutoDAO();
    TipoAtendimentoDAO tipoatendimento = new TipoAtendimentoDAO();
    UsuarioDAO usuario= new UsuarioDAO();
    
    
    
    public List <AtendimentoBean> listaAtendimento() throws SQLException{
        return atendimento.Listar();
    }
    public List <AtendimentoBean> listaAtendimentoUsuario(int id) throws SQLException{
        return atendimento.listarAtendimentoUsuario(id);
    }
    public AtendimentoBean buscaAtendimento(int id) throws SQLException{
        return atendimento.Buscar(id);
    }
    
    public List <ProdutoBean> listaProduto() throws SQLException{
        return produto.Listar();
    }
    public ProdutoBean buscaProduto(int id) throws SQLException{
        return produto.Buscar(id);
    }
   
    public List <TipoAtendimentoBean> listaTipoAtendimento() throws SQLException  {
         return tipoatendimento.Listar();
     }
    public TipoAtendimentoBean buscaTipoAtendimento(int id) throws SQLException {
        return tipoatendimento.Buscar(id);
    }
    
     public List <UsuarioBean> Listar() throws SQLException{
        return usuario.listar();
    }
    public UsuarioBean listarLogado(String log, String pass) throws SQLException{
        return usuario.buscarLogado(log, pass);
    }
    
     
}
