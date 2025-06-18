// Importing Arrays class from util package
import java.util.Arrays;
// Importing Scanner class from util package
import java.util.Scanner;
// Check to find whether a number is Armstrong or duck, and find the largest and smallest digits
public class NumberCheckerArmstrongDuck 
{

    // Method to count digits
    public static int countDigits(int number) 
    {
        return String.valueOf(Math.abs(number)).length();
    }

    // Method to store digits in an array
    public static int[] getDigits(int number)
    {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++)
	{
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Method to check for Duck Number (has zero, but not as first digit)
    public static boolean isDuckNumber(int[] digits)
    {
        for (int i = 1; i < digits.length; i++) 
	{
            if (digits[i] == 0) return true;
        }
        return false;
    }

    // Method to check for Armstrong number
    public static boolean isArmstrong(int number, int[] digits) 
    {
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) 
	{
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // Method to find largest and second largest digits
    public static int[] findTwoLargest(int[] digits)
    {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int digit : digits) 
	{
            if (digit > first)
	    {
                second = first;
                first = digit;
            } 
	    else if (digit > second && digit != first)
	    {
                second = digit;
            }
        }
        return new int[]{first, second};
    }

    // Method to find smallest and second smallest digits
    public static int[] findTwoSmallest(int[] digits) 
    {
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int digit : digits) 
	{
            if (digit < first) 
	    {
                second = first;
                first = digit;
            } 
	    else if (digit < second && digit != first)
	    {
                second = digit;
            }
        }
        return new int[]{first, second};
    }

    public static void main(String.... args) 
    {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Take an integer input from the user
        int number = sc.nextInt();
        int[] digits = getDigits(number);

        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Duck Number? " + isDuckNumber(digits));
        System.out.println("Armstrong Number? " + isArmstrong(number, digits));

        int[] largest = findTwoLargest(digits);
        System.out.println("Largest: " + largest[0] + ", Second Largest: " + largest[1]);

        int[] smallest = findTwoSmallest(digits);
        System.out.println("Smallest: " + smallest[0] + ", Second Smallest: " + smallest[1]);
	// Closing scanner class
	sc.close();
    }
}
