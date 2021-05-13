package entities;

public class Voiture {
private int id;
private String marque;
private String modele;
private String image;
private int prix;
public Voiture(int id, String marque, String modele, String image, int prix) {
	super();
	this.id = id;
	this.marque = marque;
	this.modele = modele;
	this.image = image;
	this.prix = prix;
}
 public Voiture() {
	// TODO Auto-generated constructor stub
}
 
public Voiture(String marque, String modele, String image, int prix) {
	super();
	this.marque = marque;
	this.modele = modele;
	this.image = image;
	this.prix = prix;
}
@Override
public String toString() {
	return "Voiture [id=" + id + ", marque=" + marque + ", modele=" + modele + ", image=" + image + ", prix=" + prix
			+ "]";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getMarque() {
	return marque;
}
public void setMarque(String marque) {
	this.marque = marque;
}
public String getModele() {
	return modele;
}
public void setModele(String modele) {
	this.modele = modele;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public int getPrix() {
	return prix;
}
public void setPrix(int prix) {
	this.prix = prix;
}
 
 

}
