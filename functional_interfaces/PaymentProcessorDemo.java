interface PaymentProcessor {
    void process(double amount);

    default void refund(double amount) {
        System.out.println("Refund of " + amount + " initiated.");
    }
}

class Paytm implements PaymentProcessor {
    public void process(double amount) { System.out.println("Processed payment of " + amount + " via Paytm"); }
}

public class PaymentProcessorDemo {
    public static void main(String[] args) {
        PaymentProcessor p = new Paytm();
        p.process(1000);
        p.refund(500);
    }
}