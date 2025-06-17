//Importing Scanner class from util package
import java.util.*;
//Check whether a date lies in spring season or not
public class SpringSeason 
{
    // Method to check if it's Spring season
    public static boolean isSpringSeason(int month, int day) 
    {
        if ((month == 3 && day >= 20 && day <= 31) ||  
            (month == 4 && day >= 1 && day <= 30) ||   
            (month == 5 && day >= 1 && day <= 31) ||   
            (month == 6 && day >= 1 && day <= 20)) 
	{   
            return true;
        }
        return false;
    }

    public static void main(String... args) 
    {
       
        // Call the method and print result
        if (isSpringSeason(month, day)) 
	{
            System.out.println("It's a Spring Season");
        } 
	else
	{
            System.out.println("Not a Spring Season");
        }
    }
}
