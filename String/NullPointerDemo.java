// Demonstrating Null pointer exception using length() function of string
public class NullPointerDemo 
{

    // Method to generate the NullPointerException
    public static void generateException()
    {
        // String is initialized as null
        String text = null;

        // Trying to call a method on a null reference (this will throw NullPointerException)
        int length = text.length(); 
        System.out.println("Length of text: " + length);
    }

    // Method to handle the NullPointerException
    public static void handleException()
    {
        try 
	{
            // String is still null
            String text = null;

            // Attempting to access method on null string
            int length = text.length(); 
            System.out.println("Length of text: " + length);
        } 
	catch (NullPointerException e)
	{
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
  	catch (RuntimeException e)
	{
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String... args) 
    {

        // Proper exception handling
        handleException();
    }
}
