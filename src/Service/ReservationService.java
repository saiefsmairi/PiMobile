package Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;

import entities.Hotel;
import entities.Reservation;
import entities.Resstats;
import entities.Voyage;

public class ReservationService {
	public ArrayList<Reservation> tasks;
	public ArrayList<Resstats> tasksstats;

	public ArrayList<Hotel> hotels;
	public Reservation rforDetail;
	public Resstats stats;

	public Voyage vforDetail;
	public static ReservationService instance = null;
	public boolean resultOK;
	private ConnectionRequest req;
	
	public ReservationService() {
		req = new ConnectionRequest();

	}
	

	public static ReservationService getInstance() {
		if (instance == null) {
			instance = new ReservationService();
		}
		return instance;
	}
	
	public boolean addRes(Reservation t) {

		String url = "http://127.0.0.1:8000/reservation/wiw/addresapi?date_debut="+t.getDate_debut()+"&date_fin="+t.getDate_fin()+"&nbadultes="+t.getNb_adulte()+"&nbenfants="+t.getNb_enfants()+"&nbsingle="+t.getNbChambreSingleReserve()+"&nbdouble="+t.getNbChambreDoubleReserve()+"&voyage_id="+t.getVoyage_id();
		System.out.println(url);
		req.setUrl(url);// Insertion de l'URL de notre demande de connexion
		req.setHttpMethod("POST");

		NetworkManager.getInstance().addToQueueAndWait(req);
		return  req.getResponseCode() == 200;
	}
	
	public boolean addResHotel(Reservation t) {

		String url = "http://127.0.0.1:8000/reservation/wiw/resapi/hotel?date_debut="+t.getDate_debut()+"&date_fin="+t.getDate_fin()+"&nbadultes="+t.getNb_adulte()+"&nbenfants="+t.getNb_enfants()+"&nbsingle="+t.getNbChambreSingleReserve()+"&nbdouble="+t.getNbChambreDoubleReserve()+"&hotel_id="+t.getHotel_id();
		System.out.println(url);
		req.setUrl(url);// Insertion de l'URL de notre demande de connexion
		req.setHttpMethod("POST");

		NetworkManager.getInstance().addToQueueAndWait(req);
		return  req.getResponseCode() == 200;
	}
	public ArrayList<Reservation> parseTasks(String jsonText) {
		try {
			tasks = new ArrayList<>();
			JSONParser j = new JSONParser();

			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {
				Reservation t = new Reservation();
				float id = Float.parseFloat(obj.get("id").toString());
				t.setId((int) id);
				t.setDate_debut(((obj.get("date_debut").toString())));
				t.setDate_fin(obj.get("date_fin").toString());
				t.setType(obj.get("type").toString());
				float prix = Float.parseFloat(obj.get("prix").toString());
				t.setPrix((int) prix);
				tasks.add(t);
			}

		} catch (IOException ex) {

		}

		return tasks;
	}

	public ArrayList<Reservation> getAllTasks() {
		String url = "http://127.0.0.1:8000/reservation/wiw/api/listewiwapi";
		req.setUrl(url);
		req.setPost(false);
		 req.setHttpMethod("GET");
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				tasks = parseTasks(new String(req.getResponseData()));
				req.removeResponseListener(this);
				System.out.println( req.getResponseCode() );
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return tasks;
	}
	
	public ArrayList<Reservation> getAllTaskssearch(String id) {
		String url = "http://127.0.0.1:8000/reservation/wiw/api/listewiwapifilter?id="+id;

		req.setUrl(url);
		req.setPost(false);
		 req.setHttpMethod("GET");
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				tasks = parseTasks(new String(req.getResponseData()));
				req.removeResponseListener(this);
				System.out.println( req.getResponseCode() );
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return tasks;
	}
///////////detail res 
	public Reservation parseTasks2(String jsonText) {
		Reservation t = new Reservation();

		try {
			JSONParser j = new JSONParser();

			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {

				float id = Float.parseFloat(obj.get("id").toString());
				t.setId((int) id);
				t.setDate_debut(((obj.get("date_debut").toString())));
				t.setDate_fin(obj.get("date_fin").toString());
				t.setType(obj.get("type").toString());
				float prix = Float.parseFloat(obj.get("prix").toString());
				t.setPrix((int) prix);
				float single = Float.parseFloat(obj.get("NbChambreSingleReserve").toString());
				t.setNbChambreSingleReserve((int) single);
				float doublech = Float.parseFloat(obj.get("nbChambreDoubleReserve").toString());
				t.setNbChambreDoubleReserve((int) doublech);
				float enfants = Float.parseFloat(obj.get("nb_enfants").toString());
				t.setNb_enfants((int) enfants);
				float adulte = Float.parseFloat(obj.get("nb_adulte").toString());
				t.setNb_adulte((int) adulte);

			}

		} catch (IOException ex) {

		}

		return t;
	}

	public Reservation getAllTasks2(int id, Reservation v) {

		String url = "http://127.0.0.1:8000/reservation/wiw/api/detailresapi?id=" + id;
		req.setUrl(url);
		req.setPost(false);
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				rforDetail = parseTasks2(new String(req.getResponseData()));

				req.removeResponseListener(this);
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return rforDetail;
	}
	
	
	
	
	
///////////stats res 




public ArrayList<Resstats> parseTasks3(String jsonText) {
		try {
			tasksstats= new ArrayList<>();
			JSONParser j = new JSONParser();

			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {
					Resstats t = new Resstats();
				float nb = Float.parseFloat(obj.get("nbres").toString());
			t.setNbres((int) nb);
			t.setNomh(((obj.get("nomHotel").toString())));
				tasksstats.add(t);
			}

		} catch (IOException ex) {

		}

		return tasksstats;
	}

public ArrayList<Resstats> getAllTasks3() {

	String url = "http://127.0.0.1:8000/reservation/wiw/api/stats";
	req.setUrl(url);
	req.setPost(false);
	req.addResponseListener(new ActionListener<NetworkEvent>() {
		@Override
		public void actionPerformed(NetworkEvent evt) {
			tasksstats = parseTasks3(new String(req.getResponseData()));

			req.removeResponseListener(this);
		}
	});
	NetworkManager.getInstance().addToQueueAndWait(req);
	return tasksstats;
}

	
	
	
	
	public boolean deleteRes(int id) {
		String url = "http://127.0.0.1:8000/reservation/wiw/api/delres?id=" + id;
		System.out.println(url);
		req.setUrl(url);// Insertion de l'URL de notre demande de connexion

		req.setHttpMethod("DELETE");
		NetworkManager.getInstance().addToQueueAndWait(req);
		return resultOK;
	}

}
