/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zaafrane
 */
public class Connectionn {
    public  Statement stm=null;
    ResultSet res=null;
    public  java.sql.Connection myConnection=null;

    public Connectionn() throws ClassNotFoundException,SQLException {
         Class.forName("com.mysql.jdbc.Driver");
         myConnection=DriverManager.getConnection("jdbc:mysql://localhost/javatest","root","");  
    }
    
    
    String [][] chercher(String colonnes[], String cond, String table) throws SQLException {
        stm=myConnection.createStatement();
        String response[][];
        
        String req="";
        for(int i=0; i<colonnes.length; i++) {
            if(i==colonnes.length-1)
                req+=colonnes[i];
            else
                req+=colonnes[i]+","; 
        }
        req="select "+req+" from "+table+ " where "+cond;
        System.err.println(req);
        res=stm.executeQuery(req);       
        res.last();
        int taille=res.getRow();
        res.beforeFirst();
        System.err.println(taille);
        response=new String[taille][colonnes.length];
        int i=0;
        while(res.next()) {
            for(int j=0; j<colonnes.length; j++)
            response[i][j]=res.getString(j+1);
            i++;
        }
        return response;
    }
    
    void addUser( User personne, String table) throws SQLException {
        stm=myConnection.createStatement();
        String req="";
        req="insert into "+table+"(id,nom,adress) values("+personne.id+","+personne.nom+","+personne.adress+")";
        stm.executeUpdate(req);
    }
    
    void updateUser( User personne, String table) throws SQLException {
        stm=myConnection.createStatement();
        String req="";
        req="update "+table+" set nom= "+personne.nom+",adress="+personne.adress+"where id="+personne.id;
        stm.executeUpdate(req);
    }
    
    void deleteUser( User personne, String table) throws SQLException {
        stm=myConnection.createStatement();
        String req="";
        req="delete from "+table+"where id="+personne.id;
        stm.executeUpdate(req);
    }
    
 
    
    
}
