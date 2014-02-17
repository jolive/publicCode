import java.util.ArrayList;  
import java.util.Observable;  
import java.util.Observer;  


/**
 * A class that is Obserable and contains
 * the data which can be went to the Observies 
 */
public class Info
   extends Observable
{  

   /**
    * An arraylist which holds all resgistered observers
    */
   private ArrayList<Observer> observers = new ArrayList<Observer>();

   /**
    * The name of the product or data
    */
   private String productName;

   /**
    * The type of the info
    */
   private String productType;

   /**
    * The name of the info
    */
   String mName;  
      

   /**
    * constructor
    */
   public Info(String productName, String productType,String name)
   {  
      super();  
      this.productName = productName;  
      this.productType = productType;  
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
    * get the product's name
    */
   public String getProductName()
   {  
      return productName;  
   }

   /**
    * set the product's name
    */
   public void setProductName(String productName)
   {  
      this.productName = productName;  
   }

   /**
    * get the product type
    */
   public String getProductType() {  
      return productType;  
   }

   /**
    * set the product type
    */
   public void setProductType(String productType)
   {  
      this.productType = productType;  
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