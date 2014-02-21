import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class newWindow
   extends JFrame
   implements ItemListener
{
   public JCheckBox mCheck;
   
   public newWindow()
   {
      super("Border Layout Demo");
      setFont(new Font("Arial",1,20));
      setLayout(new BorderLayout());

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      /*
      JPanel background  = new JPanel();
      getContentPane().add(background);
      background.setSize(200,200);
      background.setVisible(true);
      //background.
      */
   
      
      mCheck = new JCheckBox("Goes to 11");
      mCheck.addItemListener(this);
      
      
      getContentPane().setBackground(Color.black);
      
      //getContentPane().add(BorderLayout.CENTER, mCheck);
      //mCheck.setOpaque(true);
      
      setSize(200,200);   
      setVisible(true);
      
   }
   
   public void itemStateChanged(ItemEvent ev)
   {
      String onOrOff = "off";
      if (mCheck.isSelected())
      {
       getContentPane().setBackground(Color.red);  
      }
          
   }
}