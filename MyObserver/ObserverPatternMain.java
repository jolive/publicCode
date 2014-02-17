import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ObserverPatternMain
   extends JFrame
   implements Runnable, ActionListener
{
    /**
    * set up a object which can be observed
    */
   Info autoFillName;
   Info2 autoFillBday;

    /**
    * variables which update the observers
    */
   String text;
   String Bday;
   int update;

    /**
    * Jlabel and Jtextfield
    */
   private JLabel amountLabel;
   private static String amountString = "Your Name: ";
   private JFormattedTextField amountField;
   JPanel panel;
   JButton button;

   private JLabel BdayLabel;
   private static String Label = "Your Birthday: ";
   private JFormattedTextField Field;
   JPanel panel1;
   JButton button1;


   /**
    * Main
    */
   public static void main(String[] args)
   {
      new ObserverPatternMain().run();
   }

   /**
    * Call two instances of Form and register then as Observers
    */
   public void run()
   {
      setVisible(true);
      Form social=new Form("Social Security");         
      autoFillName.registerObserver(social);
      Form marriage=new Form("Marriage Form");         
      // autoFillName.registerObserver(marriage);
      autoFillBday.registerObserver(marriage);
   }

   /**
    *Constructor
    * Call two instances of Form and register then as Observers
    */
   public ObserverPatternMain()
   {
      super("Formatted Text Demo");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      BdayLabel = new JLabel(Label);
      Field = new JFormattedTextField();
      Field.setValue(" ");
      Field.setColumns(10);
      BdayLabel.setLabelFor(Field);
      //JPanel labelPane1 = new JPanel(new GridLayout(0,1));
      //labelPane1.add(BdayLabel);
      //JPanel fieldPane1 = new JPanel(new GridLayout(0,1));
      //fieldPane1.add(Field);
     
      // panel1 = new JPanel(new BorderLayout());
      //panel1.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      JButton button1 = new JButton( new AbstractAction("Bday auto fill")
         {
            public void actionPerformed (ActionEvent e)
            {
               Bday = Field.getText();
               autoFillBday.setmName(Bday);
            }
         });
      // button1.addActionListener(this);

      //

       amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue(" ");
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);
      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);
      labelPane.add(BdayLabel);
      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);
      fieldPane.add(Field);

      JPanel Buttons = new JPanel(new GridLayout(0,1));
     
      panel = new JPanel(new BorderLayout());
      panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      button = new JButton("auto fill name");
      button.addActionListener(this);

      

      panel.add(labelPane, BorderLayout.CENTER);
      panel.add(fieldPane, BorderLayout.LINE_END);

      Buttons.add(button);
      Buttons.add(button1);

      panel.add(Buttons, BorderLayout.SOUTH);

      
      
      
      //  panel.add(labelPane1, BorderLayout.CENTER);
      //panel.add(fieldPane1, BorderLayout.LINE_END);
      
      // panel.add(button, BorderLayout.SOUTH);
      //panel.add(button1, BorderLayout.SOUTH);
      getContentPane().add(panel);
      pack();

      update = 0;
      autoFillName=new Info("Marriage Date", "Birthday", "John");
      autoFillBday = new Info2("Marriage Date", "Birthday", "John");
   }

    /**
    * action Performed Call if button is called
    * The text in the text field is sent to all observering objects 
    */
   public void actionPerformed(ActionEvent e)
   {
      text = amountField.getText();
      autoFillName.setmName(text);
   }

   /*
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
   */
}  
