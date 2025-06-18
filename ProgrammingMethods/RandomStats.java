// Importing Arrays class from util package
import java.util.Arrays;
// Compute to generate random numbers and find average, minimum and maximum numbers
public class RandomStats
{

    // Method to generate array of 4-digit random numbers
    public static int[] generate4DigitRandomArray(int size)
    {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) 
	{
            arr[i] = (int) (Math.random() * 9000) + 1000; // 1000 to 9999
        }
        return arr;
    }

    // Method to find average, min and max
    public static double[] findAverageMinMax(int[] numbers)
    {
        int min = numbers[0], max = numbers[0], sum = 0;
        for (int num : numbers) 
	{
            sum += num;
            if (num < min) min = num;
            if (num > max) max = num;
        }
        double avg = (double) sum / numbers.length;
        return new double[]{avg, min, max};
    }

    public static void main(String... args)
    {
	// Declare an array to store random numbers
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.println("Generated Numbers: " + Arrays.toString(randomNumbers));
	
        double[] result = findAverageMinMax(randomNumbers);
        System.out.printf("Average: "+ result[0]+", Minimum: "+result[1]+", Maximum: "+result[2]);
    }
}
