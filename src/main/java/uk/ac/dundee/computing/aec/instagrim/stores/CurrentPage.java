package uk.ac.dundee.computing.aec.instagrim.stores;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Christopher
 */
public class CurrentPage {
    
    String Username=null;
    String fname=null;
    String bio=null;
    java.util.UUID pPicID = null;
    
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
}