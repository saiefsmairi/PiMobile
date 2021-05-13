package Forms;

import java.util.List;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.myapp.test.MyApplication;

import Service.ReservationService;
import Service.ServiceVoyage;
import Service.VoitureService;
import entities.Reservation;
import entities.Voiture;
import entities.Voyage;
import entities.utilities;

public class ListeVoyageFront extends BaseForm {
	ReservationService voitureService=new ReservationService();
@SuppressWarnings("deprecation")
public ListeVoyageFront(Form previous) {
	this.setTitle("Liste des Voyages à Réserver");
	 this.setLayout( BoxLayout.y());

		Toolbar.setGlobalToolbar(true);
		Style s = UIManager.getInstance().getComponentStyle("Title");
		getToolbar().addCommandToRightBar("retour",null,l->{
			UIManager.initFirstTheme("/theme");
			previous.showBack();

		});
		TextField searchField = new TextField("", "Rechercher par ville"); // <1>
		searchField.getHintLabel().setUIID("Title");
		searchField.setUIID("Title");
		searchField.getAllStyles().setAlignment(Component.LEFT);
		this.getToolbar().setTitleComponent(searchField);
		FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
		searchField.addDataChangeListener((i1, i2) -> { // <2>
			String t = searchField.getText();
			if (t.length() < 1) {
				this.removeAll();
				 List<Voyage>lst1=ServiceVoyage.getInstance().getAllTasks();

				 for (Voyage v : lst1) {
					 add(addItem(v));


				}

			} else {
				System.out.println(t);

				t = t.toLowerCase();
				this.removeAll();

				 List<Voyage>lst1=ServiceVoyage.getInstance().getAllTaskssearch(t);

				 for (Voyage v : lst1) {
					 add(addItem(v));


				}

			}
			this.getContentPane().animateLayout(250);
		});
		this.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
			searchField.startEditingAsync(); // <4>
		});
	 List<Voyage>lst1=ServiceVoyage.getInstance().getAllTasks();

	 for (Voyage v : lst1) {
		 add(addItem(v));


	}
	 


}
 public Container addItem(Voyage v) {
	 Container  holder=new Container(BoxLayout.x());
	 Container  holderdetails=new Container(BoxLayout.y());
		Label lb1=new Label(v.getVille());
		Label lb2=new Label(v.getDate_debut());
		Label lb3=new Label(String.valueOf(v.getPrix_personne()));
		holderdetails.addAll(lb1,lb2,lb3);
		
		EncodedImage im=EncodedImage.createFromImage(MyApplication.theme.getImage("load.jpg"), false);
		//Image img=URLImage.createToStorage(im, "voiture_"+v.getMarque(), v.getImage(),URLImage.RESIZE_SCALE);
		 ImageViewer img2= new ImageViewer(im);

			holder.addAll(img2,holderdetails);
			holder.setUIID("holditem");

			lb1.addPointerReleasedListener(l->{
				System.out.println(v.getId());


				new ReservationVoyage(v,this).show();
			}
			);
			holder.setLeadComponent(lb1);
				return holder;
	 
 }

}
