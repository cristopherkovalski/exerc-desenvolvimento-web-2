/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author T-GAMER
 */
public class TipoAtendimentoBean implements Serializable {
    private int idTipoAtendimento;
    private String nomeTipoAtendimento;

    public int getIdTipoAtendimento() {
        return idTipoAtendimento;
    }

    public void setIdTipoAtendimento(int idTipoAtendimento) {
        this.idTipoAtendimento = idTipoAtendimento;
    }

    public String getNomeTipoAtendimento() {
        return nomeTipoAtendimento;
    }

    public void setNomeTipoAtendimento(String nomeTipoAtendimento) {
        this.nomeTipoAtendimento = nomeTipoAtendimento;
    }
    
    
}
