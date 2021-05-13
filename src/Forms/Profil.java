package Forms;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.test.MyApplication;

import entities.User;

public class Profil extends Form {
	public Profil(User u,Form previous) {
		 this.setLayout( BoxLayout.y());
		 ImageViewer img= new ImageViewer(MyApplication.theme.getImage("Profile.png"));
		 	Label lb1=new Label(u.getNom());
		 	Label lb2=new Label(u.getPrenom());
		 	
			getToolbar().addCommandToRightBar("retour",null,l->{
				previous.showBack();
			});
			
			this.addAll(lb1,lb2,img);

	}

}
