package Forms;

import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import entities.User;

public class Home extends Form {
	public static Resources theme;
    private Form current;
 public Home() {
	 this.setLayout( BoxLayout.y());
this.setTitle("home");
	 	getToolbar().addCommandToSideMenu("home",null,l->{
	 		
	 	});
			 	
		
		
		getToolbar().addCommandToSideMenu("liste des voyage front",null,l->{
			UIManager.initFirstTheme("/theme");
	 		new ListeVoyageFront(this).show();

			});
		
		getToolbar().addCommandToSideMenu("liste des voyage back",null,l->{
	 		new ListeVoyage(this).show();

			});
		///mezel icon pour liste de voyage
		
		getToolbar().addCommandToSideMenu("Mes Réservations",null,l->{
	 		new ListeReservationClient(this).show();

			});
		getToolbar().addCommandToSideMenu("Ajout voyage",null,l->{
	 		new AjoutVoyage(this).show();

			});
		
		getToolbar().addCommandToSideMenu("stats",null,l->{
			     ChartDemosForm demos = new ChartDemosForm();
		        current = demos;
		       demos.show();   

			});
		
		
}
}
