// Importing Random class from util package
import java.util.Random;
// Compute various matrix operations on 2 matrices
public class MatrixOperations 
{

    // Create random 2x2 matrix
    public static int[][] createMatrix2x2()
    {
        Random rand = new Random();
        return new int[][]{
                {rand.nextInt(10), rand.nextInt(10)},
                {rand.nextInt(10), rand.nextInt(10)}
        };
	
    }

    // Transpose of a matrix
    public static int[][] transpose(int[][] matrix)
    {
        int[][] transposed = new int[2][2];
        for (int i = 0; i < 2; i++) 
	{
            for (int j = 0; j < 2; j++)
 	    {
                transposed[i][j] = matrix[j][i];
            }
        }
        return transposed;
    }

    // Determinant of 2x2 matrix
    public static int determinant(int[][] matrix)
    {
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // Inverse of 2x2 matrix
    public static double[][] inverse2x2(int[][] matrix)
    {
        int det = determinant(matrix);
        if (det == 0) return null;

        double[][] inverse = new double[2][2];
        inverse[0][0] = matrix[1][1] / (double) det;
        inverse[0][1] = -matrix[0][1] / (double) det;
        inverse[1][0] = -matrix[1][0] / (double) det;
        inverse[1][1] = matrix[0][0] / (double) det;

        return inverse;
    }

    // Print any matrix
    public static void printMatrix(double[][] matrix)
    {
        for (double[] row : matrix) 
	{
            for (double val : row)
	    {
                System.out.printf(val);
            }
            System.out.println();
        }
    }

    public static void main(String... args)
    {
	// Declaring a matrix to perfrom various operations on it
        int[][] matrix = createMatrix2x2();
	// Displaying the result
        System.out.println("Original Matrix:");
        for (int[] row : matrix) 
	{
            for (int val : row)
  	    {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        System.out.println("Transpose:");
        int[][] transposed = transpose(matrix);
        for (int[] row : transposed)
	{
            for (int val : row)
	    {
                System.out.print(val + "\t");
            }
            System.out.println();
        }

        int det = determinant(matrix);
        System.out.println("Determinant: " + det);

        System.out.println("Inverse:");
        double[][] inverse = inverse2x2(matrix);
        if (inverse != null) 
	{
            printMatrix(inverse);
        } 
	else 
	{
            System.out.println("Matrix is not invertible.");
        }
    }
}
