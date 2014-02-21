public class silly
   extends Glory
   implements Runnable
{
   public void run()
   {
      try
      {
         //while(silly.)
         while(silly.getInstance().shouldThreadBeRunning())
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
