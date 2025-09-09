import java.lang.reflect.*;

class Task {
    public void runTask() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("Task completed.");
    }
}

public class MethodExecutionTimer {
    public static void main(String[] args) throws Exception {
        Task task = new Task();

        Method method = Task.class.getMethod("runTask");

        long start = System.currentTimeMillis();
        method.invoke(task);
        long end = System.currentTimeMillis();

        System.out.println("Execution Time: " + (end - start) + " ms");
    }
}
