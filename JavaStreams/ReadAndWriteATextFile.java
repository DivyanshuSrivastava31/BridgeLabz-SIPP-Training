import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;

public class FileReadWrite {

    public static void main(String[] args) {
        String sourceFilePath = "source.txt"; // Replace with your source file path
        String destinationFilePath = "destination.txt"; // Replace with your destination file path

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                System.out.println("Error: Source file '" + sourceFilePath + "' does not exist.");
                return;
            }

            fis = new FileInputStream(sourceFile);
            fos = new FileOutputStream(destinationFilePath);

            byte[] buffer = new byte;
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully from '" + sourceFilePath + "' to '" + destinationFilePath + "'.");

        } catch (FileNotFoundException e) {
            // This specific catch for FileNotFoundException on the source file is handled above,
            // but keeping it here for completeness if other FileNotFound scenarios arise.
            System.err.println("Error: File not found. " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error during file operation: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}