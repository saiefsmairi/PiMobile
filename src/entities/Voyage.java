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
public class Voyage {

    private int id;
    private String nom;
    private String ville;
    private String description;
    private String date_debut;
    private String date_fin;
    private int prix_personne;
    private int nb_personne;
private int idHotel;
    private String image;

    private Hotel hotel;

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }
   
    
    public Voyage(String nom, String ville, String description, String date_debut, String date_fin, int prix_personne,
			int nb_personne, int idHotel) {
		super();
		this.nom = nom;
		this.ville = ville;
		this.description = description;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.prix_personne = prix_personne;
		this.nb_personne = nb_personne;
		this.idHotel = idHotel;
	}

	public Voyage(int id, String nom, String ville, String description, String date_debut, String date_fin, int prix_personne, int nb_personne,int idHotel) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix_personne = prix_personne;
        this.nb_personne = nb_personne;
        this.idHotel=idHotel;
    }

    public Voyage() {
    }

    public Voyage(int id, String nom, String ville, String description, String date_debut, String date_fin, int prix_personne, int nb_personne, String image, Hotel hotel) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix_personne = prix_personne;
        this.image = image;
        this.hotel = hotel;
        this.nb_personne = nb_personne;

    }

    public Voyage(String nom, String ville, String description, String date_debut, String date_fin, int prix_personne, int nb_personne, String image, Hotel hotel) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix_personne = prix_personne;
        this.image = image;
        this.hotel = hotel;
        this.nb_personne = nb_personne;
    }

    public Voyage(String nom, String ville, String description, String date_debut, String date_fin, int prix_personne, int nb_personne) {
        this.nom = nom;
        this.ville = ville;
        this.description = description;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.prix_personne = prix_personne;
        this.nb_personne = nb_personne;
    }

    public int getNb_personne() {
        return nb_personne;
    }

    public void setNb_personne(int nb_personne) {
        this.nb_personne = nb_personne;
    }

    public Voyage(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
    }

    @Override
    public String toString() {
        return "Voyage{" + "id=" + id + ", nom=" + nom + ", ville=" + ville + ", description=" + description + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", prix_personne=" + prix_personne + ", nb_personne=" + nb_personne + ", idHotel=" + idHotel + ", image=" + image + ", hotel=" + hotel + '}';
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

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getPrix_personne() {
        return prix_personne;
    }

    public void setPrix_personne(int prix_personne) {
        this.prix_personne = prix_personne;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
