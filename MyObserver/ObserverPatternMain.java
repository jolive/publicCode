import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ObserverPatternMain
   extends JPanel
   implements Runnable
{
   Product samsungMobile;
   String text;
   private JLabel amountLabel;
   private static String amountString = "Loan Amount: ";
   private JFormattedTextField amountField;

   
   public static void main(String[] args)
   {
      new ObserverPatternMain().run();
   }
   
   public void run()
   {
      createAndShowGUI();
      Person arpitPerson=new Person();         
      samsungMobile.registerObserver(arpitPerson);
      Person arpitPerson1=new Person();         
      samsungMobile.registerObserver(arpitPerson1);  
      
      text =  JOptionPane.showInputDialog(this ,"Enter your name:");
      samsungMobile.setAvailability(text);
      
                     
   }
   
   public ObserverPatternMain()
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
        
         
      samsungMobile=new Product("Samsung", "Mobile", "Not available");  
          
   }

   private static void createAndShowGUI()
   {
      //Create and set up the window.
      JFrame frame = new JFrame("FormattedTextFieldDemo");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
      //Add contents to the window.
      frame.add(new ObserverPatternMain());
 
      //Display the window.
      frame.pack();
      frame.setLocationRelativeTo(null);
      frame.setVisible(true);
   }
}  
