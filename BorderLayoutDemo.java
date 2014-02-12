import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BorderLayoutDemo
   extends JFrame
{
   public static void main(String[] args)
   {
      new BorderLayoutDemo().setVisible(true);
   }

   public BorderLayoutDemo()
   {
      super("Border Layout Demo");
      setFont(new Font("Arial",1,20));
      setLayout(new BorderLayout());

      addWindowListener(new WindowAdapter()
         {
            public void windowClosing(WindowEvent e)
            {
               System.exit(0);
            }
         });
      
      JFrame frame = new JFrame();
      
      JButton east = new JButton("East");
      JButton west = new JButton("West");
      JButton south = new JButton("South");
      JButton north = new JButton("North");
       JButton center = new JButton("Center");

      frame.getContentPane().add(BorderLayout.EAST, east);
      frame.getContentPane().add(BorderLayout.WEST, west);
      frame.getContentPane().add(BorderLayout.SOUTH, south);
      frame.getContentPane().add(BorderLayout.NORTH, north);
      frame.getContentPane().add(BorderLayout.CENTER, center);

      frame.setSize(300,300);
      frame.setVisible(true);
   }
}
   /*
   public void go()
   {
      JFrame frame = new JFrame();
      
      Jbutton east = new Jbutton("East");
      Jbutton west = new Jbutton("West");
      Jbutton south = new Jbutton("South");
      Jbutton north = new Jbutton("North");

      frame.getContentPane().add(BoarderLayout.EAST, east);
      frame.getContentPane().add(BoarderLayout.WEST, west);
      frame.getContentPane().add(BoarderLayout.SOUTH, south);
      frame.getContentPane().add(BoarderLayout.NORTH, north);

      frame.setSize(300,300);
      frame.setVisible(true);
   }
   */
         
      
  
