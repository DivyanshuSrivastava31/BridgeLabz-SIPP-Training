//Importing Scanner Class from util package
import java.util.Scanner;
//Compute frequency of digits in a number
public class DigitFrequency {
    public static void main(String... args) {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);

        //Take integer input from the user
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        //Convert the number to string to process each digit
        String numStr = Integer.toString(Math.abs(number));

        //Create a frequency array of size 10 for digits 0-9
        int[] freq = new int[10];

        //Loop through the digits and update frequency
        for (int i = 0; i < numStr.length(); i++) {
            int digit = numStr.charAt(i) - '0';
            freq[digit]++;
        }

        //Display the frequency
        System.out.println("Digit Frequency in the number:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " occurs " + freq[i] + " times");
            }
        }
	//Closing Scanner class
        sc.close();
    }
}
