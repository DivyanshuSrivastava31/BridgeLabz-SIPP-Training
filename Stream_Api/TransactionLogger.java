import java.util.*;

public class TransactionLogger {
    public static void main(String[] args) {
        List<String> transactions = Arrays.asList("TXN1001", "TXN1002", "TXN1003");

        transactions.forEach(txn -> System.out.println("Logging Transaction: " + txn));
    }
}