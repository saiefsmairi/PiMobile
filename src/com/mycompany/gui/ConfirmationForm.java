/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ButtonGroup;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
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

/**
 *
 * @author smp
 */
public class ConfirmationForm extends BaseForm {
    Form current;
     
       
    
    
    
    public ConfirmationForm (Resources res)
    {      Label lreturn = new Label(" ");
        lreturn.setUIID("NewsTopLine");
        Style returnStyle = new Style(lreturn.getUnselectedStyle());
        
        returnStyle.setFgColor(0xf21f1f);
        FontImage returnImage = FontImage.createMaterial(FontImage.MATERIAL_BACKUP, returnStyle);
        lreturn.setIcon(returnImage);
        lreturn.setTextPosition(RIGHT);
       // click delete icon
       lreturn.addPointerPressedListener(l ->{
      new Home(res).show();
    
    });
       add(lreturn); 
        Image img = res.getImage("nouveau-fond-degrade-flou-pastel-doux_92086-57.jpg");
        if(img.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
            img = img.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
        ScaleImageLabel sl = new ScaleImageLabel(img);
        sl.setUIID("BottomPad");
        sl.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
        //add(sl);
        Label d=new Label(res.getImage("nfc-payment-flat-concept-vector-2365000.jpg"));
        Label b=new Label(" well done ! Check ur phone");
      //Label d1=new Label(res.getImage("marketing-SMS-1-sh.jpg"));
        
        //add(BoxLayout.encloseY(new Label(res.getImage("e-wallet-technology-payment-concept-with-team-people_25147-208.jpg"),"LogoLabel"),new Label("Payment update!","LogoLabel")));
       b.getStyle().setFgColor(0x1e3642);
        Font smallPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_LARGE);
        b.getStyle().setFont(smallPlainSystemFont);
         add(LayeredLayout.encloseIn(
                sl,
                BorderLayout.south(
                    GridLayout.encloseIn(d,b
                            
                    )
                )
        ));
//      Image img1 = res.getImage("e-wallet-technology-payment-concept-with-team-people_25147-208.jpg");
//        if(img1.getHeight() > Display.getInstance().getDisplayHeight() / 3) {
//            img1 = img1.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
//        }
//        ScaleImageLabel s2 = new ScaleImageLabel(img1);
//        s2.setUIID("BottomPad");
//        s2.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
     
      /* Image img = res.getImage("nouveau-fond-degrade-flou-pastel-doux_92086-57.jpg");
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
                    GridLayout.encloseIn(
                            
                    )
                )
        ));*/

    
}
}