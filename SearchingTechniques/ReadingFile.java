import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
// Reading a file line by line
public class ReadingFile 
{
    public static void main(String... args)
    {
        String filePath = "CompareTime.java";
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
	{
            String line;
            while ((line = br.readLine()) != null)
	    { 
                System.out.println(line);
            }
        } 
	catch (IOException e)
	{
            e.printStackTrace();
        }
    }
}
