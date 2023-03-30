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
public class ClienteBean implements Serializable {
    private int id;
    private String Nome;
    private String CPF;
    private String email;
    private Date data;
    private String rua;
    private int numerorua;
    private String CEP;
    private CidadeBean cidade;


    public ClienteBean(int id, String Nome, String CPF, String email, Date data, String rua, int numerorua, String CEP, CidadeBean cidade) {
        this.id = id;
        this.Nome = Nome;
        this.CPF = CPF;
        this.email = email;
        this.data = data;
        this.rua = rua;
        this.numerorua = numerorua;
        this.CEP = CEP;
        this.cidade = cidade;

    }

   public ClienteBean(){
   } 
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumerorua() {
        return numerorua;
    }

    public void setNumerorua(int numerorua) {
        this.numerorua = numerorua;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public CidadeBean getCidade() {
        return cidade;
    }

    public void setCidade(CidadeBean cidade) {
        this.cidade = cidade;
    }
    
    
}
