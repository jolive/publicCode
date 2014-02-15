import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ObserverPatternMain
   extends JFrame
   implements Runnable, ActionListener
{
   Product autoFillName;
   String text;
   int update;
   private JLabel amountLabel;
   private static String amountString = "Your Name: ";
   private JFormattedTextField amountField;
   JPanel panel;
   JButton button;

   
   public static void main(String[] args)
   {
      // Thread t1 = new Thread(ObserverPatternMain);
      new ObserverPatternMain().run();
   }
   
   public void run()
   {
      setVisible(true);
      Person arpitPerson=new Person();         
      autoFillName.registerObserver(arpitPerson);
      Person arpitPerson1=new Person();         
      autoFillName.registerObserver(arpitPerson1);  
   }
   
   public ObserverPatternMain()
   {
      super("Formatted Text Demo");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue(" ");
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);
      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);
      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);
     
      panel = new JPanel(new BorderLayout());
      panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      button = new JButton("auto fill name");
      button.addActionListener(this);

      panel.add(labelPane, BorderLayout.CENTER);
      panel.add(fieldPane, BorderLayout.LINE_END);
      panel.add(button, BorderLayout.SOUTH);
      getContentPane().add(panel);
      pack();

      update = 0;
      autoFillName=new Product("Samsung", "Mobile", "Not available");       
   }
   
   public void actionPerformed(ActionEvent e)
   {
      text = amountField.getText();
      autoFillName.setAvailability(text);
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
