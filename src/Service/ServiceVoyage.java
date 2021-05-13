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
import entities.Place;
import entities.Reservation;
import entities.Voiture;
import entities.Voyage;

public class ServiceVoyage {
	public ArrayList<Voyage> tasks;
	public ArrayList<Hotel> hotels;

	public Voyage vforDetail;
	public static ServiceVoyage instance = null;
	public boolean resultOK;
	private ConnectionRequest req;

	private ServiceVoyage() {
		req = new ConnectionRequest();
	}

	public static ServiceVoyage getInstance() {
		if (instance == null) {
			instance = new ServiceVoyage();
		}
		return instance;
	}


	public ArrayList<Voyage> getAllTaskssearch(String id) {
		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/voyagefilter?id="+id;

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
	
	
	public boolean deletevoyage(int id) {
		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/delvoyage?id=" + id;
		System.out.println(url);
		req.setUrl(url);// Insertion de l'URL de notre demande de connexion

		req.setHttpMethod("DELETE");
		NetworkManager.getInstance().addToQueueAndWait(req);
		return resultOK;
	}

	public boolean addVoyage(Voyage t,Place p) {

		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/addvoyage?nom=" + t.getNom() + "&ville="
				+ t.getVille() + "&description=" + t.getDescription() + "&date_debut=" + t.getDate_debut()
				+ "&date_fin=" + t.getDate_fin() + "&prix_personne=" + t.getPrix_personne() + "&nb_personne="
				+ t.getNb_personne() + "&image=null"+"&hotel_id="+t.getIdHotel()+"&place="+p.getNom()+"&longtitude="+p.getLongitude()+"&alt="+p.getAltitude();
		System.out.println(url);
		req.setUrl(url);// Insertion de l'URL de notre demande de connexion
		req.setHttpMethod("POST");

		NetworkManager.getInstance().addToQueueAndWait(req);
		return  req.getResponseCode() == 200;
	}

	public Voyage DetailVoyage(int id, Voyage t) {
		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/detailvoyage?id=" + id;
		req.setUrl(url);
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				JSONParser jsonp = new JSONParser();
				System.out.println(req.getResponseData());
				try {
					Map<String, Object> obj = jsonp
							.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
					float id = Float.parseFloat(obj.get("id").toString());
					t.setId((int) id);
					t.setDate_debut(((obj.get("date_debut").toString())));
					t.setDate_fin(obj.get("date_fin").toString());
					t.setNom(obj.get("nom").toString());
					float prix = Float.parseFloat(obj.get("id").toString());
					t.setPrix_personne((int) prix);
				} catch (IOException ex) {
					System.out.println("erreur fi detail voyage" + ex.getMessage());
				}

			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return t;
	}

	public ArrayList<Voyage> parseTasks(String jsonText) {
		try {
			tasks = new ArrayList<>();
			JSONParser j = new JSONParser();

			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {
				Voyage t = new Voyage();
				float id = Float.parseFloat(obj.get("id").toString());
				t.setId((int) id);
				t.setDate_debut(((obj.get("date_debut").toString())));
				t.setDate_fin(obj.get("date_fin").toString());
				t.setNom(obj.get("nom").toString());
				t.setVille(obj.get("ville").toString());
				float prix = Float.parseFloat(obj.get("id").toString());
				t.setPrix_personne((int) prix);
				tasks.add(t);
			}

		} catch (IOException ex) {

		}

		return tasks;
	}

	public ArrayList<Voyage> getAllTasks() {
		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/liste/voy";
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

	public Voyage parseTasks2(String jsonText) {
		Voyage t = new Voyage();

		try {
			JSONParser j = new JSONParser();

			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {

				float id = Float.parseFloat(obj.get("id").toString());
				t.setId((int) id);
				t.setDate_debut(((obj.get("date_debut").toString())));
				t.setDate_fin(obj.get("date_fin").toString());
				t.setNom(obj.get("nom").toString());
				t.setVille(obj.get("ville").toString());
				t.setDescription(obj.get("description").toString());
				float nbpersonne = Float.parseFloat(obj.get("nb_personne").toString());
				t.setNb_personne((int) nbpersonne);
				float prix = Float.parseFloat(obj.get("prix_personne").toString());
				t.setPrix_personne((int) prix);

			}

		} catch (IOException ex) {

		}

		return t;
	}

	public Voyage getAllTasks2(int id, Voyage v) {

		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/detailvoyage?id=" + id;
		req.setUrl(url);
		req.setPost(false);
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				vforDetail = parseTasks2(new String(req.getResponseData()));

				req.removeResponseListener(this);
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return vforDetail;
	}

	//////////////////////////////// HOTELSSSSSSSS//////////////////
	public ArrayList<Hotel> parseHotel(String jsonText) {
		try {
			hotels = new ArrayList<>();
			JSONParser j = new JSONParser();
			Map<String, Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
			List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");

			for (Map<String, Object> obj : list) {
				Hotel t = new Hotel();
				float id = Float.parseFloat(obj.get("id").toString());
				t.setId((int) id);

				t.setName(obj.get("name").toString());

				hotels.add(t);
			}

		} catch (IOException ex) {

		}

		return hotels;
	}

	public ArrayList<Hotel> getAllHotels() {
		String url = "http://127.0.0.1:8000/dashboard/gestion/voyage/api/liste/hotels";
		req.setUrl(url);
		req.setPost(false);
		req.addResponseListener(new ActionListener<NetworkEvent>() {
			@Override
			public void actionPerformed(NetworkEvent evt) {
				hotels = parseHotel(new String(req.getResponseData()));
				req.removeResponseListener(this);
			}
		});
		NetworkManager.getInstance().addToQueueAndWait(req);
		return hotels;
	}

	
	
}
