// Importing Random class from util package
import java.util.Random;
// Calculate Employee Bonus based on their time period
public class EmployeeBonusCalculator 
{

    // Method to generate old salaries and years of service
    public static int[][] generateEmployeeData(int count) 
    {
        Random rand = new Random();
        int[][] data = new int[count][2]; // 0: salary, 1: years of service
        for (int i = 0; i < count; i++) 
	{
            data[i][0] = rand.nextInt(40000) + 10000; // 5-digit salary
            data[i][1] = rand.nextInt(11); // 0 to 10 years
        }
        return data;
	
    }

    // Method to calculate bonus and new salary
    public static double[][] calculateBonuses(int[][] data)
    {
        double[][] result = new double[data.length][2]; // 0: bonus, 1: new salary
        for (int i = 0; i < data.length; i++) 
	{
            double bonusRate = data[i][1] > 5 ? 0.05 : 0.02;
            double bonus = data[i][0] * bonusRate;
            result[i][0] = bonus;
            result[i][1] = data[i][0] + bonus;
        }
        return result;
    }

    public static void main(String... args)
    {
	// Declare two matrices to store old and new salaries of empployees
        int[][] oldData = generateEmployeeData(10);
        double[][] newData = calculateBonuses(oldData);

        double totalOld = 0, totalNew = 0, totalBonus = 0;
	// Displaying the result
        System.out.println("Emp\tOldSalary\tYears\tBonus\t\tNewSalary");
        for (int i = 0; i < oldData.length; i++) 
	{
            System.out.printf("%d\t%d\t\t%d\t%.2f\t\t%.2f\n",
                    i + 1, oldData[i][0], oldData[i][1], newData[i][0], newData[i][1]);
            totalOld += oldData[i][0];
            totalNew += newData[i][1];
            totalBonus += newData[i][0];
        }

        System.out.printf("\nTotal Old Salary: %.2f\nTotal Bonus: %.2f\nTotal New Salary: %.2f\n",
                totalOld, totalBonus, totalNew);
    }
}
