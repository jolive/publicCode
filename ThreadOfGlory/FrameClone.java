import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.scene.input.*;
import javafx.scene.layout.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameClone
extends JPanel
   implements Prototype
{

    /**
    * The text you want to be cloned
    */
   String name;
   
   /**
    * Text field and button
    */
   private JLabel amountLabel;
   private static String amountString = "Name: ";
   private JFormattedTextField amountField;
   JFrame frame;
   private static int xPos = 300;
   private static int yPos = 300;

    /**
    * Constructor that sets up new frame
    */
   public FrameClone(String name)
   {
      super();
      this.name = name;
      amountLabel = new JLabel(amountString);
      amountField = new JFormattedTextField();
      amountField.setValue(name);
      amountField.setColumns(10);
      amountLabel.setLabelFor(amountField);

      JPanel labelPane = new JPanel(new GridLayout(0,1));
      labelPane.add(amountLabel);

      JPanel fieldPane = new JPanel(new GridLayout(0,1));
      fieldPane.add(amountField);

      setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
      add(labelPane, BorderLayout.CENTER);
      add(fieldPane, BorderLayout.LINE_END);

      frame = new JFrame("Clone");
     
      frame.getContentPane().add(BorderLayout.CENTER, labelPane);
      frame.getContentPane().add(BorderLayout.LINE_END, fieldPane);
      frame.pack();
      frame.setLocation(xPos, yPos); yPos += 100;
      frame.setVisible(true);
   }   
   

   /**
    * Override and clone
    */  
   @Override
   public Prototype doClone()
   {
      return new FrameClone(name);
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
