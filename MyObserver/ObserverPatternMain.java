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
      JButton button1 = new JButton( new AbstractAction("Bday auto fill")
         {
            public void actionPerformed (ActionEvent e)
            {
               Bday = Field.getText();
               autoFillBday.setmName(Bday);
            }
         });

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

      getContentPane().add(panel);
      pack();

      update = 0;
      autoFillName=new Info("John");
      autoFillBday = new Info2("John");
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
}  
