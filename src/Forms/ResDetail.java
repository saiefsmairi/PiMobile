package Forms;

import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.mycompany.myapp.test.MyApplication;

import Service.ReservationService;
import Service.ServiceVoyage;
import entities.Reservation;
import entities.Voyage;

public class ResDetail extends Form {
	
public ResDetail(int id,Reservation f,Form previous) {
	 this.setLayout( new BoxLayout(BoxLayout.X_AXIS));
	 Reservation v =new Reservation();
	this.setTitle("Detail du RésDetail du Rés");
	
	
	
	
	Toolbar.setGlobalToolbar(true);

	EncodedImage placeholder = EncodedImage.createFromImage(Image.createImage(this.getWidth(), this.getWidth() / 5, 0xffff0000), true);
	URLImage background = URLImage.createToStorage(placeholder, "400px-AGameOfThrodnes.jpg",
	        "https://image.freepik.com/free-vector/happy-tourists-choosing-hotel-booking-room-online-flat-illustration_74855-10811.jpg",URLImage.RESIZE_SCALE);
	background.fetch();
	Style stitle = this.getToolbar().getTitleComponent().getUnselectedStyle();
	stitle.setBgImage(background);
	stitle.getBgImage().fill(300, 300);
	stitle.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
	stitle.setPaddingUnit(Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS, Style.UNIT_TYPE_DIPS);
	stitle.setPaddingTop(15);
	stitle.setMarginLeft(10);



	

		 getToolbar().addCommandToOverflowMenu("delete",null,l->{
				if(	Dialog.show("Confirmation", "voulez vous supprimer cette réservation ?", "OUI",
						   "NON")) {

			ReservationService.getInstance().deleteRes(id);
			new ListeReservationClient(this).show();
				}

			});
		 getToolbar().addCommandToOverflowMenu("refresh",null,l->{
			});
		 
		 getToolbar().addCommandToOverflowMenu("retour",null,l->{
				previous.showBack();
			});
		 
	 v=ReservationService.getInstance().getAllTasks2(id, v);
	 System.out.println(v);
	 	Label lb1=new Label(v.getDate_debut());
	 	Label lb2=new Label(v.getDate_fin());
	 	Label lb3=new Label(v.getNb_adulte()+"");
	 	Label lb4=new Label(v.getNb_enfants()+"");
	 	Label lb5=new Label(v.getNbChambreSingleReserve()+"");
	 	Label lb6=new Label(v.getNbChambreDoubleReserve()+"");
	 	Label lb7=new Label(v.getType()+"");
	 	Label lb8=new Label(v.getPrix()+"");

		lb1.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb2.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb3.setIcon(MyApplication.theme.getImage("adult.jpg").scaled(100, 100));
		lb4.setIcon(MyApplication.theme.getImage("kids.png").scaled(100, 100));
		
		
		lb5.setIcon(MyApplication.theme.getImage("single.png").scaled(100, 100));
		lb6.setIcon(MyApplication.theme.getImage("double.png").scaled(100, 100));
		
		lb7.setIcon(MyApplication.theme.getImage("type.png").scaled(100, 100));
		lb8.setIcon(MyApplication.theme.getImage("money.png").scaled(100, 100));
		
		Container  holderdetails1=new Container(BoxLayout.y());
		Container  holderdetails2=new Container(BoxLayout.y());
		
		
		holderdetails1.addAll(lb1,lb5);
		holderdetails2.addAll(lb2,lb6);
		holderdetails1.addAll(lb3,lb7);
		holderdetails2.addAll(lb4,lb8);
		

		this.addAll(holderdetails1,holderdetails2);
}
}
