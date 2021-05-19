/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import static com.codename1.io.Log.e;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Facture;
import com.mycompany.services.ServiceFacture;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.factory.SmsFactory;


import static java.lang.String.valueOf;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;

/**
 *
 * @author smp
 */
public class AjoutFactureForm extends BaseForm{

    Form current;
     
       
//    Stripe.apiKey="sk_test_51IjNj7KWu4PpaPAOpRYkvkQcw80G0v6rdLPbUnFJWSUqykKoDnEbazZZxv4LL3QoGORielwKb7e18dK3IbkxMNRn00y6kMCk50";
    
    
    public AjoutFactureForm(Resources res)
    {
        super("Payment Online",BoxLayout.y());
        Stripe.apiKey="sk_test_51IjNj7KWu4PpaPAOpRYkvkQcw80G0v6rdLPbUnFJWSUqykKoDnEbazZZxv4LL3QoGORielwKb7e18dK3IbkxMNRn00y6kMCk50";
     Toolbar tb = new Toolbar(true);
      current = this;
      setToolbar(tb);
      getTitleArea().setUIID("Container");
     // setTitle("Payment");
      getContentPane().setScrollVisible(false);
       
        tb.addSearchCommand(e -> {
        
        });
        Tabs swipe = new Tabs();
        Label s1 = new Label();
        Label s2 = new Label();
        addTab(swipe,s1, res.getImage("pngtree-cartoon-business-wechat-payment-advertising-image_193850.jpg"),"","",res);
        
        
        //
        
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });

        Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("", barGroup);
        partage.setUIID("SelectBar");
        Label arrow = new Label(("    "), "Container");


        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
        
        //  ListReclamationForm a = new ListReclamationForm(res);
          //  a.show();
          
          
            refreshTheme();
        });

        add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });

        
        
        
        //
        
        
        
      TextField identifiant = new TextField("","enter your ID");
      identifiant.setUIID("TextFieldBlack");
      addStringValue("CIN / Passport number",identifiant);
      
      TextField nom_prenom = new TextField("","enter your fisrt & last name");
      nom_prenom.setUIID("TextFieldBlack");
      addStringValue("Last name & first name",nom_prenom);
    
      TextField montant = new TextField("","enter your ammount");
      montant.setUIID("TextFieldBlack");
      addStringValue("Mount",montant);
      
     /* TextField date_paiement = new TextField("","enter the payment date");
      date_paiement.setUIID("TextFieldBlack");
      addStringValue("Date de paiement",date_paiement);*/
      
      TextField devise = new TextField("","enter currency");
      devise.setUIID("TextFieldBlack");
      addStringValue("Currency",devise);
//      ComboBox deviseCombo = new ComboBox();
//     deviseCombo.addItem("Euro £");
//     deviseCombo.addItem("TND");
//     deviseCombo.addItem("USD $");
//     deviseCombo.addItem("Dinnars Algérien");
//     deviseCombo.addItem("Dirham Marrocain");
//     deviseCombo.addItem("Dollars $ Américain");
      TextField moyen_paiement = new TextField("","means of payment");
      moyen_paiement.setUIID("TextFieldBlack");
      addStringValue("Means of payment",moyen_paiement);
      
      TextField mode_paiement = new TextField(""," the payment way");
      mode_paiement.setUIID("TextFieldBlack");
      addStringValue("payment way",mode_paiement);
      
      /*TextField location = new TextField("","choose location");
      location.setUIID("TextFieldBlack");
      addStringValue("Location",location);
      */
      TextField pays = new TextField("","enter your country");
      pays.setUIID("TextFieldBlack");
      addStringValue("Country",pays);
      
     /* TextField enabled = new TextField("","Your Fact state!");
      enabled.setUIID("TextFieldBlack");
      addStringValue("Enabled",enabled);*/
      
      TextField color = new TextField("","if You need any help enter your Request message!");
      color.setUIID("TextFieldBlack");
      addStringValue("Contact",color);
      
      Button btnAjouter = new Button("Validate");
      addStringValue("",btnAjouter);
      
      //addAll(identifiant,nom_prenom,montant,date_paiement);
      
     
      //onclick button event
      
      
     btnAjouter.addActionListener((e)-> {
     
     try{
     //montant 
         if(identifiant.getText()=="" || nom_prenom.getText()=="" || montant.getText()=="" || devise.getText()=="" || moyen_paiement.getText()=="" || mode_paiement.getText()=="" )
         { Dialog.show("Check your data!","", "Cancel", "Ok");
         }
         else{
         InfiniteProgress ip = new InfiniteProgress(); //loading after insrt data
         final Dialog iDialog = ip.showInfiniteBlocking();
         //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
         Facture fact= new Facture(
         String.valueOf(identifiant.getText()).toString(),
         String.valueOf(nom_prenom.getText()).toString(),
         String.valueOf(montant.getText()).toString(),
//         format.format(new Date()),
        // String.valueOf(date_paiement.getText()).toString(),
         String.valueOf(devise.getText()).toString(),
         String.valueOf(moyen_paiement.getText()).toString(),
         String.valueOf(mode_paiement.getText()).toString(),
         //String.valueOf(location.getText()).toString(),
         String.valueOf(pays.getText()).toString(),
         false,
         String.valueOf(color.getText()).toString()
                 
         );
//         Facture fact= new Facture(
//         String.valueOf(identifiant.getText()).toString(),
//         String.valueOf(nom_prenom.getText()).toString(),
//         String.valueOf(montant.getText()).toString(),
////         format.format(new Date()),
//      
//         String.valueOf(devise.getText()).toString(),
//         String.valueOf(moyen_paiement.getText()).toString(),
//         String.valueOf(mode_paiement.getText()).toString(),
//         //String.valueOf(location.getText()).toString(),
//         String.valueOf(pays.getText()).toString()
//         
//                 
//         );
         System.out.println("data facture"+fact);
         
         ServiceFacture.getInstance().ajouterFacture(fact);
             
         iDialog.dispose();
      
        
         // une direction aprés l'ajout 
         //new ListFactureForm(res).show();
         
        Map <String,Object> Param = new HashMap<String,Object>();
        Param.put("amount","12000");
        Param.put("currency","usd");
        Param.put("customer", "cus_JMq7rJ8XF5zPcj");
        Charge charge= Charge.create(Param);
         TwilioRestClient client = new TwilioRestClient("AC9567a7216e930328b653d592b34f29b5","d2be7d8a195ea0e8b0abca051ea5a99c");
        com.twilio.sdk.resource.instance.Account account;
        account = client.getAccount();
        SmsFactory factory = account.getSmsFactory();
        HashMap<String, String> message = new HashMap<>();
        
        message.put("To","+21624335677");
        message.put("From","+19893037850");
        message.put("Body","Notification de paiement!");
        factory.create(message);
         new ConfirmationForm(res).show();
         refreshTheme();
         
         
         }
     }catch(Exception ex){
     ex.printStackTrace();}
         
         
         
     }
     );
      
      //addAll(identifiant,nom_prenom,montant,date_paiement,devise,moyen_paiement,mode_paiement,location,pays,color,btnAjouter);
    }
    
    
    

    public void addStringValue(String s, Component v ) {
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
        
        
       
    }

    private void addTab(Tabs swipe, Label spacer ,Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(),Display.getInstance().getDisplayHeight());
        if(image.getHeight() < size){ image = image.scaledHeight(size);}
        
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 2){
        image = image.scaledHeight(Display.getInstance().getDisplayWidth() / 2);}
        
        
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        Label overLay = new Label("","ImageOverlay");
        
        Container page1 = 
                LayeredLayout.encloseIn(
                imageScale,
                overLay,
                BorderLayout.south(
                BoxLayout.encloseY(
                new SpanLabel(text,"LargeWhiteText"),
                spacer
))
        );
        swipe.addTab("",res.getImage("pngtree-cartoon-business-wechat-payment-advertising-image_193850.jpg"),page1);
    }

    public void bindButtonSelection(Button btn , Label l){
        
        btn.addActionListener(e -> { if(btn.isSelected()){updateArrowPosition(btn,l);
        } 
        });
    }

    
    
    
//    private void updateArrowPosition(Button btn, Label l) {
//     l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);   
//     l.getParent().repaint();
//    }

    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);   
        l.getParent().repaint();
    }

    
}
