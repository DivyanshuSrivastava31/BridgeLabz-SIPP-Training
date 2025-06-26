// Define a class to simulate bank accounting system
public class BankAccount 
{
    // Static variable shared by all BankAccount objects
    static String bankName = "OpenAI Bank";
    
    // Static counter to keep track of total accounts
    private static int totalAccounts = 0;

    // Final variable to ensure account number cannot be changed
    private final int accountNumber;

    // Instance variable for account holder's name
    private String accountHolderName;

    // Defining a parameterized constructor 
    public BankAccount(String accountHolderName, int accountNumber)
    {
        this.accountHolderName = accountHolderName; 
        this.accountNumber = accountNumber;         
        totalAccounts++;                            
    }

    // Static method to get total number of accounts
    public static int getTotalAccounts()
    {
        return totalAccounts;
    }

    // Method to display account details
    public void displayAccountDetails()
    {
        if (this instanceof BankAccount) 
	{ 
            System.out.println("Bank Name       : " + bankName);
            System.out.println("Account Holder  : " + this.accountHolderName);
            System.out.println("Account Number  : " + this.accountNumber);
        } 
	else 
	{
            System.out.println("Invalid account object.");
        }
    }

    // Main method 
    public static void main(String... args)
    {
        // Create account objects
        BankAccount acc1 = new BankAccount("Alice", 1001);
        BankAccount acc2 = new BankAccount("Bob", 1002);

        // Display their details
        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        // Display total accounts created
        System.out.println("Total Accounts Created: " + BankAccount.getTotalAccounts());
    }
}
