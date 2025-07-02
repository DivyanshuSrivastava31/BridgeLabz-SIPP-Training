// Importing scanner class from util package
import java.util.Scanner;

// Define a class to store details of a bank
class BankAccount
{
	long accountNumber;
	int balance;
}

// Define a class for Savings account, Checking account and Fixed deposit account
class SavingsAccount extends BankAccount // Hierarchical Inheritance
{
	double interestRate;
	public SavingsAccount(long accNum, int balance, double rate)
	{
		accountNumber=accNum;
		this.balance=balance;
		interestRate = rate;
	}
	void displayAccountType()
	{
		System.out.println("Account details : ");
		System.out.println("Account Number : "+accountNumber);
		System.out.println("Balance in the account : "+balance);
		System.out.println("Account type : Savings account");
		System.out.println("Rate of interest : "+interestRate);
	}
}

class CheckingAccount extends BankAccount // Hierarchical Inheritance
{
	int withdrawalLimit;
	public CheckingAccount(long accNum, int balance, int limit)
	{
		accountNumber = accNum;
		this.balance = balance;
		withdrawalLimit = limit;
	}
	void displayAccountType()
	{
		System.out.println("Account details : ");
		System.out.println("Account Number : "+accountNumber);
		System.out.println("Balance in the account : "+balance);
		System.out.println("Account type : Checking account");
		System.out.println("Withdrawal Limit : "+withdrawalLimit);
	}
}

class FixedDepositAccount extends BankAccount // Hierarchical Inheritance
{
	int deposit;
	public FixedDepositAccount(long accNum, int balance, int deposit)
	{
		accountNumber=accNum;
		this.balance = balance;
		this.deposit=deposit;
	}
	void displayAccountType()
	{
		System.out.println("Account details : ");
		System.out.println("Account Number : "+accountNumber);
		System.out.println("Balance in the account : "+balance);
		System.out.println("Account type : Fixed Deposit account");
		System.out.println("Fixed deposit every month : "+deposit);
	}
}

// Defining main class
public class BankManagement
{
	public static void main(String... args)
	{
		// Creating object of scanner class
		Scanner sc = new Scanner(System.in);
		// Input bank details from the user
		System.out.println("Enter bank account number and balance in the account : ");
		long accNum=sc.nextLong();
		int balance=sc.nextInt();
		System.out.println("Enter if there is a fixed deposit in the account else 0 : ");
		int deposit=sc.nextInt();
		System.out.println("Enter if there is a withdrawal limit for the account else 0 : ");
		int limit=sc.nextInt();
		System.out.println("Enter if there is a rate of interest for the account else 0 : ");
		double rate = sc.nextDouble();
		if(deposit==0&&limit==0)
		{
			SavingsAccount savingsAccount = new SavingsAccount(accNum, balance, rate);
			savingsAccount.displayAccountType();
		}
		if(rate==0.0&&deposit==0)
		{
			CheckingAccount checkingAccount = new CheckingAccount(accNum, balance, limit);
			checkingAccount.displayAccountType();
		}
		if(rate==0.0&&limit==0)
		{
			FixedDepositAccount fixedDepositAccount = new FixedDepositAccount(accNum, balance, deposit);
			fixedDepositAccount.displayAccountType();
		}
	}
}