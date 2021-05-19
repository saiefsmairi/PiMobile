/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
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
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Facture;
import com.mycompany.services.ServiceFacture;


/**
 *
 * @author smp
 */
public class ModifierFactureForm extends BaseForm {
    Form current ;
    public ModifierFactureForm(Resources res, Facture f){
    
    super("Payment to update",BoxLayout.y());
     Toolbar tb = new Toolbar(true);
      current = this;
      setToolbar(tb);
      getTitleArea().setUIID("Container");
     // setTitle("Payment");
      getContentPane().setScrollVisible(false);
    
   //  super.addSideMenu(res);
     
     TextField identifiant = new TextField(f.getIdentifiant()," CIN " , 20 , TextField.ANY);
     TextField nom_prenom = new TextField(f.getNom_prenom()," Nom & prénom " , 20 , TextField.ANY);
     TextField montant = new TextField(f.getMontant()," Montant " , 20 , TextField.ANY);
     //TextField date_paiement = new TextField(f.getDate_paiement()," Date de paiement " , 20 , TextField.ANY);
     TextField devise = new TextField(f.getDevise()," Devise " , 20 , TextField.ANY);
     ComboBox deviseCombo = new ComboBox();
     deviseCombo.addItem("Euro £");
     deviseCombo.addItem("TND");
     deviseCombo.addItem("USD $");
     deviseCombo.addItem("Dinnars Algérien");
     deviseCombo.addItem("Dirham Marrocain");
     deviseCombo.addItem("Dollars $ Américain");
     
     
     TextField moyen_paiement = new TextField(f.getMoyen_paiement()," Moyen de paiement " , 20 , TextField.ANY);
     TextField mode_paiement = new TextField(f.getMode_paiement()," Mode de paiement " , 20 , TextField.ANY);
     TextField pays = new TextField(f.getPays()," Pays " , 20 , TextField.ANY);
     
     identifiant.setSingleLineTextArea(true);
     nom_prenom.setSingleLineTextArea(true);
     montant.setSingleLineTextArea(true);
     //date_paiement.setSingleLineTextArea(true);
     devise.setSingleLineTextArea(true);
     moyen_paiement.setSingleLineTextArea(true);
     mode_paiement.setSingleLineTextArea(true);
     pays.setSingleLineTextArea(true);
     
     
     Button btnModifier = new Button ("Modifier");
     btnModifier.setUIID("Button");
     
     btnModifier.addPointerPressedListener(l->{
    f.setIdentifiant(identifiant.getText());
    f.setNom_prenom(nom_prenom.getText());
    f.setMontant(montant.getText());
   // f.setDate_paiement(date_paiement.getText());
    //f.setDevise(devise.getText());
    if (deviseCombo.getSelectedIndex()==0)
    {f.setDevise("Euro £");}
    else if (deviseCombo.getSelectedIndex()==1)
    {f.setDevise("TND");}
    else if (deviseCombo.getSelectedIndex()==2)
    {f.setDevise("USD $");}
    else if (deviseCombo.getSelectedIndex()==3)
    {f.setDevise("Dinnars Agérien");}
     else if (deviseCombo.getSelectedIndex()==4)
    {f.setDevise("Dirham marrocain");}
    else {f.setDevise("Dollars $ Américain");}
    
    f.setMoyen_paiement(moyen_paiement.getText());
    f.setMode_paiement(mode_paiement.getText());
    f.setPays(pays.getText());
    
    
    //});
     
     if(ServiceFacture.getInstance().modifierFacture(f,f.getId()))
     
     { new ListFactureForm(res).show();}
     });
     Button btnAnnuler = new Button();
     btnAnnuler.addActionListener(e -> {
     
     new ListFactureForm(res).show();
     
     });
     
     
    Label l1 = new Label();      
    Label l2 = new Label("");     
     
     Container content = BoxLayout.encloseY(
    
    l1,l2,
    new FloatingHint(identifiant),
    createLineSeparator(),
    new FloatingHint(nom_prenom),
    createLineSeparator(),
    new FloatingHint(montant),
    createLineSeparator(),
//    new FloatingHint(date_paiement),
    createLineSeparator(),
    deviseCombo,
    createLineSeparator(),
    new FloatingHint(moyen_paiement),
    createLineSeparator(),
    new FloatingHint(mode_paiement),
    createLineSeparator(),
    new FloatingHint(pays),
    btnModifier,btnAnnuler
    
     );
     add(BoxLayout.encloseY(new Label(res.getImage("nfc-payment-flat-concept-vector-2365000.jpg"),"LogoLabel")));
//      Image img1 = res.getImage("e-wallet-technology-payment-concept-with-team-people_25147-208.jpg");
//        if(img1.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
//            img1 = img1.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
//        }
//        ScaleImageLabel s2 = new ScaleImageLabel(img1);
//        s2.setUIID("BottomPad");
//        s2.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
     Label lreturn = new Label(" ");
        lreturn.setUIID("NewsTopLine");
        Style returnStyle = new Style(lreturn.getUnselectedStyle());
        
        returnStyle.setFgColor(0xf21f1f);
        FontImage returnImage = FontImage.createMaterial(FontImage.MATERIAL_BACKUP, returnStyle);
        lreturn.setIcon(returnImage);
        lreturn.setTextPosition(RIGHT);
       // click delete icon
       lreturn.addPointerPressedListener(l ->{
      new dashboard(res).show();
    
    });
       add(lreturn);
       Image img = res.getImage("images.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        //add(sl);
        
        add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(content
                            
                    )
                )
        ));
        
        
        
        //add(BoxLayout.encloseY(new Label(res.getImage("e-wallet-technology-payment-concept-with-team-people_25147-208.jpg"),"LogoLabel"),new Label("Payment update!","LogoLabel")));
     //add(content);
     show();
    }
   
}
