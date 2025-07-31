import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamCommunication {

    public static void main(String[] args) {
        try {
            final PipedOutputStream pout = new PipedOutputStream();
            final PipedInputStream pin = new PipedInputStream(pout);

            Thread writerThread = new Thread(() -> {
                try {
                    System.out.println("Writer Thread: Starting to write data.");
                    for (int i = 0; i < 5; i++) {
                        String data = "Hello from Writer " + i + "\n";
                        pout.write(data.getBytes());
                        System.out.println("Writer Thread: Wrote -> " + data.trim());
                        Thread.sleep(500); // Simulate some work
                    }
                    pout.close(); // Important to close the output stream when done
                    System.out.println("Writer Thread: Finished writing and closed the stream.");
                } catch (IOException | InterruptedException e) {
                    System.err.println("Writer Thread Error: " + e.getMessage());
                }
            });

            Thread readerThread = new Thread(() -> {
                try {
                    System.out.println("Reader Thread: Starting to read data.");
                    int data;
                    StringBuilder receivedData = new StringBuilder();
                    while ((data = pin.read()) != -1) {
                        receivedData.append((char) data);
                        if ((char) data == '\n') {
                            System.out.println("Reader Thread: Read -> " + receivedData.toString().trim());
                            receivedData.setLength(0); // Clear for next line
                        }
                    }
                    pin.close(); // Important to close the input stream when done
                    System.out.println("Reader Thread: Finished reading and closed the stream.");
                } catch (IOException e) {
                    System.err.println("Reader Thread Error: " + e.getMessage());
                }
            });

            writerThread.start();
            readerThread.start();

            // Wait for both threads to finish
            writerThread.join();
            readerThread.join();

            System.out.println("Main Thread: Both writer and reader threads have completed.");

        } catch (IOException | InterruptedException e) {
            System.err.println("Main Thread Error: " + e.getMessage());
        }
    }
}