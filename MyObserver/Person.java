import java.util.Observable;  
import java.util.Observer;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
  
public class Person
extends JPanel 
   implements Observer
{  
  
   private JLabel amountLabel;
   private static String amountString = "Name: ";
   private JFormattedTextField amountField;
   String mName;
         
   public Person()
   {  
      super(new BorderLayout());
      amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue(" ");
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);
      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);
      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);
      
      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(labelPane, BorderLayout.CENTER);
      add(fieldPane, BorderLayout.LINE_END);
      
      JFrame frame = new JFrame("Observer");
      // frame.add(new Person());
      frame.getContentPane().add(BorderLayout.CENTER, labelPane);
      frame.getContentPane().add(BorderLayout.LINE_END, fieldPane);
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }  
  

   public void update(Observable arg0, Object arg1)
   {
       System.out.println("here");
      amountField.setValue(arg1);      
   }  
  
}
