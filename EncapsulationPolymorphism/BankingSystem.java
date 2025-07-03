// Interface for Loanable accounts
interface Loanable 
{
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract base class
abstract class BankAccount 
{
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double balance)
    {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    // Getters and setters (encapsulation)
    public String getAccountNumber()
    {
        return accountNumber;
    }

    public String getHolderName()
    {
        return holderName;
    }

    public double getBalance()
    {
        return balance;
    }

    protected void setBalance(double balance)
    {
        this.balance = balance;
    }

    // Concrete methods
    public void deposit(double amount)
    {
        if (amount > 0) 
	{
            balance += amount;
            System.out.println(amount + " deposited. New balance: " + balance);
        }
    	else 
	{
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount)
    {
        if (amount > 0 && balance >= amount) 
	{
            balance -= amount;
            System.out.println(amount + " withdrawn. New balance: " + balance);
        } 
	else 
	{
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method for interest
    public abstract double calculateInterest();

    public void displayDetails()
    {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + holderName);
        System.out.println("Balance: " + balance);
    }
}

// Savings Account
class SavingsAccount extends BankAccount implements Loanable 
{
    private static final double INTEREST_RATE = 0.04;

    public SavingsAccount(String accountNumber, String holderName, double balance)
    {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest()
    {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount)
    {
        System.out.println("Savings Account Loan application submitted for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility()
    {
        return getBalance() >= 5000;
    }
}

// Current Account
class CurrentAccount extends BankAccount implements Loanable 
{
    private static final double INTEREST_RATE = 0.02;

    public CurrentAccount(String accountNumber, String holderName, double balance)
    {
        super(accountNumber, holderName, balance);
    }

    @Override
    public double calculateInterest()
    {
        return getBalance() * INTEREST_RATE;
    }

    @Override
    public void applyForLoan(double amount)
    {
        System.out.println("Current Account Loan application submitted for amount: " + amount);
    }

    @Override
    public boolean calculateLoanEligibility()
    {
        return getBalance() >= 10000;
    }
}

// Driver class
public class BankingSystem 
{
    public static void main(String... args)
    {
        BankAccount account1 = new SavingsAccount("SA001", "Alice", 6000);
        BankAccount account2 = new CurrentAccount("CA001", "Bob", 15000);

        // Demonstrating polymorphism
        BankAccount[] accounts = {account1, account2};
        for (BankAccount acc : accounts) 
	{
            acc.displayDetails();
            System.out.println("Interest: " + acc.calculateInterest());

            // Cast to Loanable
            if (acc instanceof Loanable)
	    {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(5000);
                System.out.println("Loan Eligibility: " + loanAcc.calculateLoanEligibility());
            }
            System.out.println("-----------------------");
        }

        // Operations
        account1.deposit(1000);
        account2.withdraw(5000);
    }
}
