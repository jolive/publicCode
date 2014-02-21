public class silly234
   extends Glory
   implements Runnable
{
   public void run()
   {
      try
      {
         while(silly234.getInstance().shouldThreadBeRunning())
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
