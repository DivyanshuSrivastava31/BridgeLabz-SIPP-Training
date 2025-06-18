// Importing Random class from util package
import java.util.Random;
// Generating two matrices and perform arithematic operations on them
public class MatrixMath 
{

    // Create random matrix
    public static int[][] createMatrix(int rows, int cols)
    {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                matrix[i][j] = rand.nextInt(10); // 0–9
        return matrix;
    }

    // Add matrices
    public static int[][] add(int[][] a, int[][] b)
    {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] + b[i][j];
        return result;
    }

    // Subtract matrices
    public static int[][] subtract(int[][] a, int[][] b)
    {
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < a[0].length; j++)
                result[i][j] = a[i][j] - b[i][j];
        return result;
    }

    // Multiply matrices
    public static int[][] multiply(int[][] a, int[][] b)
    {
        int rows = a.length, cols = b[0].length, common = b.length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                for (int k = 0; k < common; k++)
                    result[i][j] += a[i][k] * b[k][j];
        return result;
    }

    // Print matrix
    public static void printMatrix(int[][] matrix)
    {
        for (int[] row : matrix) 
	{
            for (int val : row)
                System.out.print(val + "\t");
            System.out.println();
        }
    }

    public static void main(String... args)
    {
        // Declaring two matrices
	int[][] A = createMatrix(2, 2);
        int[][] B = createMatrix(2, 2);
	// Displaying result
        System.out.println("Matrix A:");
        printMatrix(A);
        System.out.println("Matrix B:");
        printMatrix(B);

        System.out.println("A + B:");
        printMatrix(add(A, B));
        System.out.println("A - B:");
        printMatrix(subtract(A, B));
        System.out.println("A * B:");
        printMatrix(multiply(A, B));
    }
}
