package Shairu;

public class Utils 
{
	public static void waitForTime(int time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
