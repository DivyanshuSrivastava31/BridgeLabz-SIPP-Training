import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class BufferedFileCopy {

    private static final int BUFFER_SIZE = 4096; // 4 KB

    public static void main(String[] args) {
        String sourceFilePath = "large_source.txt"; // Replace with your large source file path
        String destBufferedPath = "dest_buffered.txt";
        String destUnbufferedPath = "dest_unbuffered.txt";

        // Create a dummy large file for testing if it doesn't exist
        createDummyLargeFile(sourceFilePath, 100 * 1024 * 1024); // 100 MB

        System.out.println("--- Comparing Buffered vs. Unbuffered File Copy ---");

        // Copy with Buffered Streams
        long bufferedStartTime = System.nanoTime();
        copyFileBuffered(sourceFilePath, destBufferedPath);
        long bufferedEndTime = System.nanoTime();
        long bufferedDuration = (bufferedEndTime - bufferedStartTime) / 1_000_000; // milliseconds
        System.out.println("Buffered copy time: " + bufferedDuration + " ms");

        System.out.println("\n-------------------------------------------------\n");

        // Copy with Unbuffered Streams
        long unbufferedStartTime = System.nanoTime();
        copyFileUnbuffered(sourceFilePath, destUnbufferedPath);
        long unbufferedEndTime = System.nanoTime();
        long unbufferedDuration = (unbufferedEndTime - unbufferedStartTime) / 1_000_000; // milliseconds
        System.out.println("Unbuffered copy time: " + unbufferedDuration + " ms");

        System.out.println("\nComparison complete. Check " + destBufferedPath + " and " + destUnbufferedPath);
    }

    private static void copyFileBuffered(String sourcePath, String destPath) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourcePath), BUFFER_SIZE);
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destPath), BUFFER_SIZE)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("Buffered copy successful from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.err.println("Error during buffered file copy: " + e.getMessage());
        }
    }

    private static void copyFileUnbuffered(String sourcePath, String destPath) {
        try (FileInputStream fis = new FileInputStream(sourcePath);
             FileOutputStream fos = new FileOutputStream(destPath)) {

            byte[] buffer = new byte[BUFFER_SIZE]; // Still using a buffer for chunking, but without BufferedInputStream/OutputStream
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("Unbuffered copy successful from " + sourcePath + " to " + destPath);
        } catch (IOException e) {
            System.err.println("Error during unbuffered file copy: " + e.getMessage());
        }
    }

    private static void createDummyLargeFile(String filePath, long sizeInBytes) {
        File file = new File(filePath);
        if (file.exists() && file.length() == sizeInBytes) {
            System.out.println("Dummy large file already exists and is of correct size: " + filePath);
            return;
        }

        System.out.println("Creating a dummy large file: " + filePath + " (" + (sizeInBytes / (1024 * 1024)) + " MB)");
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            byte[] data = new byte[BUFFER_SIZE];
            for (int i = 0; i < BUFFER_SIZE; i++) {
                data[i] = (byte) (i % 256); // Fill with some dummy data
            }

            long bytesWritten = 0;
            while (bytesWritten < sizeInBytes) {
                long bytesToWrite = Math.min(BUFFER_SIZE, sizeInBytes - bytesWritten);
                fos.write(data, 0, (int) bytesToWrite);
                bytesWritten += bytesToWrite;
            }
            System.out.println("Dummy large file created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating dummy large file: " + e.getMessage());
        }
    }
}