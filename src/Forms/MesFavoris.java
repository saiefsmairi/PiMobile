package Forms;

import java.util.List;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.test.MyApplication;

import Service.VoitureService;
import entities.Voiture;
import entities.utilities;

public class MesFavoris  extends Form  {
	
	VoitureService voitureService=new VoitureService();
public MesFavoris(Form previous) {
	 this.setLayout( BoxLayout.y());
	 List<Voiture>lst=voitureService.Afficher();


	 getToolbar().addCommandToOverflowMenu("delete all",null,l->{
		 voitureService.deletetoutVoiture();
		 previous.showBack();
		});
	 getToolbar().addCommandToOverflowMenu("refresh",null,l->{
			MesFavoris mesFavoris=new MesFavoris(this);
			mesFavoris.show();
		});
	 
	 getToolbar().addCommandToOverflowMenu("retour",null,l->{
			previous.showBack();
		});
	 
	 

	 
	 for (Voiture voiture : lst) {
			add(addItem(voiture));
		
		}
}

public Container addItem(Voiture v) {
	 Container  holder=new Container(BoxLayout.x());
	 Container  holderdetails=new Container(BoxLayout.y());
		Label lb1=new Label(v.getMarque());
		Label lb2=new Label(v.getModele());
		Label lb3=new Label(String.valueOf(v.getPrix()));
		holderdetails.addAll(lb1,lb2,lb3);
		
		EncodedImage im=EncodedImage.createFromImage(MyApplication.theme.getImage("load.jpg"), false);
		Image img=URLImage.createToStorage(im, "voiture_"+v.getMarque(), v.getImage(),URLImage.RESIZE_SCALE);
		 ImageViewer img2= new ImageViewer(img);

			holder.addAll(img2,holderdetails);
			
			lb1.addPointerReleasedListener(l->{
				if(	Dialog.show("Confirmation", "voulez vous supprimer le modele"+v.getModele()+" de la liste de favoris", "OUI",
							   "NON")) {
					voitureService.deleteVoiture(v);
					
					MesFavoris mesFavoris=new MesFavoris(this);
					mesFavoris.show();
				}
				});
			holder.setLeadComponent(lb1);
				return holder;
	 
}
}
