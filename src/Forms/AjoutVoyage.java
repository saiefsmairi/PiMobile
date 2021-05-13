package Forms;

import static com.codename1.ui.CN.CENTER;

import java.util.ArrayList;
import java.util.List;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.spinner.DateSpinner;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;

import Service.ServiceVoyage;
import entities.ComboHotel;
import entities.Hotel;
import entities.Place;
import entities.Voyage;

public class AjoutVoyage extends BaseForm {
	int hotel_id;
String altitude;
String longti;
	public AjoutVoyage(Form previous) {

		this.setLayout(BoxLayout.y());
		Toolbar tb = new Toolbar(true);
		getTitleArea().setUIID("Container");
		setTitle("Ajout Voyage");
		getContentPane().setScrollVisible(false);
		List<Hotel> lst1 = ServiceVoyage.getInstance().getAllHotels();

		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			previous.showBack();
		});

		
		////res hotel mezelt
		TextField nom = new TextField("", "nom");
		nom.setUIID("TextFieldBlack");
		addString("nom", nom);
		TextField ville = new TextField("", " ville");
		ville.setUIID("TextFieldBlack");
		addString("ville", ville);

		TextField desc = new TextField("", " Description");
		desc.setUIID("TextFieldBlack");
		addString("Description", desc);

		TextField nbpers = new TextField("", " Nombre de personne");
		nbpers.setUIID("TextFieldBlack");
		addString("Nombre de personne", nbpers);

		TextField prixpers = new TextField("", " Prix Par Personne");
		prixpers.setUIID("TextFieldBlack");
		addString("Prix Par Personne", prixpers);

		TextField nomplace = new TextField("", " nom place ");
		nomplace.setUIID("TextFieldBlack");
		addString("Nom place", nomplace);

		

		Picker dd = new Picker();
		Picker df = new Picker();
		addString("date debut", dd);
		addString("date fin", df);

		Label s1 = new Label();
		Label s2 = new Label();

		Container cnt1 = new Container(new FlowLayout(CENTER, CENTER));

		Button add = new Button("Ajout Voyage");

		add.setUIID("btnajout");

		Label lb = new Label("date debut");
		Label lb2 = new Label("date fin");

		ComboBox cb1 = new ComboBox();
		cb1.addItem("---Choix Hotel---");

		for (Hotel h : lst1) {
			cb1.addItem(new ComboHotel(h.getName(), h.getId()));

		}

		cb1.addActionListener((l) -> {

		});

		add.addActionListener(l -> {
			Object item = cb1.getSelectedItem();
			int value = ((ComboHotel) item).getValue();
			hotel_id = value;

			InfiniteProgress ip = new InfiniteProgress();
			final Dialog idialog = ip.showInfiniteBlocking();
			Voyage v = new Voyage(nom.getText(), ville.getText(), desc.getText(), dd.getText(), df.getText(),
					Integer.parseInt(prixpers.getText()), Integer.parseInt(nbpers.getText()), hotel_id);


	for (Place pl : getPlacecords()) {
		if(pl.getNom().equals(nomplace.getText())) {
			altitude=pl.getAltitude();
			longti=pl.getLongitude();
		}
	}	
	Place p = new Place(longti,altitude,nomplace.getText());
	
			ServiceVoyage.getInstance().addVoyage(v,p);
			idialog.dispose();
			refreshTheme();
			new ListeVoyage(this).show();
		});
		this.addAll(cb1, add);
	}
	
	public static List<Place> getPlacecords(){
		List<Place>places=new ArrayList<>();
		
		places.add(new Place("2.287592","48.862725","paris"));
		places.add(new Place("12.4829321","41.8933203","rome"));
		places.add(new Place("-0.1276474","51.5073219","london"));
		places.add(new Place("4.8320114","45.7578137","lyon"));

		return places;
		
	}

	public void addString(String s, Component v) {
		add(BorderLayout.west(new Label(s, "FadedLabel")).add(BorderLayout.CENTER, v));
		add(createLineSeparator(0xeeeeee));

	}

}
