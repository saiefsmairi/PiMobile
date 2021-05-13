package Forms;

import java.util.List;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;

import com.mycompany.myapp.test.MyApplication;

import Service.ServiceVoyage;
import Service.VoitureService;
import entities.Voiture;
import entities.Voyage;
import entities.utilities;

public class ListeVoyage extends Form {
	VoitureService voitureService=new VoitureService();
public ListeVoyage(Form previous) {
	this.setTitle("Liste des Voyages");
	 this.setLayout( BoxLayout.y());
	 List<Voyage>lst1=ServiceVoyage.getInstance().getAllTasks();
		getToolbar().addCommandToRightBar("retour",null,l->{
			previous.showBack();

		});
	 for (Voyage v : lst1) {
		 add(addItem(v));
		
	}
	 
	 
	 List<Voiture>lst=utilities.getEquipes();
	 for (Voiture voiture : lst) {


	}
}
 public Container addItem(Voyage v) {
	 Container  holder=new Container(BoxLayout.x());
	 Container  holderdetails=new Container(BoxLayout.y());
		Label lb1=new Label(v.getNom());
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


				new VoyageDetail(v.getId(),v,this,null).show();
			}
			);
			holder.setLeadComponent(lb1);
				return holder;
	 
 }

}
