import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
// Reading the characters from the file with specified encoding
public class EncodingAndReadingAFile 
{
    public static void main(String... args)
    {
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream("CompareTime.java"), "UTF-8")) 
	{
            int i;
            while ((i = isr.read()) != -1)
	    {
                System.out.print((char) i);  
            }
        } 
	catch (IOException e) 
	{
            e.printStackTrace();
        }
    }
}
