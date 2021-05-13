package Forms;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import Service.UserServices;
import entities.User;

public class Inscription extends Form {
	 private UserServices s=new UserServices();
	 public Inscription() {
		 this.setLayout( BoxLayout.y());
		 
		 	TextField txt1=new TextField("","nom");
	        TextField txt2=new TextField("","prenom");
	        TextField txt3=new TextField("","password",20,TextField.PASSWORD);
	        
	        Button b=new Button("S'inscrire");
	        Button b2=new Button("Login");
	        
	        b.addActionListener(l->{

	        	if(txt1.getText().length()==0||txt2.getText().length()==0||txt3.getText().length()==0) {
	        		Dialog.show("Error", "veuillez remplire les champs", "OK",
							   null);
	        	}
	        	else {
	        		User u =new User(txt1.getText(),txt2.getText(),txt3.getText());
		        	s.inscription(u);
		        	Login f2 = new Login();
		            f2.show();
	        	}
	        	
	        	;

	        });
	        b2.addActionListener(l->{
	        	Login f2 = new Login();
	            f2.show();
	        });
	        this.addAll(txt1,txt2,txt3,b,b2);
	}
}
