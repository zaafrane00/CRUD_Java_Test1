/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Zaafrane
 */
public class ManageUser  {

    
    Connectionn conec=null;
    public ManageUser() {
        try {
            conec=new Connectionn();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    public static String getUserbyName(String name)throws SQLException{
        String req= "select * from users where name="+name;     
          super.stm=myConnection.createStatement();
         return req;
    }*/
    
     
    
    
    public String[][] getUserbyName(String name)throws SQLException{
        String res[][];
         res=this.conec.chercher(new String[]{"nom","adress"}, "nom='"+name+"'", "client") ;
         System.out.println(Arrays.deepToString(res));
         return res;
    }
    
    public void store(User p)throws SQLException{
        this.conec.addUser(p, "client");
    }
    
     public void update(User p)throws SQLException{
        this.conec.addUser(p, "client");
    }
    
      public void destroy(User p)throws SQLException{
        this.conec.deleteUser(p, "client");
    }
    
     
    
    public static void main(String args[]){
        try {
            //Connectionn conn=new Connectionn();
            
            
            ManageUser mg=new ManageUser();
            User p=new User(5,"hamza2","adress552");
            //mg.getUserbyName("mohamed");
            mg.store(p);
        } catch (SQLException ex) {
            Logger.getLogger(ManageUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        }

    
}
