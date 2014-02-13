import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class BorderLayoutDemo
   extends JFrame
   implements ItemListener
{
   public static void main(String[] args)
   {
      new BorderLayoutDemo().setVisible(true);
      
   }

   JCheckBox mCheck;
   
   public BorderLayoutDemo()
   {
      super("Border Layout Demo");
      setFont(new Font("Arial",1,20));
      setLayout(new BorderLayout());

     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      /*
      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
            {
               System.exit(0);
            }
         });
      */
      
      //JFrame frame = new JFrame();
      
      JButton east = new JButton("East");
      JButton west = new JButton("West");
      JButton south = new JButton("South");
      JButton north = new JButton("North");
      JButton center = new JButton("Center");
      
      mCheck = new JCheckBox("Goes to 11");
      mCheck.addItemListener(this);
          


      getContentPane().add(BorderLayout.EAST, east);
      getContentPane().add(BorderLayout.WEST, west);
      getContentPane().add(BorderLayout.SOUTH, south);
      getContentPane().add(BorderLayout.NORTH, north);
      getContentPane().add(BorderLayout.CENTER, mCheck);

      
      setSize(300,300);
      // setVisible(true);
   }
 
   public void itemStateChanged(ItemEvent ev)
   {
      String onOrOff = "off";
      if (mCheck.isSelected())
      {
         onOrOff = "on";
         System.out.println("Check box is " + onOrOff);
      }
          
   }

}
 
      
  
