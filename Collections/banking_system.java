import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BankingSystem {

    // HashMap to store customer accounts: AccountNumber -> Balance
    private Map<String, Double> accountsHashMap;

    // TreeMap to sort customers by balance
    // Key: Balance, Value: List of Account Numbers (to handle multiple accounts with the same balance)
    private TreeMap<Double, LinkedList<String>> accountsByBalanceTreeMap;

    // Queue to process withdrawal requests
    // Stores: AccountNumber
    private Queue<String> withdrawalRequestQueue;

    public BankingSystem() {
        accountsHashMap = new HashMap<>();
        
        // TreeMap to sort by balance. If balances are the same, order doesn't matter for this example.
        // We use LinkedList to handle multiple accounts having the same balance.
        accountsByBalanceTreeMap = new TreeMap<>();
        
        withdrawalRequestQueue = new LinkedList<>();
    }

    /**
     * Creates a new customer account with an initial balance.
     *
     * @param accountNumber The unique account number.
     * @param initialBalance The initial balance for the account.
     */
    public void createAccount(String accountNumber, double initialBalance) {
        if (accountsHashMap.containsKey(accountNumber)) {
            System.out.println("Error: Account number " + accountNumber + " already exists.");
            return;
        }
        if (initialBalance < 0) {
            System.out.println("Error: Initial balance cannot be negative.");
            return;
        }

        accountsHashMap.put(accountNumber, initialBalance);
        accountsByBalanceTreeMap.computeIfAbsent(initialBalance, k -> new LinkedList<>()).add(accountNumber);
        System.out.printf("Account %s created with initial balance: $%.2f%n", accountNumber, initialBalance);
    }

    /**
     * Deposits money into a customer account.
     *
     * @param accountNumber The account number.
     * @param amount The amount to deposit.
     */
    public void deposit(String accountNumber, double amount) {
        if (!accountsHashMap.containsKey(accountNumber)) {
            System.out.println("Error: Account " + accountNumber + " not found.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Deposit amount must be positive.");
            return;
        }

        double oldBalance = accountsHashMap.get(accountNumber);
        double newBalance = oldBalance + amount;

        // Update HashMap
        accountsHashMap.put(accountNumber, newBalance);

        // Update TreeMap: remove old balance entry, add new balance entry
        accountsByBalanceTreeMap.get(oldBalance).remove(accountNumber);
        if (accountsByBalanceTreeMap.get(oldBalance).isEmpty()) {
            accountsByBalanceTreeMap.remove(oldBalance);
        }
        accountsByBalanceTreeMap.computeIfAbsent(newBalance, k -> new LinkedList<>()).add(accountNumber);

        System.out.printf("Deposited $%.2f into account %s. New balance: $%.2f%n", amount, accountNumber, newBalance);
    }

    /**
     * Submits a withdrawal request for an account. The request is queued.
     *
     * @param accountNumber The account number requesting withdrawal.
     */
    public void requestWithdrawal(String accountNumber) {
        if (!accountsHashMap.containsKey(accountNumber)) {
            System.out.println("Error: Account " + accountNumber + " not found. Cannot submit withdrawal request.");
            return;
        }
        withdrawalRequestQueue.add(accountNumber);
        System.out.println("Withdrawal request for account " + accountNumber + " queued.");
    }

    /**
     * Processes the next withdrawal request in the queue.
     *
     * @param amount The amount to withdraw.
     */
    public void processNextWithdrawal(double amount) {
        if (withdrawalRequestQueue.isEmpty()) {
            System.out.println("No pending withdrawal requests.");
            return;
        }
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be positive.");
            withdrawalRequestQueue.remove(); // Remove invalid request
            return;
        }

        String accountNumber = withdrawalRequestQueue.remove();
        double currentBalance = accountsHashMap.get(accountNumber);

        if (currentBalance >= amount) {
            double oldBalance = currentBalance;
            double newBalance = currentBalance - amount;

            // Update HashMap
            accountsHashMap.put(accountNumber, newBalance);

            // Update TreeMap: remove old balance entry, add new balance entry
            accountsByBalanceTreeMap.get(oldBalance).remove(accountNumber);
            if (accountsByBalanceTreeMap.get(oldBalance).isEmpty()) {
                accountsByBalanceTreeMap.remove(oldBalance);
            }
            accountsByBalanceTreeMap.computeIfAbsent(newBalance, k -> new LinkedList<>()).add(accountNumber);

            System.out.printf("Successfully withdrew $%.2f from account %s. New balance: $%.2f%n", amount, accountNumber, newBalance);
        } else {
            System.out.printf("Withdrawal failed for account %s: Insufficient funds. Current balance: $%.2f%n", accountNumber, currentBalance);
        }
    }

    /**
     * Displays all customer accounts and their balances (no specific order).
     */
    public void displayAllAccounts() {
        System.out.println("\n--- All Customer Accounts (HashMap) ---");
        if (accountsHashMap.isEmpty()) {
            System.out.println("No accounts in the system.");
            return;
        }
        for (Map.Entry<String, Double> entry : accountsHashMap.entrySet()) {
            System.out.printf("Account: %s, Balance: $%.2f%n", entry.getKey(), entry.getValue());
        }
    }

    /**
     * Displays customer accounts sorted by their balance (ascending).
     */
    public void displayAccountsSortedByBalance() {
        System.out.println("\n--- Customer Accounts (Sorted by Balance - TreeMap) ---");
        if (accountsByBalanceTreeMap.isEmpty()) {
            System.out.println("No accounts in the system.");
            return;
        }
        for (Map.Entry<Double, LinkedList<String>> entry : accountsByBalanceTreeMap.entrySet()) {
            double balance = entry.getKey();
            LinkedList<String> accounts = entry.getValue();
            for (String accountNumber : accounts) {
                System.out.printf("Account: %s, Balance: $%.2f%n", accountNumber, balance);
            }
        }
    }

    /**
     * Displays the current withdrawal request queue.
     */
    public void displayWithdrawalQueue() {
        System.out.println("\n--- Pending Withdrawal Requests (Queue) ---");
        if (withdrawalRequestQueue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        System.out.println("Requests in order: " + withdrawalRequestQueue);
    }

    public static void main(String[] args) {
        BankingSystem bankingSystem = new BankingSystem();

        // Create Accounts
        bankingSystem.createAccount("ACC101", 1500.00);
        bankingSystem.createAccount("ACC102", 500.00);
        bankingSystem.createAccount("ACC103", 2500.00);
        bankingSystem.createAccount("ACC104", 500.00); // Same balance as ACC102

        // Display initial state
        bankingSystem.displayAllAccounts();
        bankingSystem.displayAccountsSortedByBalance();
        bankingSystem.displayWithdrawalQueue();

        // Perform some deposits
        bankingSystem.deposit("ACC101", 300.00);
        bankingSystem.deposit("ACC102", 1000.00); // Balance changes, should re-sort in TreeMap

        bankingSystem.displayAllAccounts();
        bankingSystem.displayAccountsSortedByBalance();

        // Submit withdrawal requests
        bankingSystem.requestWithdrawal("ACC103");
        bankingSystem.requestWithdrawal("ACC101");
        bankingSystem.requestWithdrawal("ACC102"); // Will fail due to insufficient funds later

        bankingSystem.displayWithdrawalQueue();

        // Process withdrawal requests
        bankingSystem.processNextWithdrawal(2000.00); // Process ACC103
        bankingSystem.processNextWithdrawal(500.00);  // Process ACC101
        bankingSystem.processNextWithdrawal(1500.00); // Process ACC102 (will fail)

        bankingSystem.displayAllAccounts();
        bankingSystem.displayAccountsSortedByBalance();
        bankingSystem.displayWithdrawalQueue(); // Should