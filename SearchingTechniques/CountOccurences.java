import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// Count number of occurences of a word
public class CountOccurences 
{
    public static void main(String... args)
    {
        String filePath = "CompareTime.java";
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	{
            String line;
            while ((line = br.readLine()) != null)
	    { 
		line=line+" ";
		String[] str = line.split(" ");
                for(int i = 0 ; i<str.length ; i++)
		{
			if(str[i].equalsIgnoreCase("System"))
				count++;
            	}
	    }
        } 
	catch (IOException e)
	{
            e.printStackTrace();
        }
	finally
	{
		System.out.println("No. of words : "+count);
	}
    }
}
