import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;

public class ImageToByteArray {

    public static void main(String[] args) {
        String originalImagePath = "input_image.jpg"; // Replace with your input image path
        String outputImagePath = "output_image.jpg"; // Path for the new image file

        // Create a dummy image file for testing if it doesn't exist
        createDummyImageFile(originalImagePath);

        byte[] imageData = null;

        System.out.println("--- Converting Image to Byte Array and Back ---");

        // Step 1: Read image into a byte array using ByteArrayOutputStream
        try (FileInputStream fis = new FileInputStream(originalImagePath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte; // Read in chunks of 4KB
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            imageData = baos.toByteArray();
            System.out.println("Image '" + originalImagePath + "' successfully converted to byte array. Size: " + imageData.length + " bytes.");

        } catch (IOException e) {
            System.err.println("Error reading image into byte array: " + e.getMessage());
            return; // Exit if initial read fails
        }

        // Step 2: Write byte array back to a new image file using ByteArrayInputStream
        if (imageData != null) {
            try (ByteArrayInputStream bais = new ByteArrayInputStream(imageData);
                 FileOutputStream fos = new FileOutputStream(outputImagePath)) {

                byte[] buffer = new byte; // Write in chunks of 4KB
                int bytesRead;
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
                System.out.println("Byte array successfully written back to image file: '" + outputImagePath + "'.");

            } catch (IOException e) {
                System.err.println("Error writing byte array to image file: " + e.getMessage());
            }
        }

        // Step 3: Verify that the new file is identical to the original image
        System.out.println("\n--- Verifying File Identity ---");
        try {
            File originalFile = new File(originalImagePath);
            File outputFile = new File(outputImagePath);

            if (!originalFile.exists() || !outputFile.exists()) {
                System.out.println("Cannot verify: One or both files do not exist.");
            } else if (originalFile.length() != outputFile.length()) {
                System.out.println("Verification FAILED: File sizes do not match.");
                System.out.println("Original size: " + originalFile.length() + " bytes");
                System.out.println("Output size: " + outputFile.length() + " bytes");
            } else {
                byte[] originalBytes = Files.readAllBytes(originalFile.toPath());
                byte[] outputBytes = Files.readAllBytes(outputFile.toPath());

                if (Arrays.equals(originalBytes, outputBytes)) {
                    System.out.println("Verification SUCCESS: Both files are identical!");
                } else {
                    System.out.println("Verification FAILED: File contents do not match.");
                }
            }
        } catch (IOException e) {
            System.err.println("Error during file verification: " + e.getMessage());
        }
    }

    // Helper method to create a dummy image file if it doesn't exist
    // This creates a very simple 1x1 black JPEG for demonstration purposes.
    // For real testing, you should place an actual image file named "input_image.jpg"
    // in the same directory as your compiled Java class.
    private static void createDummyImageFile(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Creating a dummy image file for demonstration: " + filePath);
            // Minimal JPEG data for a 1x1 black image
            byte[] dummyJpegData = {
                (byte) 0xFF, (byte) 0xD8, // SOI
                (byte) 0xFF, (byte) 0xE0, (byte) 0x00, (byte) 0x10, (byte) 0x4A, (byte) 0x46, (byte) 0x49, (byte) 0x46, // APP0
                (byte) 0x00, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, // JFIF info
                (byte) 0x00, (byte) 0x00,
                (byte) 0xFF, (byte) 0xDB, (byte) 0x00, (byte) 0x43, // DQT
                (byte) 0x00, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, // Q_table
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x01,
                (byte) 0x01,
                (byte) 0xFF, (byte) 0xC0, (byte) 0x00, (byte) 0x11, (byte) 0x08, (byte) 0x00, (byte) 0x01, (byte) 0x00, (byte) 0x01, // SOF0 (1x1 image)
                (byte) 0x03, (byte) 0x01, (byte) 0x22, (byte) 0x00, (byte