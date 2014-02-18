import java.util.Observable;  
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class Form
extends JPanel 
   implements Observer
{  

    /**
    * the name of window
    */
   String mType;

    /**
    * Text field and button
    */
   private JLabel amountLabel;
   private static String amountString = "Name: ";
   private JFormattedTextField amountField;

   private JLabel BdayLabel;
   private static String Label = "Birthday: ";
   private JFormattedTextField Field;

    /**
    * Name of the window
    */
   String mName;

    /**
    * The position of the window when it first opens
    */
   private static int xPos = 200;
   private static int yPos = 200;


    /**
    * Constructor
    * setting up the window
    */
   public Form(String Type)
   {
     
      super(new BorderLayout());
      amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue("");
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);

      //
      BdayLabel = new JLabel(Label);
      Field = new JFormattedTextField();
      Field.setValue("");
      Field.setColumns(10);
      BdayLabel.setLabelFor(Field);
      
      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);
      labelPane.add(BdayLabel);
      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);
      fieldPane.add(Field);
      
      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(labelPane, BorderLayout.CENTER);
      add(fieldPane, BorderLayout.LINE_END);

      
      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(labelPane, BorderLayout.CENTER);
      add(fieldPane, BorderLayout.LINE_END);

       mType = Type;
      JFrame frame = new JFrame(mType);
     
      frame.getContentPane().add(BorderLayout.CENTER, labelPane);
      frame.getContentPane().add(BorderLayout.LINE_END, fieldPane);
      frame.pack();
      frame.setLocation(xPos, yPos); yPos += 100;
      frame.setVisible(true);
   }  

    /**
     * update the text field when the Observer class is updated
     */
   public void update(Observable arg0, Object arg1)
   {
      if ( arg0 instanceof Info)
      {
         amountField.setValue(arg1);
      }
      else
      {
         Field.setValue(arg1);
      }
   }

   
}
