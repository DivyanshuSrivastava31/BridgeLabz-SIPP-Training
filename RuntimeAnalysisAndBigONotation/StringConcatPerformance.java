public class StringConcatPerformance {

    public static void stringConcat(int N) {
        long start = System.nanoTime();
        String result = "";
        for (int i = 0; i < N; i++) {
            result += "a";
        }
        long end = System.nanoTime();
        System.out.println("String Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void stringBuilderConcat(int N) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("StringBuilder Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void stringBufferConcat(int N) {
        long start = System.nanoTime();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            sb.append("a");
        }
        long end = System.nanoTime();
        System.out.println("StringBuffer Time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static void main(String[] args) {
        int[] testCases = {1_000, 10_000, 1_000_000};

        for (int N : testCases) {
            System.out.println("\nConcatenating " + N + " strings:");

            if (N <= 10_000) { // Skip large string concat due to slowness
                stringConcat(N);
            } else {
                System.out.println("String Time: Skipped (too slow)");
            }

            stringBuilderConcat(N);
            stringBufferConcat(N);
        }
    }
}
