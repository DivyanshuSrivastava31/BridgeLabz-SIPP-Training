// Importing scanner class from util package
import java.util.Scanner
// Main class to define the object of BankAccount class
public class MainBankAccount
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Taking name of account holder, account number and balance from the user
		String name=sc.nextLine();
		long accnumber=sc.nextLong();
		double balance=sc.nextDouble();
		// Creating object and calling method to display details
		BankAccount objAcc = new BankAccount(name, accnumber, balance);
		objEmp.displayDetails();
		// Ask the user whether they would withdraw or deposit the money
		System.out.println("Withraw or deposit the money...?");
		String choice=sc.nextLine();
		System.out.println("Enter the amount : ");
		switch(choice)
		{
			case "withdraw":
				double money=sc.nextDouble();
				objAcc.withdrawMoney(money);
			case "deposit":
				double money=sc.nextDouble();
				objAcc.depositMoney(money);
		}
		// Closing object of scanner class
		sc.close();
	}
}