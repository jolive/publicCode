import java.util.ArrayList;  
import java.util.Observable;  
import java.util.Observer;  


/**
 * A class that is Obserable and contains
 * the data which can be went to the Observies 
 */
public class Info2
   extends Observable
{  

   /**
    * An arraylist which holds all resgistered observers
    */
   private ArrayList<Observer> observers = new ArrayList<Observer>();
   
   /**
    * The name of the info
    */
   String mName;  
      

   /**
    * constructor
    */
   public Info2(String name)
   {  
      super();    
      this.mName=name;  
   }  

   /**
    * array of the resgistered observers
    */
   public ArrayList<Observer> getObservers()
   {  
      return observers;  
   }

   /**
    * set the observers
    */
   public void setObservers(ArrayList<Observer> observers)
   {  
      this.observers = observers;  
   }

   /**
    * get the name
    */
   public String getmName()
   {  
      return mName;  
   }  

   /**
    * set and update the name.  Notify all the observers
    * when the name has changed
    */
   public void setmName(String mName)
   {  
      if(!(this.mName.equalsIgnoreCase(mName)))  
      {  
         this.mName = mName;  
         setChanged();  
         notifyObservers(this,mName);  
      }  
   }  

   /**
    * the method that updates all the observers
    */
   public void notifyObservers(Observable observable,String mName)
   {  
      System.out.println("Auto Filling");  
      for (Observer ob : observers) {  
         ob.update(observable,this.mName);  
      }  
   }  

   /**
    * add a observer
    */
   public void registerObserver(Observer observer)
   {  
      observers.add(observer);  
          
   }  

   /**
    * remove a observer
    */
   public void removeObserver(Observer observer)
   {  
      observers.remove(observer);  
          
   }  
}  