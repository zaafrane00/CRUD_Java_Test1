/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Zaafrane
 */
public class User {
    protected int id;
    protected String nom;
    protected String adress;

    public User(int id, String nom, String adress) {
        this.id = id;
        this.nom = nom;
        this.adress = adress;
    }
      public User() {
        
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", adress=" + adress + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
    
}
