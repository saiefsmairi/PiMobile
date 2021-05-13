package Forms;

import java.text.SimpleDateFormat;

import com.codename1.components.InfiniteProgress;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

import Service.ReservationService;
import Service.ServiceVoyage;
import entities.ComboHotel;
import entities.Reservation;
import entities.TwilioSMS;
import entities.Voyage;

public class ReservationVoyage extends BaseForm {
	public ReservationVoyage(Voyage v, Form previous) {
		this.setLayout(BoxLayout.y());
		Toolbar tb = new Toolbar(true);
		getTitleArea().setUIID("Container");
		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			previous.showBack();
		});
		setTitle("Réservé le voyage: " + v.getNom());
		getContentPane().setScrollVisible(false);
		TextField nbadultes = new TextField("", "entrer nbadultes");
		nbadultes.setUIID("TextFieldBlack");
		addString("nbadultes", nbadultes);

		TextField nbenfants = new TextField("", "entrer nbenfants");
		nbenfants.setUIID("TextFieldBlack");
		addString("nbenfants", nbenfants);

		TextField single = new TextField("", "entrer single");
		single.setUIID("TextFieldBlack");
		addString("single", single);

		TextField doublech = new TextField("", "entrer doublech");
		doublech.setUIID("TextFieldBlack");
		addString("doublech", doublech);

		Picker dd = new Picker();
		Picker df = new Picker();
		addString("date debut", dd);
		addString("date fin", df);
		Button add = new Button("Ajout Voyage");

		Button addresHotel = new Button("Ajout Reservation Hotel");

		addresHotel.addActionListener(l -> {
			Reservation r = new Reservation((new SimpleDateFormat("dd-MM-yyyy")).format(dd.getDate()),
					(new SimpleDateFormat("dd-MM-yyyy")).format(df.getDate()), Integer.parseInt(nbadultes.getText()),
					Integer.parseInt(nbenfants.getText()), Integer.parseInt(single.getText()),
					Integer.parseInt(doublech.getText()), 0, 0, 1);

			InfiniteProgress ip = new InfiniteProgress();
			final Dialog idialog = ip.showInfiniteBlocking();
			ReservationService.getInstance().addResHotel(r);

			idialog.dispose();
			refreshTheme();

			new ListeReservationClient(this).show();
		});

		add.setUIID("btnajout");

		add.addActionListener(l -> {
			Reservation r = new Reservation((new SimpleDateFormat("dd-MM-yyyy")).format(dd.getDate()),
					(new SimpleDateFormat("dd-MM-yyyy")).format(df.getDate()), Integer.parseInt(nbadultes.getText()),
					Integer.parseInt(nbenfants.getText()), Integer.parseInt(single.getText()),
					Integer.parseInt(doublech.getText()), v.getId(), 0);
			System.out.println(r);
			String datestring = (new SimpleDateFormat("dd-MM-yyyy")).format(dd.getDate());
			System.out.println(datestring);
			InfiniteProgress ip = new InfiniteProgress();
			final Dialog idialog = ip.showInfiniteBlocking();
			ReservationService.getInstance().addRes(r);
			TwilioSMS s=new TwilioSMS("ACb6f469cc427a1d8ecbfee4779793b6d5","096dce955f3e1835ce3535071179eab5","+13128152865");
s.sendSmsSync("+21629162035", "+13128152865", "test");
			idialog.dispose();
			refreshTheme();

			new ListeReservationClient(this).show();
		});
		this.addAll(add, addresHotel);
	}

	public void addString(String s, Component v) {
		add(BorderLayout.west(new Label(s, "FadedLabel")).add(BorderLayout.CENTER, v));
		add(createLineSeparator(0xeeeeee));

	}

}
