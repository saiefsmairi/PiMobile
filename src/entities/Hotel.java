/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author PC-Saif
 */
public class Hotel {
       private int id;
    private String name;
    private String pays;   
        private String adresse;
                private String email ;   

    private int nbetoile;   
    private int num;   
  private int lat;   
    private int ing; 

    public Hotel(String name, String pays, String adresse, String email, int nbetoile, int num, int lat, int ing) {
        this.name = name;
        this.pays = pays;
        this.adresse = adresse;
        this.email = email;
        this.nbetoile = nbetoile;
        this.num = num;
        this.lat = lat;
        this.ing = ing;
    }

    public Hotel(int id, String name, String pays, String adresse, String email, int nbetoile, int num, int lat, int ing) {
        this.id = id;
        this.name = name;
        this.pays = pays;
        this.adresse = adresse;
        this.email = email;
        this.nbetoile = nbetoile;
        this.num = num;
        this.lat = lat;
        this.ing = ing;
    }

    public Hotel() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNbetoile() {
        return nbetoile;
    }

    public void setNbetoile(int nbetoile) {
        this.nbetoile = nbetoile;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getIng() {
        return ing;
    }

    public void setIng(int ing) {
        this.ing = ing;
    }

    @Override
    public String toString() {
        return "Hotel{" + "id=" + id + ", name=" + name + ", pays=" + pays + ", adresse=" + adresse + ", email=" + email + ", nbetoile=" + nbetoile + ", num=" + num + ", lat=" + lat + ", ing=" + ing + '}';
    }

  
    

 
    
    
    
}
