// Define a class to accumulate a bank account
class BankAccount 
{
    // Initialize variables to store data
    public long accountNumber;       // public - accessible everywhere
    protected String accountHolder;  // protected - accessible in subclass
    private double balance;          // private - accessible only via methods

    // Constructor
    public BankAccount(long accountNumber, String accountHolder, double balance) 
    {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Public getter for balance
    public double getBalance()
    {
        return balance;
    }

    // Public setter for balance
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    // Method to display basic account info
    public void displayAccountInfo() 
    {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
    }
}
// Define a class to simulate a savings account
class SavingsAccount extends BankAccount 
{
    // Initialize variables to store data
    private double interestRate;

    // Constructor
    public SavingsAccount(long accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Display method
    public void displaySavingsAccountInfo() 
    {
        System.out.println("Savings Account Details:");
        System.out.println("Account Number: " + accountNumber);     
        System.out.println("Account Holder: " + accountHolder);     
        System.out.println("Balance: $" + getBalance());            
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Define a class to create a banking system
public class BankSystem 
{
    public static void main(String... args) 
    {
        // Base class object
        BankAccount b1 = new BankAccount(1234567890L, "Ravi Kumar", 50000.0);
        b1.displayAccountInfo();

        System.out.println("\n--- Savings Account Info ---");
        SavingsAccount sa = new SavingsAccount(9876543210L, "Anjali Sharma", 100000.0, 4.5);
        sa.displaySavingsAccountInfo();

        // Modify balance using setter
        sa.setBalance(120000.0);
        System.out.println("\nAfter updating balance:");
        System.out.println("New Balance: $" + sa.getBalance());
    }
}