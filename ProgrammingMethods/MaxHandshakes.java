//Importing Scanner class from util package
import java.util.Scanner;
//Compute Maximum Handshakes made by a person
public class MaxHandshakes
{

    //Method to calculate maximum handshakes using combination formula
    public static int calculateHandshakes(int students) 
    {
        return (students * (students - 1)) / 2;
    }

    public static void main(String... args) 
    {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        // Get input from the user
        int numberOfStudents = sc.nextInt();

        // Validate input
        if (numberOfStudents < 0) {
            System.out.println("Number of students cannot be negative.");
        } else {
            // Calculate and display the result
            int max_handshakes = calculateHandshakes(numberOfStudents);
            System.out.println("Maximum number of possible handshakes: " + max_handshakes);
        }
	//Closing scanner class
        sc.close();
    }
}
