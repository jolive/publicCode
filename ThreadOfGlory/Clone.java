import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import java.awt.event.KeyEvent;

import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * A simple program in which you enter a text in
 * the text field, hit enter and watch the frame
 * create a new frame and then clone it
 */
public class Clone
   extends JPanel
   implements Runnable
{

   TextField userTextField;

 /**
 * Text field and button
 */
   private JLabel amountLabel;
   private static String amountString = "Name: ";
   private JFormattedTextField amountField;
   JFrame frame;
   private static int xPos = 200;
   private static int yPos = 200;

   FrameClone clone1;
   FrameClone newClone;

   /**
    * Check for the Thread to be stopped then
    * dispose of the frames
    */
   public void run()
   {
      try
      {
         while(Glory.getInstance().shouldThreadBeRunning())
         {
      
         }
         clone1.close();
         newClone.close();
         frame.dispose();   
      }
      catch(Exception e)
      {
      }
   }

   /**
    * Create the name of the frame and textfield
    * of which you want to clone.
    * set up a actionlistner to wait for the enter
    * key to be pressed then create the new frame
    * and then clone it
    */
   public Clone()
   {
      super(new BorderLayout());
       
      amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue("");
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);
      amountField.addKeyListener(new KeyAdapter()
         {
            public void keyPressed(KeyEvent evt)
            {
               if(evt.getKeyCode() == evt.VK_ENTER)
               {
                  clone1 = new FrameClone(amountField.getText());
                  newClone = (FrameClone) clone1.doClone();
               }
            }
         });

      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);

      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);

      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(labelPane, BorderLayout.CENTER);
      add(fieldPane, BorderLayout.LINE_END);

      frame = new JFrame("Orignal");
     
      frame.getContentPane().add(BorderLayout.CENTER, labelPane);
      frame.getContentPane().add(BorderLayout.LINE_END, fieldPane);
      frame.pack();
      frame.setLocation(xPos, yPos);
      frame.setVisible(true);
   }

   /**
    * Close Function.  Dispose frame and reset the
    * position of the frame incase it is called
    * again
    */  
   public void close()
   {
      xPos = 200;
      yPos= 200;
      frame.dispose();
   }
}
