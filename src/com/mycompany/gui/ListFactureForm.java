/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.entities.Facture;

import com.mycompany.services.ServiceFacture;


import java.util.ArrayList;




/**
 *
 * @author smp
 */
public class ListFactureForm extends BaseForm {
    Form current;
    public ListFactureForm(Resources res)
    {
    super("Payment Details",BoxLayout.y());
     Toolbar tb = new Toolbar(true);
      current = this;
      setToolbar(tb);
      getTitleArea().setUIID("Container");
      setTitle("");
      getContentPane().setScrollVisible(false);
       
        tb.addSearchCommand(e -> {
        
        });
        Tabs swipe = new Tabs();
        Label s1 = new Label();
        Label s2 = new Label();
        addTab(swipe,s1, res.getImage("pngtree-blue-flat-business-man-financial-management-png-image_40176.jpg"),"","",res);
        
        
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
//        RadioButton mesListes = RadioButton.createToggle("Home", barGroup);
//        mesListes.setUIID("SelectBar");
//        RadioButton liste = RadioButton.createToggle("Réservation", barGroup);
//        liste.setUIID("SelectBar");
//        RadioButton partage = RadioButton.createToggle("Evenement", barGroup);
//        partage.setUIID("SelectBar");
        Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");


//        mesListes.addActionListener((e) -> {
//               InfiniteProgress ip = new InfiniteProgress();
//        final Dialog ipDlg = ip.showInifiniteBlocking();
//        
//        //  ListReclamationForm a = new ListReclamationForm(res);
//          //  a.show();
//            refreshTheme();
//        });

//        add(LayeredLayout.encloseIn(
//                GridLayout.encloseIn(3, mesListes, liste, partage),
//                FlowLayout.encloseBottom(arrow)
//        ));

//        partage.setSelected(true);
//        arrow.setVisible(false);
//        addShowListener(e -> {
//            arrow.setVisible(true);
//            updateArrowPosition(partage, arrow);
//        });
//        bindButtonSelection(mesListes, arrow);
//        bindButtonSelection(liste, arrow);
//        bindButtonSelection(partage, arrow);
        // special case for rotation
//        addOrientationListener(e -> {
//            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
//        });
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
      ArrayList<Facture>list = ServiceFacture.getInstance().affichageFacture();
for(Facture factt : list)
{   String urlImage="pngtree-blue-flat-business-man-financial-management-png-image_40176.jpg";
    Image placeHolder = Image.createImage(120, 90);
    EncodedImage enc = EncodedImage.createFromImage(placeHolder,false);
    URLImage urlim = URLImage.createToStorage(enc, urlImage, urlImage, URLImage.RESIZE_SCALE);

    addButton(factt,res);
   
    ScaleImageLabel image = new ScaleImageLabel(urlim);
    Container containerImg = new Container();
    image.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);




}
     
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
        swipe.addTab("",res.getImage("pngtree-blue-flat-business-man-financial-management-png-image_40176.jpg"),page1);
    }

    public void bindButtonSelection(Button btn , Label l){
        
        btn.addActionListener(e -> { if(btn.isSelected()){updateArrowPosition(btn,l);
        } 
        });
    }

    
    
    


    private void updateArrowPosition(Button btn, Label l) {
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth() / 2 - l.getWidth() / 2);   
        l.getParent().repaint();
    }


//Appel Affichage meth
   

//   ,String identifiant, String nom_prenom, String montant, String date_paiement, String devise, String moyen_paiement, String mode_paiement, String pays,

    private void addButton( Facture factt, Resources res) {
        int height = Display.getInstance().convertToPixels(11.5f);
        int width = Display.getInstance().convertToPixels(14f);
         //createLineSeparator();
        Label ta = new Label("CIN / Num de passport :" + factt.getIdentifiant(),"NewsTopLine");
        //Label NomTxt = new Label(" Nom & prenom :" + factt.getNom_prenom(),"NewsTopLine");
        Label ta1 = new Label("Montant Total :" + factt.getMontant(),"NewsTopLine");
        Label ta2 = new Label("Devise :" + factt.getDevise(),"NewsTopLine");
        Label ta3 = new Label("Pays :" + factt.getPays(),"NewsTopLine");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = dateFormat.format(factt.getDate_paiement());
        Label date = new Label("Date de paiement: " + strDate);
        date.getStyle().setFgColor(0x1e3642);
        Font smallPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL);
        date.getStyle().setFont(smallPlainSystemFont);
        ta.getStyle().setFgColor(0x1e3642);
        ta.getStyle().setFont(smallPlainSystemFont);
        ta1.getStyle().setFgColor(0x1e3642);
        ta1.getStyle().setFont(smallPlainSystemFont);
        ta2.getStyle().setFgColor(0x1e3642);
        ta2.getStyle().setFont(smallPlainSystemFont);
        ta3.getStyle().setFgColor(0x1e3642);
        ta3.getStyle().setFont(smallPlainSystemFont);
        
        createLineSeparator();
        add(BoxLayout.encloseY(ta,ta1,ta2,ta3));
        add(BorderLayout.center(date));    
        //supp
        Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprimerStyle = new Style(lSupprimer.getUnselectedStyle());
        
        supprimerStyle.setFgColor(0xf21f1f);
        FontImage supprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprimerStyle);
        lSupprimer.setIcon(supprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
       // click delete icon
       lSupprimer.addPointerPressedListener(l ->{
   Dialog dig = new Dialog("Suppression");
    if(dig.show("Suppression","Vous voulez supprimer cette facture ?","Annuler","Oui")){
    dig.dispose();
    }
    else{
    dig.dispose();
    if(ServiceFacture.getInstance().deleteFacture(factt.getId()))
    { new ListFactureForm(res).show();
    }
    }
    
    });
        
        
//        add(BoxLayout.encloseX(lSupprimer));
        
        
        
        //Update icon
        Label lModifier = new Label(" ");
        lModifier.setUIID("NewsTopLine");
        Style modifierStyle = new Style(lModifier.getUnselectedStyle());
        
        modifierStyle.setFgColor(0xf7ad02);
        FontImage modifierImage = FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, modifierStyle);
        lModifier.setIcon(modifierImage);
        lModifier.setTextPosition(LEFT);
        
        
       lModifier.addPointerPressedListener(l ->{
        // System.out.println("hello update");
       new ModifierFactureForm(res,factt).show();
         
    
    });
       
//        add(BoxLayout.encloseX(lModifier));
add(BoxLayout.encloseX(lModifier,lSupprimer));
    }
 

  
    


 






}
