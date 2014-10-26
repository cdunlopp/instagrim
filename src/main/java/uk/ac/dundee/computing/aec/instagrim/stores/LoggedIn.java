/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.stores;

/**
 *
 * @author Administrator
 */
public class LoggedIn {
    boolean logedin=false;
    String Username=null;
    String fname=null;
    String bio=null;
    java.util.UUID pPicID = null;
    
    public void LogedIn(){
        
    }
    
    public void setUsername(String name){
        this.Username=name;
    }
    public String getUsername(){
        return Username;
    }
    
    public void setBio(String bio){
        this.bio=bio;
    }
    public String getBio(){
        return bio;
    }
    
    public void setpPicID(java.util.UUID newpPicID){
        this.pPicID = newpPicID;
    }
    public java.util.UUID getpPicID(){
        return pPicID;
    }
    
    public void setFirstName(String name){
        this.fname=name;
    }
    public String getFirstName(){
        return fname;
    }
    
    public void setLogedin(){
        logedin=true;
    }
    public void setLogedout(){
        logedin=false;
    }
    
    public void setLoginState(boolean logedin){
        this.logedin=logedin;
    }
    public boolean getlogedin(){
        return logedin;
    }
}
