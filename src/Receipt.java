
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jocelyn
 */
public class Receipt {
    private String name;
    private String email;
    private int phoneNum;
    private String address;
    public Receipt(){
        
    }
    //set method
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhoneNum(int phoneNum){
        this.phoneNum = phoneNum;
    }
    public void setAddress(String address){
        this.address = address;
    }
    //get method
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public int getPhoneNum(){
        return phoneNum;
    }
    public String getAddress(){
        return address;
    }
     @Override
    public String toString(){
        String msg = "Name: " + getName() + "\nEmail: " + getEmail() ;
        return msg;
    }
    
}
