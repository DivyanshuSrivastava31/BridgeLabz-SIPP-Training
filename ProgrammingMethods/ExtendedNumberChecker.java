// Importing array class from util package
import java.util.Arrays;
// Compute to extract digits of a number and perform various operations on them
public class ExtendedNumberChecker 
{

    // Get digits of number
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // Sum of digits
    public static int sumOfDigits(int[] digits)
    {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }

    // Sum of squares of digits
    public static int sumOfSquares(int[] digits) 
    {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }

    // Check for Harshad number
    public static boolean isHarshad(int number, int[] digits)
    {
        return number % sumOfDigits(digits) == 0;
    }

    // Frequency of each digit
    public static int[][] digitFrequency(int[] digits) 
    {
        int[] freq = new int[10];
        for (int digit : digits) 
	{
            freq[digit]++;
        }
        int count = 0;
        for (int f : freq)
	{
            if (f > 0) count++;
        }
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0; i < 10; i++) 
	{
            if (freq[i] > 0)
	    {
                result[index][0] = i;
                result[index][1] = freq[i];
                index++;
            }
        }
        return result;
    }

    public static void main(String... args)
    {
	//Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Taking integer input from the user
        int number = sc.nextInt();
        int[] digits = getDigits(number);
	// Declaring the results
        System.out.println("Digits: " + Arrays.toString(digits));
        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares: " + sumOfSquares(digits));
        System.out.println("Harshad Number? " + isHarshad(number, digits));

        System.out.println("Digit Frequencies:");
        int[][] freq = digitFrequency(digits);
        for (int[] row : freq) 
	{
            System.out.println("Digit " + row[0] + " appears " + row[1] + " time(s)");
        }
	// Closing scanner class
	sc.close();
    }
}
