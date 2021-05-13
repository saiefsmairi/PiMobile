package Forms;

import com.codename1.components.ImageViewer;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.test.MyApplication;

import Service.ReservationService;
import Service.ServiceVoyage;
import entities.Voyage;

public class VoyageDetail extends BaseForm {

	private Form current;
	public static Resources theme;

	public VoyageDetail(int id, Voyage f, Form previous, Resources theme1) {
		this.setLayout(BoxLayout.y());
		Voyage v = new Voyage();
		this.setTitle("Detail du voyage");

		Toolbar tb = new Toolbar(true);
		theme1 = UIManager.initFirstTheme("/theme1");

		setToolbar(tb);
		getTitleArea().setUIID("Container");

		getContentPane().setScrollVisible(false);

		// super.addSideMenu(res);

		// tb.addSearchCommand(e -> {
		// });
		getToolbar().addCommandToOverflowMenu("delete", null, l -> {

			if (Dialog.show("Confirmation", "voulez vous supprimer ce voyage ?", "OUI", "NON")) {
				System.out.println(ServiceVoyage.getInstance().deletevoyage(id));
				ServiceVoyage.getInstance().deletevoyage(id);
				theme = UIManager.initFirstTheme("/theme");

				new ListeVoyage(this).show();
				
			}

		});
		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			previous.showBack();
		});

		Image img = theme1.getImage("travelbannermobile.jpg");
		if (img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
			img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
		}
		ScaleImageLabel sl = new ScaleImageLabel(img);
		sl.setUIID("BottomPad");
		sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

		Label facebook = new Label("786 followers", theme1.getImage("facebook-logo.png"), "BottomPad");
		Label twitter = new Label("486 followers", theme1.getImage("twitter-logo.png"), "BottomPad");
		facebook.setTextPosition(BOTTOM);
		twitter.setTextPosition(BOTTOM);

		add(LayeredLayout.encloseIn(sl, BorderLayout.south(GridLayout.encloseIn(3, facebook,

				twitter))));

		v = ServiceVoyage.getInstance().getAllTasks2(id, v);
		System.out.println(v);
		Label lb1 = new Label(v.getNom());
		lb1.setUIID("TextFieldBlack");
		addStringValue("getNom", lb1);
		
		Label lb2 = new Label(v.getVille());
		lb2.setUIID("TextFieldBlack");
		addStringValue("getNom", lb2);
		Label lb3 = new Label(v.getDescription());
		lb3.setUIID("TextFieldBlack");
		addStringValue("getDescription", lb3);
		Label lb4 = new Label(v.getDate_debut());
		lb4.setUIID("TextFieldBlack");
		addStringValue("getDate_debut", lb4);
		Label lb5 = new Label(v.getDate_fin());
		lb5.setUIID("TextFieldBlack");
		addStringValue("getDate_fin", lb5);
		Label lb6 = new Label(v.getNb_personne() + "");
		lb6.setUIID("TextFieldBlack");
		addStringValue("getNb_personne", lb6);
		Label lb7 = new Label(v.getPrix_personne() + "");
		lb7.setUIID("TextFieldBlack");
		addStringValue("getPrix_personne", lb7);
		


	}
	private void addStringValue(String s, Component v) {
		add(BorderLayout.west(new Label(s, "PaddedLabel")).add(BorderLayout.CENTER, v));
		add(createLineSeparator(0xeeeeee));
	}
}
