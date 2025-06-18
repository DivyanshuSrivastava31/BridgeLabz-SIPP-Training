// Importing Scanner class from util package
import java.util.Scanner;
// Compute BMI Status of 10 persons
public class BMICalculator 
{

    // Method to calculate BMI
    public static void calculateBMI(double[][] data)
    {
        for (int i = 0; i < data.length; i++) 
	{
            double weight = data[i][0]; // in kg
            double heightInMeters = data[i][1] / 100.0; // cm to m
            data[i][2] = weight / (heightInMeters * heightInMeters); // BMI
        }
    }

    // Method to determine BMI Status
    public static String getBMIStatus(double bmi)
    {
        if (bmi < 18.5) return "Underweight";
        else if (bmi < 25) return "Normal";
        else if (bmi < 30) return "Overweight";
        else return "Obese";
    }

    public static void main(String... args) 
    {
	// Creating object of scanner class
        Scanner sc = new Scanner(System.in);
	// Declaring a matrix to store BMI of 10 persons
        double[][] data = new double[10][3]; 

        // Input height and weight from user
        for (int i = 0; i < 10; i++) 
	{
            data[i][0] = sc.nextDouble();
            data[i][1] = sc.nextDouble();
        }

        // Calculate BMI
        calculateBMI(data);

        // Display table
        for (int i = 0; i < 10; i++) {
            System.out.println("Weight of the person : "+data[i][0]);
	    System.out.println("Height of the person : "+data[i][1]);
	    System.out.println("BMI of the person : "+data[i][2]);
	    String status=getBMIStatus(data[i][2]);
	    System.out.println("Status of the person : "+status);
        }
	// Closing scanner class
	sc.close();
    }
}
