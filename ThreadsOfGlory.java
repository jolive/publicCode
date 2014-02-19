import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.geometry.HPos;

import javafx.geometry.*;

import javafx.scene.control.*;

import javafx.scene.*;

import javafx.scene.control.Label;

import javafx.scene.layout.*;




//for the observer
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.ComboBoxListCell;
 
public class ThreadsOfGlory
   extends Application
{

   public static final ObservableList names = 
      FXCollections.observableArrayList();

   ListView listView;
   ListView listView2;

   TextField userTextField;
   
   public static void main(String[] args)
   {
      launch(args);
   }
   @Override
   public void start(Stage primaryStage)
   {
      primaryStage.setTitle("Threads of Glory");

      //grid
      GridPane grid = new GridPane();
      grid.setAlignment(Pos.TOP_CENTER);
      grid.setHgap(5);
      grid.setVgap(10);
      grid.setPadding(new Insets(5, 5, 5, 5));
      Scene scene = new Scene(grid, 450, 425);

      //The runnable thread input box
      Label Thread = new Label("Enter Runnable:");
      grid.add(Thread, 0, 1);
      userTextField = new TextField();
      grid.add(userTextField, 1, 1);

      //List of runnables
       Label Thread1 = new Label("Runnable:");
      grid.add(Thread1, 0, 2);
      listView = new ListView();
      listView.setPrefSize(200, 250);
      listView.setEditable(true);
      grid.add(listView, 0, 3);

      //List of runnings
      Label Thread2 = new Label("Running Threads:");
      grid.add(Thread2, 1, 2);
      listView2 = new ListView();
      listView2.setPrefSize(200, 250);
      listView2.setEditable(true);
      grid.add(listView2, 1, 3);

      //Stop threads button
      Button btn = new Button("Stop");
      HBox hbBtn = new HBox(10);
      hbBtn.setAlignment(Pos.BOTTOM_CENTER);
      hbBtn.getChildren().add(btn);
      grid.add(hbBtn, 1, 5);

      //Run thread button
      Button run = new Button("Run");
      HBox hrun = new HBox(10);
      hrun.setAlignment(Pos.BOTTOM_CENTER);
      hrun.getChildren().add(run);
      grid.add(hrun, 0, 5);

      run.setOnAction(new EventHandler<ActionEvent>()
                      {
                         public void handle(ActionEvent e)
                         {
                            names.add(userTextField.getText());
                            listView.setItems(names);
                         }
                      });
      

      //grid.setGridLinesVisible(true);
         
      primaryStage.setScene(scene);
      primaryStage.show();
   }
}
