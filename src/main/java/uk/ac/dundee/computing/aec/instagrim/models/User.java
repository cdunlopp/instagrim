/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uk.ac.dundee.computing.aec.instagrim.models;

import com.datastax.driver.core.BoundStatement;
import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.PreparedStatement;
import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import uk.ac.dundee.computing.aec.instagrim.lib.AeSimpleSHA1;
import uk.ac.dundee.computing.aec.instagrim.stores.Pic;
import uk.ac.dundee.computing.aec.instagrim.stores.FoundList;

/**
 *
 * @author Administrator
 */
public class User {
    Cluster cluster;
    public User(){
        
    }
    
    public boolean RegisterUser(String username, String Password, String fname, String sname){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("insert into userprofiles (login,password,first_name,last_name) Values(?,?,?,?)");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username,EncodedPassword,fname,sname));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
    }
    
    public boolean SetBio(String bio, String user){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("update userprofiles set bio =? where login =?");
       
        BoundStatement boundStatement = new BoundStatement(ps);
        session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        bio,user));
        //We are assuming this always works.  Also a transaction would be good here !
        
        return true;
    }
    
    public boolean IsValidUser(String username, String Password){
        AeSimpleSHA1 sha1handler=  new AeSimpleSHA1();
        String EncodedPassword=null;
        try {
            EncodedPassword= sha1handler.SHA1(Password);
        }catch (UnsupportedEncodingException | NoSuchAlgorithmException et){
            System.out.println("Can't check your password");
            return false;
        }
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select password from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        username));
        if (rs.isExhausted()) {
            System.out.println("No Images returned");
            return false;
        } else {
            for (Row row : rs) {
               
                String StoredPass = row.getString("password");
                if (StoredPass.compareTo(EncodedPassword) == 0)
                    return true;
            }
        }  
    
    return false;  
    }
    
    public java.util.LinkedList<String> getUserProfile(String User) {
        java.util.LinkedList<String> profile = new java.util.LinkedList<>();
        Session session = cluster.connect("instagrim");
        PreparedStatement ps = session.prepare("select * from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        User));
        if (rs.isExhausted()) {
            System.out.println("No Information returned");
            return null;
        } else {
            for (Row row : rs) {
                String userName = row.getString("login");
                profile.push(userName);
            }
        }
        return profile;
    }
        
    public String getFirstName(String User) {
        String fname = null;
        Session session = cluster.connect("instagrim");
        
        PreparedStatement ps = session.prepare("select first_name from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        User));
        if (rs.isExhausted()) {
            System.out.println("No Information returned");
            return null;
        } else {
            for (Row row : rs) {
                fname = row.getString("first_name");
                                
            }
        }
        return fname;
    }
        
    public String getBio(String user) {
        String bio = null;
        Session session = cluster.connect("instagrim");
        
        PreparedStatement ps = session.prepare("select bio from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        user));
        if (rs.isExhausted()) {
            System.out.println("No Information returned");
            return null;
        } else {
            for (Row row : rs) {
                bio = row.getString("bio");
                                
            }
        }
        return bio;
    }
    
    public java.util.UUID getPic(String user) {
        java.util.UUID pPicID = null;
        Session session = cluster.connect("instagrim");
        
        PreparedStatement ps = session.prepare("select pPicID from userprofiles where login =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        user));
        if (rs.isExhausted()) {
            System.out.println("No Information returned");
            return null;
        } else {
            for (Row row : rs) {
                pPicID = row.getUUID("pPicID");                                
            }
        }
        return pPicID;
        
     }

    
    public java.util.LinkedList<FoundList> search(String name)
    {
        java.util.LinkedList<FoundList> search = new java.util.LinkedList<>();
        Session session = cluster.connect("instagrim");
        
        PreparedStatement ps = session.prepare("select login,first_name,last_name,pPicID from userprofiles where last_name =?");
        ResultSet rs = null;
        BoundStatement boundStatement = new BoundStatement(ps);
        rs = session.execute( // this is where the query is executed
                boundStatement.bind( // here you are binding the 'boundStatement'
                        name));
        if (rs.isExhausted()) {
            System.out.println("No Information returned");
            return null;
        } else {
            for (Row row : rs) {
                
                FoundList foundItem = new FoundList();
                
                foundItem.login = row.getString("login");
                foundItem.fname = row.getString("first_name");
                foundItem.sname = row.getString("last_name");
                foundItem.picID = row.getUUID("pPicID");
                
                search.push(foundItem);                
            }
        }
        return search;       
    }
    
    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    
}
