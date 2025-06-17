//Importing Scanner class from util package
import java.util.Scanner;
//Converting Multi-dimensional array into a Single Dimensional Array
public class Convert2DArrayTo1DArray
{
	public static void main(String... args)
	{
		//Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		//Take inputs for rows and columns for a 2D Array
		int rows=sc.nextInt();
		int columns=sc.nextInt();
		//Initialize a 2-D Array
		int[][] multidimensional_array = new int[rows][columns];
		//Initialize a 1-D Array
		int[] singledimensional_array = new int[rows*columns];
		//Initialize a counter to count single dimensional array
		int counter=0;
		//Initialize a loop to take elements from the user store the result
		for(int row_loop=0;row_loop<rows;row_loop++)
		{
			for(int column_loop=0;column_loop<columns;column_loop++)
			{
				multidimensional_array[row_loop][column_loop]=sc.nextInt();
				singledimensional_array[counter++]=multidimensional_array[row_loop][column_loop];
			}
		}
		//Printing the result
		System.out.println("Single Dimensional Array : ");
		for(int loop=0;loop<counter;loop++)
		{
			System.out.println(singledimensional_array[loop]);
		}
		//Closing scanner class
		sc.close();
	}
}