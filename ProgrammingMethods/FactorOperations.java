// Importing ArrayList class from util package
import java.util.ArrayList;
// Importing Scanner class from util package
import java.util.Scanner;
// Compute to find factors of a number and perform analysis on them
public class FactorOperations
{

    // Get factors of a number
    public static int[] getFactors(int number) 
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) 
	{
            if (number % i == 0) list.add(i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    // Find greatest factor (excluding number itself)
    public static int greatestFactor(int[] factors, int number)
    {
        int max = 1;
        for (int f : factors) 
	{
            if (f < number && f > max) max = f;
        }
        return max;
    }

    // Sum of factors
    public static int sum(int[] factors)
    {
        int s = 0;
        for (int f : factors) s += f;
        return s;
    }

    // Product of factors
    public static long product(int[] factors)
    {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    // Product of cubes of factors
    public static long cubeProduct(int[] factors)
    {
        long prod = 1;
        for (int f : factors) 
	{
            prod *= Math.pow(f, 3);
        }
        return prod;
    }

    public static void main(String... args)
    {
         // Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Take integer number from the user
        int number = sc.nextInt();
	//Declaring an array to store factors
        int[] factors = getFactors(number);

        System.out.print("Factors: ");
        for (int f : factors) System.out.print(f + " ");
        System.out.println();

        System.out.println("Greatest Factor: " + greatestFactor(factors, number));
        System.out.println("Sum of Factors: " + sum(factors));
        System.out.println("Product of Factors: " + product(factors));
        System.out.println("Product of Cubes: " + cubeProduct(factors));
	// Closing scanner class
	sc.close();
    }
}
