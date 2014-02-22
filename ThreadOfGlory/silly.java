public class silly
   implements Runnable
{
   public void run()
   {
      try
      {
         while(Glory.getInstance().shouldThreadBeRunning())
         {
            System.out.println("I'm running");
            Thread.sleep(1000);
         }
      }
      catch(Exception e)
      {
      }
   }
}
