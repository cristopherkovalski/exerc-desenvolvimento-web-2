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
public class LoginBean implements Serializable  {

  private String userName="";
  private String password="";
  
  public LoginBean(){
  }

  
  public String getUserName() {
  return this.userName;
  }
  public void setUserName(String userName) {
  this.userName = userName;
  }
  public String getPassword() {
  return this.password;
  }
  public void setPassword(String password) {
 this.password = password;
  }
  }
    
