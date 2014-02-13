import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


public class BorderLayoutDemo
   extends JFrame
   implements ItemListener, Runnable
{
   public static void main(String[] args)
   {
      new BorderLayoutDemo().run();
      
   }

   public void run()
   {
      new BorderLayoutDemo().setVisible(true);
      newWindow black = new newWindow();
   }

   public ArrayList<Observer>  mObservers = new ArrayList<Observer>();

   public void registerObserver(Observer o)
   {
      mObservers.add(o);
   }
   
   public void removeObserver(Observer o)
   {
      mObservers.remove(o);
   }
   
   public void notifyObservers()
   {
      for (Observer ob : mObservers)
      {
         ob.update(this.mColor);
      }
   }

   String mColor;
   
   JCheckBox mCheck;
   
   public BorderLayoutDemo()
   {
      super("Border Layout Demo");
      setFont(new Font("Arial",1,20));
      setLayout(new BorderLayout());


     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
      
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
      setLocationRelativeTo(null);
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
 
