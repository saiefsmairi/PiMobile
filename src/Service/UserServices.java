package Service;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.codename1.db.Cursor;
import com.codename1.db.Database;
import com.codename1.db.Row;
import com.mycompany.myapp.test.MyApplication;

import entities.User;

public class UserServices {
private Database db;
public UserServices() {
	// TODO Auto-generated constructor stub
	db=MyApplication.db;
}

public void inscription(User u) {
	try {
		db.execute("insert into user (nom,prenom,pass) values('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getPassword()+"')");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("user regitred +inserted");
		e.printStackTrace();
	}
}


public User login(String login,String mdp){
	User u=null;
	try {
		Cursor c=db.executeQuery("select * from user where nom='"+login+"' and pass='"+mdp+"'");
		
		while (c.next()) {
			Row r=c.getRow();
			u =new User();
			u.setId(r.getInteger(0));
			u.setNom(r.getString(1));
			u.setPrenom(r.getString(2));
			u.setPassword(r.getString(3));

		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return u;
}
}
