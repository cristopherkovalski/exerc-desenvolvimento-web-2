/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author T-GAMER
 */
public class Usuario {
    private String Nome;
    private String Login;
    private String Password;
    String getLogin;
    String getPassword;

    public Usuario(String Nome, String Login, String Password) {
        this.Nome = Nome;
        this.Login = Login;
        this.Password = Password;
    }
    
    public Usuario(){
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    
}
