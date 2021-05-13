/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.ArrayList;

/**
 *
 * @author PC-Saif
 */
public class Place {

    private int id;
    private String longitude;
    private String altitude;
    private String nom;

    public Place(String longitude, String altitude, String nom) {
        this.longitude = longitude;
        this.altitude = altitude;
        this.nom = nom;
    }


    

    public Place(int id, String longitude, String altitude, String nom) {
        this.id = id;
        this.longitude = longitude;
        this.altitude = altitude;
        this.nom = nom;
      
    }

    

 
    

    @Override
    public String toString() {
        return "Place{" + "id=" + id + ", longitude=" + longitude + ", altitude=" + altitude + ", nom=" + nom + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAltitude() {
        return altitude;
    }

    public void setAltitude(String altitude) {
        this.altitude = altitude;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

  
    
    public Place() {
    }

}
