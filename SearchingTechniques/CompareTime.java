// Comparison between StringBuilder and StringBuffer
public class CompareTime
{
	public static void main(String... args)
	{
		StringBuilder sb = new StringBuilder("");
		StringBuffer sf = new StringBuffer("");
		long startTime = System.nanoTime();
		for(int i = 0 ; i < 1000000 ; i++)
		{
			sb.append("h");
		}
		long endTime = System.nanoTime();
		System.out.println("Time for String Builder : "+(endTime-startTime));
		startTime = System.nanoTime();
		for(int i = 0 ; i < 1000000 ; i++)
		{
			sf.append("h");
		}
		endTime = System.nanoTime();
		System.out.println("Time for String Buffer : "+(endTime-startTime));
	}
}