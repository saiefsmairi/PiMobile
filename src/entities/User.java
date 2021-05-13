package entities;

public class User {
private int id;
private String nom;
private String prenom;
private String password;
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
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User(String nom, String prenom, String password) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.password = password;
}

public User() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "User [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", password=" + password + "]";
}


}
