package Service;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.mycompany.myapp.test.MyApplication;

import entities.User;
import entities.Voiture;

public class VoitureService {
private Database db;
public VoitureService() {
	// TODO Auto-generated constructor stub
	db=MyApplication.db;
}

public void ajoutVoiture(Voiture u) {
	try {
		db.execute("insert into voiture (marque,modele,image,prix) values('"+u.getMarque()+"','"+u.getModele()+"','"+u.getImage()+"','"+u.getPrix()+"')");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("insrted");
		e.printStackTrace();
	}
}

public void deleteVoiture(Voiture u) {
	try {
		db.execute("delete from voiture where id= "+u.getId());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("insrted");
		e.printStackTrace();
	}
}

public void deletetoutVoiture() {
	try {
		db.execute("delete from voiture ");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("insrted");
		e.printStackTrace();
	}
}

public List<Voiture> Afficher(){
	List<Voiture>lst=new ArrayList<>();
	try {
		Cursor c=db.executeQuery("select * from voiture");
		
		while (c.next()) {
			Row r=c.getRow();
			Voiture u =new Voiture();
			u.setId(r.getInteger(0));
			u.setMarque(r.getString(1));
			u.setModele(r.getString(2));
			u.setImage(r.getString(3));
			u.setPrix(r.getInteger(4));

lst.add(u);
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return lst;
	
}
}
