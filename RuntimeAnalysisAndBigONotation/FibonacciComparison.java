public class FibonacciComparison {

    // Naive recursive Fibonacci
    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    // Iterative Fibonacci
    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    // Measure execution time
    public static void compareFibonacci(int n) {
        System.out.println("\nFibonacci(" + n + "):");

        if (n <= 40) {  // Prevent huge delays
            long start = System.nanoTime();
            int rec = fibonacciRecursive(n);
            long end = System.nanoTime();
            System.out.println("Recursive Result: " + rec);
            System.out.println("Recursive Time: " + (end - start) / 1_000_000.0 + " ms");
        } else {
            System.out.println("Recursive Time: Skipped (too slow)");
        }

        long start = System.nanoTime();
        int iter = fibonacciIterative(n);
        long end = System.nanoTime();
        System.out.println("Iterative Result: " + iter);
        System.out.println("Iterative Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        compareFibonacci(10);
        compareFibonacci(30);
        compareFibonacci(50);  // Skip recursion for large n
    }
}
