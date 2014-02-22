import java.util.*;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;

import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Dialogs;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
* The Glory Application class that creates
* and manages the interface for Threads of Glory.
*/
public class Glory
   extends Application
{
   private Stage mPrimaryStage;
   private Group mRoot;
   private Scene mScene;
   private TextField mTextField;

   private GlorifiedList mRunnables;
   private GlorifiedList mRunningThreads;
   private BorderPane mBorderPane;

   private EventHandler<ActionEvent> mStartEventHandler;
   private EventHandler<ActionEvent> mStopEventHandler;

   private static Glory cInstance = null;

   private class GlorifiedList
      extends VBox
   {
      private ListView<String> mListView;
      private Label mLabel;
      private Button mButton;

      public GlorifiedList(String pLabelText,
                           ObservableList<String> pListItems,
                           String pButtonText,
                           EventHandler<ActionEvent> pButtonEventHandler,
                           SelectionMode pSelectionMode)
      {
         mLabel = new Label(pLabelText);

         mListView = new ListView<String>();
         if (pListItems != null)
         {
            mListView.setItems(pListItems);
         }
         mListView.setPrefWidth(200);

         mListView.getSelectionModel().setSelectionMode(
            pSelectionMode);

         mButton = new Button(pButtonText);

         mButton.setOnAction(pButtonEventHandler);

         getChildren().addAll(mLabel, mListView, mButton);
         setMargin(mLabel, new Insets(10));
         setMargin(mListView, new Insets(20));
         setMargin(mButton, new Insets(10));
         setAlignment(Pos.CENTER);
      }

      public boolean addToList(String pName)
      {
         if (isInList(pName))
         {
            return false;
         }
         else
         {
            mListView.getItems().add(pName);
            mListView.getSelectionModel().select(pName);
            return true;
         }
      }

      public void removeFromList(String pName)
      {
         if (isInList(pName))
         {
            mListView.getItems().remove(pName);
         }
      }

      public void removeFromList()
      {
         for (String name :
                 new ArrayList<String>(
                    mListView.getSelectionModel().getSelectedItems()))
         {
            removeFromList(name);
         }
         mListView.getSelectionModel().selectFirst();
      }

      public String getSelectedItem()
      {
         return mListView.getSelectionModel().getSelectedItem();
      }

      public boolean isInList(String pName)
      {
         return mListView.getItems().contains(pName);
      }

      public void requestButtonFocus()
      {
         mButton.requestFocus();
      }
   }

   private void showMessage(String pMsg1, String pMsg2)
   {
      Dialogs.showInformationDialog(
         mPrimaryStage, pMsg2, pMsg1, "Alert");
   }

   public void start(Stage pPrimaryStage)
   {
      mPrimaryStage = pPrimaryStage;
      mPrimaryStage.setTitle("Glory");

      mPrimaryStage.setOnCloseRequest(
         new EventHandler<WindowEvent>()
         {
            public void handle(WindowEvent event)
            {
               event.consume();
               try
               {
                  Platform.exit();
                  System.exit(0);
               }
               catch (Exception e)
               {
                  System.out.println(e.getMessage());
               }
            }
         });

      mRoot = new Group();

      mScene = new Scene(mRoot, 460, 640, Color.WHITE);

      mStartEventHandler =
         new EventHandler<ActionEvent>()
         {
            public void handle(ActionEvent event)
            {
               startThread();
            }
         };

      mStopEventHandler =
         new EventHandler<ActionEvent>()
         {
            public void handle(ActionEvent event)
            {
               stopThread();
            }
         };

      HBox hbox = new HBox(10);
      Label label = new Label("Enter Runnable: ");
      mTextField = new TextField("");

      hbox.getChildren().addAll(label, mTextField);
      hbox.setMargin(label, new Insets(10, 0, 10, 30));
      hbox.setMargin(mTextField, new Insets(10, 10, 10, 0));
      hbox.setHgrow(mTextField, Priority.ALWAYS);

      mRunnables =
         new GlorifiedList(
            "Runnables", null,
/*
FXCollections.observableArrayList(
"Silly", "Blinky", "Lovely", "Funny", "Jiggly", "Praiser"),
*/
            "Start", mStartEventHandler, SelectionMode.SINGLE);

      mRunningThreads =
         new GlorifiedList(
            "Running Threads", null,
/*
FXCollections.observableArrayList(
"SillyThread-2", "SillyThread-4", "LovelyThread-6", "PraiserThread-8"),
*/
            "Stop", mStopEventHandler, SelectionMode.MULTIPLE);

      mTextField.setOnAction(
         new EventHandler<ActionEvent>()
         {
            public void handle(ActionEvent event)
            {
               enterRunnable();
            }
         });

      HBox listsBox = new HBox(10);
      listsBox.getChildren().addAll(mRunnables, mRunningThreads);
      listsBox.setMargin(mRunnables, new Insets(10, 10, 10, 10));
      listsBox.setMargin(mRunningThreads, new Insets(10, 10, 10, 10));

      mBorderPane = new BorderPane();
      mBorderPane.prefHeightProperty().bind(mScene.heightProperty());
      mBorderPane.prefWidthProperty().bind(mScene.widthProperty());
      mBorderPane.setCenter(hbox);
      mBorderPane.setBottom(listsBox);

      mRoot.getChildren().add(mBorderPane);

      mPrimaryStage.setScene(mScene);

      mPrimaryStage.show();
   }

   public static void main(String[] args)
   {
      launch(args);
   }

   private void enterRunnable()
   {
      String runnableName = mTextField.getText();
      mTextField.setText("");
      if (loadRunnable(runnableName) && startThread())
      {
         mRunningThreads.requestButtonFocus();
      }
   }

   private boolean loadRunnable(String name)
   {
      Class runnable = null;
      boolean isReallyRunnable = false;
      try
      {
         if (name != null && name.length() > 0)
         {
            runnable = Class.forName(name);
            isReallyRunnable = Runnable.class.isAssignableFrom(runnable);
            if (isReallyRunnable)
            {
               mRunnables.addToList(runnable.getName());
            }
            else
            {
               throw new ClassCastException(name + " is not a Runnable.");
            }
         }
      }
      catch (Throwable t)
      {
         showMessage("Error loading Runnable", t.toString());
      }
      return (runnable != null && isReallyRunnable);
   }

   private boolean startThread()
   {
      String name = mRunnables.getSelectedItem();
      Thread t = createThread(name);
      if (t != null)
      {
         mRunningThreads.addToList(t.getName());
         t.start();
         return true;
      }
      return false;
   }

   private Thread createThread(String name)
   {
      // name has been validated as the name of a Runnable class
      // that can be instantiated
      Thread t = null;
      try
      {
         Runnable r = (Runnable) Class.forName(name).newInstance();
         t = new Thread(r);
         t.setName(r.getClass().getName() + t.getName());
      }
      catch (Exception e)
      {
         // should never get here
      }
      return t; // should never be null
   }

   public Glory()
   {
      super();
      synchronized (Glory.class)
      {
         if (cInstance != null)
         {
            throw new UnsupportedOperationException(
               getClass() +
               " is singleton but constructor called more than once");
         }
         cInstance = this;
      }
   }
   
   public static Glory getInstance()
   {
      return cInstance;
   }

   private void stopThread()
   {
      mRunningThreads.removeFromList();
   }

   public boolean shouldThreadBeRunning()
   {
      return (shouldThreadBeRunning(Thread.currentThread()));
   }

   public boolean shouldThreadBeRunning(Thread t)
   {
      return mRunningThreads.isInList(t.getName());
   }
}
