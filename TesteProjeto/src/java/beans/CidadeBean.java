/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author T-GAMER
 */
public class CidadeBean {
    private int id;
    private String nome;
    private EstadoBean estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public EstadoBean getEstado() {
        return estado;
    }

    public void setEstado(EstadoBean estado) {
        this.estado = estado;
    }

    public CidadeBean(int id, String nome, EstadoBean estadocod) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public CidadeBean() {
    }
    
    
}
