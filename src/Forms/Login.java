package Forms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.InfiniteContainer;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.test.MyApplication;

import Service.UserServices;
import entities.User;




public class Login extends Form {
	 private UserServices s=new UserServices ();
User u=null;
boolean test=false ;
	 public Login() {
		 this.setLayout( BoxLayout.y());
		 
		 	TextField txt1=new TextField("","nom");
	        TextField txt3=new TextField("","password",20,TextField.PASSWORD);
	        Button b2=new Button("Login");
	        Button b=new Button("S'inscrire");

	        b.addActionListener(l->{
	        	Inscription i=new Inscription();
	        	i.show();
	        });
	        
	        
	        b2.addActionListener(l->{
	        	
	        	if(txt1.getText().length()==0||txt3.getText().length()==0) {
	        		Dialog.show("Error", "veuillez remplire les champs", "OK",
							   null);
	        	}
	        	else {
	        		        	
	        	u=s.login(txt1.getText(),txt3.getText());
	        
	        if(u==null) {
	        	Dialog.show("Error", "non user", "OK",
						   null);
	        }
	        else {
	        	Home h=new Home(u,this);
	        	h.show();
	        }
	        	
	        	
	        	}
	        });
	        
	        
	        this.addAll(txt1,txt3,b2,b);
	}
	 
}
