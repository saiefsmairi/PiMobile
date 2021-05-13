package Forms;

import com.codename1.ui.Form;

import com.codename1.charts.ChartComponent;
import com.codename1.charts.models.XYMultipleSeriesDataset;
import com.codename1.charts.models.XYSeries;
import com.codename1.charts.renderers.XYMultipleSeriesRenderer;
import com.codename1.charts.renderers.XYSeriesRenderer;
import com.codename1.charts.views.CubicLineChart;
import com.codename1.charts.views.PointStyle;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.table.TableModel;
import com.codename1.ui.util.Resources;

import Service.ReservationService;
import entities.Reservation;

public class ResDetailV2 extends BaseForm {

	private Form current;
	public static Resources theme;

	public ResDetailV2(Resources theme1, int id, Reservation f, Form previous) {
		super("Détail de la réservation", BoxLayout.y());
		Reservation v = new Reservation();

		Toolbar tb = new Toolbar(true);
		theme1 = UIManager.initFirstTheme("/theme1");

		setToolbar(tb);
		getTitleArea().setUIID("Container");

		getContentPane().setScrollVisible(false);

		// super.addSideMenu(res);

		// tb.addSearchCommand(e -> {
		// });
		getToolbar().addCommandToOverflowMenu("delete", null, l -> {

			if (Dialog.show("Confirmation", "voulez vous supprimer cette réservation ?", "OUI", "NON")) {

				ReservationService.getInstance().deleteRes(id);
				theme = UIManager.initFirstTheme("/theme");

				new ListeReservationClient(null).show();
			}

		});
		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			previous.showBack();
		});

		Image img = theme1.getImage("resdetailbanner.jpg");
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

		v = ReservationService.getInstance().getAllTasks2(id, v);

		Label lb1 = new Label(v.getDate_debut());
		lb1.setUIID("TextFieldBlack");
		addStringValue("Date debut", lb1);

		Label lb2 = new Label(v.getDate_fin());
		lb2.setUIID("TextFieldBlack");
		addStringValue("Date fin", lb2);

		Label lb3 = new Label(v.getNb_adulte() + "");
		lb3.setUIID("TextFieldBlack");
		addStringValue("Nombre adultes", lb3);

		Label lb4 = new Label(v.getNb_enfants() + "");
		lb4.setUIID("TextFieldBlack");
		addStringValue("Nombre enfants", lb4);

		Label lb5 = new Label(v.getNbChambreSingleReserve() + "");
		lb5.setUIID("TextFieldBlack");
		addStringValue("Nombre Chambre single", lb5);

		Label lb6 = new Label(v.getNbChambreDoubleReserve() + "");
		lb6.setUIID("TextFieldBlack");
		addStringValue("Nombre Chambre double", lb6);

		Label lb7 = new Label(v.getType() + "");
		lb7.setUIID("TextFieldBlack");
		addStringValue("Type de la rés", lb7);

		Label lb8 = new Label(v.getPrix() + "");
		lb8.setUIID("TextFieldBlack");
		addStringValue("Prix", lb8);

	}

	private void addStringValue(String s, Component v) {
		add(BorderLayout.west(new Label(s, "PaddedLabel")).add(BorderLayout.CENTER, v));
		add(createLineSeparator(0xeeeeee));
	}
}
