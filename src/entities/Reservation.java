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
public class Reservation {

    private int id;
    private String date_debut;
    private String date_fin;
    private int nb_adulte;
    private String type;
    private int nb_enfants;
    private int NbChambreSingleReserve;

    private int nbChambreDoubleReserve;
    private String confirme;
    private String token;
    private Hotel hotel;
    private Voyage voyage; 
    private int voyage_id;
    private int hotel_id;

    private String nomHotel;
private int prix;

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Reservation() {
    }

    @Override
    public String toString() {
        return "Reservation{" + "id=" + id + ", date_debut=" + date_debut + ", date_fin=" + date_fin + ", nb_adulte=" + nb_adulte + ", type=" + type + ", nb_enfants=" + nb_enfants + ", NbChambreSingleReserve=" + NbChambreSingleReserve + ", nbChambreDoubleReserve=" + nbChambreDoubleReserve + ", confirme=" + confirme + ", token=" + token + ", hotel=" + hotel + ", voyage=" + voyage + ", nomHotel=" + nomHotel + ", prix=" + prix + '}';
    }

  
    
  
    

    public Reservation( String date_debut, String date_fin, int nb_adulte, int nb_enfants,
			int nbChambreSingleReserve, int nbChambreDoubleReserve, int voyage_id, int prix) {
		super();
		
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nb_adulte = nb_adulte;
		this.nb_enfants = nb_enfants;
		NbChambreSingleReserve = nbChambreSingleReserve;
		this.nbChambreDoubleReserve = nbChambreDoubleReserve;
		this.voyage_id = voyage_id;
		this.prix = prix;
	}
    

    public Reservation( String date_debut, String date_fin, int nb_adulte, int nb_enfants,
			int nbChambreSingleReserve, int nbChambreDoubleReserve, int voyage_id, int prix,int hotel_id) {
		super();
		
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.nb_adulte = nb_adulte;
		this.nb_enfants = nb_enfants;
		NbChambreSingleReserve = nbChambreSingleReserve;
		this.nbChambreDoubleReserve = nbChambreDoubleReserve;
		this.voyage_id = voyage_id;
		this.prix = prix;
		this.hotel_id=hotel_id;
	}

	public int getVoyage_id() {
		return voyage_id;
	}

	public void setVoyage_id(int voyage_id) {
		this.voyage_id = voyage_id;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getNomHotel() {
        return nomHotel;
    }

    public void setNomHotel(String nomHotel) {
        this.nomHotel = nomHotel;
    }


    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNb_adulte() {
        return nb_adulte;
    }

    public void setNb_adulte(int nb_adulte) {
        this.nb_adulte = nb_adulte;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNb_enfants() {
        return nb_enfants;
    }

    public void setNb_enfants(int nb_enfants) {
        this.nb_enfants = nb_enfants;
    }

    public int getNbChambreSingleReserve() {
        return NbChambreSingleReserve;
    }

    public void setNbChambreSingleReserve(int NbChambreSingleReserve) {
        this.NbChambreSingleReserve = NbChambreSingleReserve;
    }

    public int getNbChambreDoubleReserve() {
        return nbChambreDoubleReserve;
    }

    public void setNbChambreDoubleReserve(int nbChambreDoubleReserve) {
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
    }

    public String getConfirme() {
        return confirme;
    }

    public void setConfirme(String confirme) {
        this.confirme = confirme;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Reservation(int id, String date_debut, String date_fin, int nb_adulte, String type, int nb_enfants, int NbChambreSingleReserve, int nbChambreDoubleReserve, String confirme, String token) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.type = type;
        this.nb_enfants = nb_enfants;
        this.NbChambreSingleReserve = NbChambreSingleReserve;
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
        this.confirme = confirme;
        this.token = token;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Voyage getVoyage() {
        return voyage;
    }

    public void setVoyage(Voyage voyage) {
        this.voyage = voyage;
    }

    
    
    
    public Reservation(String date_debut, String date_fin, int nb_adulte, String type, int nb_enfants, int NbChambreSingleReserve, int nbChambreDoubleReserve, String confirme, String token, Hotel hotel, Voyage voyage) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.type = type;
        this.nb_enfants = nb_enfants;
        this.NbChambreSingleReserve = NbChambreSingleReserve;
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
        this.confirme = confirme;
        this.token = token;
        this.hotel = hotel;
        this.voyage = voyage;
    }

    public Reservation(String date_debut, String date_fin, int nb_adulte, int nb_enfants, int NbChambreSingleReserve, int nbChambreDoubleReserve, Hotel hotel, Voyage voyage) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.nb_enfants = nb_enfants;
        this.NbChambreSingleReserve = NbChambreSingleReserve;
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
        this.hotel = hotel;
        this.voyage = voyage;
    }

    public Reservation(int id, String date_debut, String date_fin, int nb_adulte, int nb_enfants, Hotel hotel, Voyage voyage) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.nb_enfants = nb_enfants;
        
    }

    public Reservation(int id, String date_debut, String date_fin, int nb_adulte, int nb_enfants, int NbChambreSingleReserve, int nbChambreDoubleReserve, Hotel hotel, Voyage voyage) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.nb_enfants = nb_enfants;
        this.NbChambreSingleReserve = NbChambreSingleReserve;
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
        this.hotel = hotel;
        this.voyage = voyage;
    }

    public Reservation(int id, String date_debut, String date_fin, int nb_adulte, int nb_enfants, int NbChambreSingleReserve, int nbChambreDoubleReserve, Voyage voyage,String type) {
        this.id = id;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.nb_enfants = nb_enfants;
        this.NbChambreSingleReserve = NbChambreSingleReserve;
        this.nbChambreDoubleReserve = nbChambreDoubleReserve;
         this.voyage = voyage;
         this.type=type;
    }

 
    
   public Reservation(String date_debut, String date_fin, int nb_adulte, int nb_enfants, Hotel hotel, Voyage voyage) {
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.nb_adulte = nb_adulte;
        this.nb_enfants = nb_enfants;
       
        this.hotel = hotel;
        this.voyage = voyage;
    }

    
}
