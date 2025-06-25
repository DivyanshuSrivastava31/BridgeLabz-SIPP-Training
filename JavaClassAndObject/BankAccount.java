// Defining a class to simulate an atm of bank account holder
public class BankAccount
{
	// Initializing variables to store bank account details of the person
	private String accountHolder;
	private long accountNumber;
	private double balance;
	// Defining a constructor to retrieve attribute values
	public BankAccount(String accountHolder, long accountNumber, double balance)
	{
		this.accountHolder=accountHolder;
		this.accountNumber=accountNumber;
		this.balance=balance;
	}
	// Method to deposit money in the account
	public void depositMoney(double deposit)
	{
		this.balance=this.balance + deposit;
	}
	// Method to withdraw money from the account
	public void withdrawMoney(double withdraw)
	{
		if(withdraw<this.balance)
		{
			this.balance=this.balance-withdraw;
		}
		else
		{
			System.out.println("You have insufficient balance in your account!!!");
		}
	}
	// Method to display details of the account
	{
		System.out.println("Bank Account Details : ");
		System.out.println("Name of account holder : "+this.accountHolder);
		System.out.println("Bank account number : "+this.accountNumber);
		System.out.println("Balance in the account : "+this.balance);
	}
}