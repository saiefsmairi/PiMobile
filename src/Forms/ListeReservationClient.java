package Forms;

import java.util.List;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.ComponentAnimation;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.test.MyApplication;

import Service.ReservationService;
import Service.ServiceVoyage;
import entities.Reservation;
import entities.Voyage;

public class ListeReservationClient extends BaseForm {

	ReservationService ress = new ReservationService();

	@SuppressWarnings("deprecation")
	public ListeReservationClient(Form pr) {

		this.setTitle("Mes Réservations");
		this.setLayout(BoxLayout.y());
///mezel detail voyage
		Toolbar.setGlobalToolbar(true);
		Style s = UIManager.getInstance().getComponentStyle("Title");

		TextField searchField = new TextField("", "Rechercher par type "); // <1>
		searchField.getHintLabel().setUIID("Title");
		searchField.setUIID("Title");
		searchField.getAllStyles().setAlignment(Component.LEFT);
		this.getToolbar().setTitleComponent(searchField);
		FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);
		searchField.addDataChangeListener((i1, i2) -> { // <2>
			String t = searchField.getText();
			if (t.length() < 1) {
				this.removeAll();
				List<Reservation> lst1 = ress.getInstance().getAllTasks();

				for (Reservation v : lst1) {

					add(addItem(v));

				}

			} else {
				System.out.println(t);

				t = t.toLowerCase();
				this.removeAll();

				List<Reservation> lst1 = ress.getInstance().getAllTaskssearch(t);

				for (Reservation v : lst1) {

					add(addItem(v));

				}

			}
			this.getContentPane().animateLayout(250);
		});
		this.getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
			searchField.startEditingAsync(); // <4>
		});

		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			new Home().show();
		});
		List<Reservation> lst1 = ress.getInstance().getAllTasks();

		for (Reservation v : lst1) {
			add(addItem(v));

		}

	}

	public Container addItem(Reservation v) {
		Container holder = new Container(BoxLayout.x());
		Container holderdetails = new Container(BoxLayout.y());
		Label lb1 = new Label(v.getDate_debut());
		Label lb2 = new Label(v.getDate_fin());
		Label lb3 = new Label(String.valueOf(v.getPrix()));
		Label lb4 = new Label(v.getType());

		lb1.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb2.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb3.setIcon(MyApplication.theme.getImage("money.png").scaled(100, 100));
		lb4.setIcon(MyApplication.theme.getImage("type.png").scaled(100, 100));

		holderdetails.addAll(lb1, lb2, lb3, lb4);

		holder.setUIID("holditem");

		// EncodedImage
		// im=EncodedImage.createFromImage(MyApplication.theme.getImage("load.jpg"),
		// false);
		// Image img=URLImage.createToStorage(im, "voiture_"+v.getMarque(),
		// v.getImage(),URLImage.RESIZE_SCALE);
		// ImageViewer img2= new ImageViewer(im);

		holder.addAll(holderdetails);

		lb1.addPointerReleasedListener(l -> {
			System.out.println(v.getId());

			new ResDetailV2(null, v.getId(), v, this).show();

			// new ReservationVoyage(v,this).show();
		});
		holder.setLeadComponent(lb1);
		return holder;

	}

	public Container addItem2(Reservation v) {
		Container holder = new Container(BoxLayout.x());
		Container holderdetails = new Container(BoxLayout.y());
		Label lb1 = new Label(v.getDate_debut());
		Label lb2 = new Label(v.getDate_fin());
		Label lb3 = new Label(String.valueOf(v.getPrix()));
		Label lb4 = new Label(v.getType());

		lb1.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb2.setIcon(MyApplication.theme.getImage("date.png").scaled(100, 100));
		lb3.setIcon(MyApplication.theme.getImage("money.png").scaled(100, 100));
		lb4.setIcon(MyApplication.theme.getImage("type.png").scaled(100, 100));

		holderdetails.addAll(lb1, lb2, lb3, lb4);

		holder.setUIID("holditem");

		// EncodedImage
		// im=EncodedImage.createFromImage(MyApplication.theme.getImage("load.jpg"),
		// false);
		// Image img=URLImage.createToStorage(im, "voiture_"+v.getMarque(),
		// v.getImage(),URLImage.RESIZE_SCALE);
		// ImageViewer img2= new ImageViewer(im);

		holder.addAll(holderdetails);

		lb1.addPointerReleasedListener(l -> {
			System.out.println(v.getId());

			new ResDetail(v.getId(), v, this).show();

			// new ReservationVoyage(v,this).show();
		});
		holder.setLeadComponent(lb1);
		return holder;

	}
}
