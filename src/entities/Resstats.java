package entities;

public class Resstats {
String nomh;
int nbres;
public String getNomh() {
	return nomh;
}
public void setNomh(String nomh) {
	this.nomh = nomh;
}
public int getNbres() {
	return nbres;
}
public void setNbres(int nbres) {
	this.nbres = nbres;
}
public Resstats(String nomh, int nbres) {
	super();
	this.nomh = nomh;
	this.nbres = nbres;
}
public Resstats() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "resstats [nomh=" + nomh + ", nbres=" + nbres + "]";
}

}
