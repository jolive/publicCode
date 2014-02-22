public class silly234
   implements Runnable
{
   public void run()
   {
      try
      {
         while(Glory.getInstance().shouldThreadBeRunning())
         {
            System.out.println("I'm running234");
            Thread.sleep(1000);
         }
      }
      catch(Exception e)
      {
      }
   }
}
