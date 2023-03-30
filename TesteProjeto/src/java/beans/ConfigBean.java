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
public class ConfigBean implements Serializable {
    
    private String email;
    
    public ConfigBean() {
    }
    public String getEmail() {
        return email;}
    
    public void setEmail(String email){
        this.email= email;
    }

} 

