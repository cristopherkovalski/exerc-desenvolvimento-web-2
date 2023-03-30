/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author T-GAMER
 */
public class AtendimentoBean implements Serializable{
    private int idAtendimento;
    private Date dtHrAtendimento;
    private String dscAtendimento;
    private ProdutoBean produto;
    private TipoAtendimentoBean tipoAtendimento;
    private int idUsuario;
    private int idCliente;
    private boolean resolvido;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setTipoAtendimento(TipoAtendimentoBean tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    public int getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(int idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public Date getDataHoraAtendimento() {
        return dtHrAtendimento;
    }

    public void setDataHoraAtendimento(Date dtHrAtendimento) {
        this.dtHrAtendimento = dtHrAtendimento;
    }

    public String getDescricaoAtendimento() {
        return dscAtendimento;
    }

    public void setDescricaoAtendimento(String dscAtendimento) {
        this.dscAtendimento = dscAtendimento;
    }

    public ProdutoBean getProduto() {
        return produto;
    }

    public void setProduto(ProdutoBean produto) {
        this.produto = produto;
    }

    public TipoAtendimentoBean getTipoAtendimento() {
        return tipoAtendimento;
}
}
