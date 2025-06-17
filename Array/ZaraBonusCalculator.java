//Importing Scanner class from util package
import java.util.Scanner;
//Compute bonuses of employees based on their year of services
public class ZaraBonusCalculator 
{
    public static void main(String... args)
    {
	//Creating object of Scanner class
        Scanner sc = new Scanner(System.in);

        int employee_count = 10;

        //Arrays to store salary and years of service
        double[] salary = new double[EMPLOYEE_COUNT];
        double[] yearsOfService = new double[EMPLOYEE_COUNT];

        //Arrays to store bonus and new salary
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        //Variables to store totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        //Input salary and years of service
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            //Input validation loop
            while (true) {
                double sal = sc.nextDouble();
                double yos = sc.nextDouble();

                if (sal > 0 && yos >= 0) {
                    salary[i] = sal;
                    yearsOfService[i] = yos;
                    break;
                } else {
                    System.out.println("Invalid input. Salary must be > 0 and years of service >= 0. Please re-enter.");
                }
            }
        }

        //Calculate bonus, new salary and totals
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (yearsOfService[i] > 5) 
	    {
                bonus[i] = 0.05 * salary[i]; // 5% bonus
            } 
	    else
	    {
                bonus[i] = 0.02 * salary[i]; // 2% bonus
            }

            newSalary[i] = salary[i] + bonus[i];

            
            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        //Print results
        System.out.println("\n--- Employee Bonus Details ---");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("Employee " + (i + 1) + ": Old Salary = ₹" + salary[i] +
                               ", Bonus = ₹" + bonus[i] +
                               ", New Salary = ₹" + newSalary[i]);
        }

        System.out.println("Total Bonus Payout: ₹" + totalBonus);
        System.out.println("Total Old Salary: ₹" + totalOldSalary);
        System.out.println("Total New Salary: ₹" + totalNewSalary);
	//Closing scanner class
        sc.close();
    }
}
