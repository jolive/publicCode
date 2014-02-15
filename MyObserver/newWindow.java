import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class newWindow
   extends JFrame
{
   
   public newWindow()
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
      
   
      
      setSize(200,200);   
      setVisible(true);
      
   }   
}
