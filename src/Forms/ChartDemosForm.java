package Forms;
import com.codename1.io.Log;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Command;
import com.codename1.ui.Form;
import com.codename1.ui.List;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;

public class ChartDemosForm extends Form {
    
    
    boolean drawOnMutableImages;
    List formMenu;
    
    class ListOption {
        Class<AbstractDemoChart> chartClass;
        String name;
        
        ListOption(Class cls, String name){
            this.chartClass = cls;
            this.name = name;
        }
        
        public String toString(){
            return this.name;
        }
    }
    
    ListOption[] options = new ListOption[]{


        new ListOption(BudgetPieChart.class, "Nombre de rés pour les hotels"),


    };
    
    public ChartDemosForm(){
        super("Stats sur les Réservations");
		getToolbar().addCommandToOverflowMenu("retour", null, l -> {
			new Home().show();
		});
        
        formMenu = new List();
        for ( int i=0; i<options.length; i++){
            formMenu.addItem(options[i]);
        }
        
        formMenu.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent evt) {
               

                if ( ChartsInBoxLayout.class.equals(BudgetPieChart.class) ){
                    Form f = new ChartsInBoxLayout().getForm();
          
                    
                    f.getStyle().setBgColor(0x0);
                    f.getStyle().setBgTransparency(0xff);
                    int numComponents = f.getComponentCount();
                    for (int i=0; i<numComponents; i++) {
                        f.getComponentAt(i).getStyle().setBgColor(0x0);
                        f.getComponentAt(i).getStyle().setBgTransparency(0xff);
                    }
                    
                    f.show();
                    return;
                }
                try {
                    AbstractDemoChart demo = (AbstractDemoChart)BudgetPieChart.class.newInstance();
                    demo.setDrawOnMutableImage(drawOnMutableImages);
                    Form intent = demo.execute();
                    if ( "".equals(intent.getTitle())){
                        intent.setTitle(demo.getName());
                    }
                    Command cmd = new Command("Menu"){

                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            ChartDemosForm.this.showBack();
                        }
                        
                    };
                    intent.setBackCommand(cmd);
                    intent.getStyle().setBgColor(0x0);
                    intent.getStyle().setBgTransparency(0xff);
                    int numComponents = intent.getComponentCount();
                    for (int i=0; i<numComponents; i++) {
                        intent.getComponentAt(i).getStyle().setBgColor(0x0);
                        intent.getComponentAt(i).getStyle().setBgTransparency(0xff);
                    }
                    intent.show();
                } catch (InstantiationException ex) {
                    Log.e(ex);
                } catch (IllegalAccessException ex) {
                    Log.e(ex);
                }
            }
            
        });
        
        setLayout(new BorderLayout());
        
        final CheckBox mutableImageCb = new CheckBox("Render on Mutable Image");
        mutableImageCb.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                drawOnMutableImages =  mutableImageCb.isSelected();
            }
            
        });
       // addComponent(BorderLayout.NORTH, mutableImageCb);
        addComponent(BorderLayout.CENTER, formMenu);
        
    }
    
    
    
}