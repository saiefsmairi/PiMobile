/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.properties.UiBinding.DateConverter;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entities.Facture;
import com.mycompany.utils.Statics;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author smp
 */
public class ServiceFacture {
    public static ServiceFacture instance = null;
    public static boolean  resultOK = true;
    
    private ConnectionRequest req;
    
    public static ServiceFacture getInstance()
    { if(instance == null)
        instance = new ServiceFacture();
    return instance;
    }
    
    public ServiceFacture()
    { req = new ConnectionRequest();
    }
    //ajout
    public void ajouterFacture(Facture facture)
            //+"&nom_prenom="+facture.getNom_prenom()+"&montant="facture.getMontant()+"&date_paiement="+facture.getDate_paiement()+"&devise="+facture.getDevise()+"&moyen_paiement="+facture.getMoyen_paiement()+"&mode_paiement="+facture.getMode_paiement()+"&location="+facture.getLocation()+"&pays="+facture.getPays()+"&enabled="+facture.isEnabled()+"&color="+facture.getColor();
    { String url =Statics.BASE_URL+"/FactureajoutJSON/new/?identifiant="+facture.getIdentifiant()+"&nom_prenom="+facture.getNom_prenom()+"&montant="+facture.getMontant()+"&devise="+facture.getDevise()+"&moyen_paiement="+facture.getMoyen_paiement()+"&mode_paiement="+facture.getMode_paiement()+"&location="+facture.getLocation()+"&pays="+facture.getPays()+"&color="+facture.getColor();
    req.setUrl(url);
    req.addResponseListener((e)-> {
        String str = new String(req.getResponseData());
        System.out.println("data == "+str);
    });
    NetworkManager.getInstance().addToQueueAndWait(req);
}
    
    //affichage
    public ArrayList<Facture> affichageFacture()
    {
      ArrayList<Facture> result = new ArrayList<>();
      String url= Statics.BASE_URL+"/dashboard/displayFactureJson";
      req.setUrl(url);
      req.addResponseListener(new ActionListener<NetworkEvent>()
      {
          @Override
          public void actionPerformed(NetworkEvent evt) {
             JSONParser jsonp ;
             jsonp = new JSONParser();
             
             try {
             Map<String,Object> mapFacture = jsonp.parseJSON(new CharArrayReader(new String (req.getResponseData()).toCharArray()));
             List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapFacture.get("root");
             for(Map<String, Object> obj : listOfMaps)
                 {
                 Facture fact = new Facture();
                 
                 
                 
                 float id = Float.parseFloat(obj.get("id").toString());
                 String identifiant = (String) obj.get("identifiant");
                 String nom_prenom = (String) obj.get("nom_prenom");
                 String montant = (String) obj.get("montant");
                 
                
                 //Date date_paiement = (Date) obj.get("date_paiement");
                
                 
                 
               /*  String DateConverter = obj.get("date_paiement").toString().substring(obj.get("date_paiement").toString().indexOf("timestamp") + 10 , obj.get("date_paiement").toString().lastIndexOf(")"));
                 Date currenTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
                 
                 
                 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); 
                 String dateString = formatter.format(currenTime);*/
                 //fact.setDate_paiement(dateString);
                 
       
                 
          
                 
                 String devise = (String) obj.get("devise");
                 String moyen_paiement = (String) obj.get("moyen_paiement");
                 String mode_paiement = (String) obj.get("mode_paiement");
                // String location = (String) obj.get("location");
                 String pays = (String) obj.get("pays");
                 //boolean enabled = (boolean) obj.get("enabled");
                 //String color = (String) obj.get("color");
              
                fact.setId((int) id);
                fact.setIdentifiant(identifiant);
                fact.setNom_prenom(nom_prenom);
                fact.setMontant(montant);
               // fact.setDate_paiement(dateString);
                fact.setDevise(devise);
                fact.setMoyen_paiement(moyen_paiement);
                fact.setMode_paiement(mode_paiement);
                //fact.setLocation(location);
                fact.setPays(pays);
                //fact.setEnabled(enabled);
               // fact.setColor(color);
                
                //insert data into ArrayList result
                result.add(fact);
                 }
             }catch(Exception ex){
             
             ex.printStackTrace();
             
             
             }
             
             
          }
      });
      
      
      NetworkManager.getInstance().addToQueueAndWait(req);
      return result;
    }
    
    public boolean deleteFacture(int id)
    {    
     
    //String url=Statics.BASE_URL.+"/deleteFactureJson/"+id;
    String url=Statics.BASE_URL +"/dashboard/deleteFactureJson?id="+id;
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>() { 
        @Override
        public void actionPerformed(NetworkEvent evt) {
         req.removeResponseListener(this);
        }
    
    
    
    }
    
    );
    
    
    NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
    }
    
    
    public boolean modifierFacture(Facture facture,int id){
//        ?identifiant="+facture.getIdentifiant()+"&nom_prenom="+facture.getNom_prenom()+"&montant="+facture.getMontant()+"&date_paiement="+facture.getDate_paiement()+"&devise="+facture.getDevise()+"&moyen_paiement="+facture.getMoyen_paiement()+"&mode_paiement="+facture.getMode_paiement()+"&location="+facture.getLocation()+"&pays="+facture.getPays()+"&color="+facture.getColor();

    String url=Statics.BASE_URL +"/updateFacture/"+id+"?identifiant="+facture.getIdentifiant()+"&nom_prenom="+facture.getNom_prenom()+"&montant="+facture.getMontant()+"&date_paiement="+facture.getDate_paiement()+"&devise="+facture.getDevise()+"&moyen_paiement="+facture.getMoyen_paiement()+"&mode_paiement="+facture.getMode_paiement()+"&location="+facture.getLocation()+"&pays="+facture.getPays()+"&color="+facture.getColor();;
    req.setUrl(url);
    req.addResponseListener(new ActionListener<NetworkEvent>() { 
        @Override
        public void actionPerformed(NetworkEvent evt) {
         resultOK=req.getResponseCode() == 200;
         req.removeResponseListener(this);
        }
    
    
    
    }
    
    );
     NetworkManager.getInstance().addToQueueAndWait(req);
    return resultOK;
    }
    
    
    
    
    
    
    
    
}