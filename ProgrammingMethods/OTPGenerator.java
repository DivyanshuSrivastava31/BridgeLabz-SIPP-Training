// Importing Random class from util package
import java.util.Random;
// Compute to generate 10 otps which are unique from each other
public class OTPGenerator 
{

    // Generate one 6-digit OTP
    public static int generateOTP()
    {
        return 100000 + new Random().nextInt(900000); // 100000 to 999999
    }

    // Check if OTP already exists in array
    public static boolean isDuplicate(int[] otps, int currentSize, int newOtp)
    {
        for (int i = 0; i < currentSize; i++) 
	{
            if (otps[i] == newOtp) return true;
        }
        return false;
    }

    // Generate 10 unique OTPs
    public static int[] generateUniqueOTPs(int count)
    {
        int[] otps = new int[count];
        int index = 0;

        while (index < count) 
	{
            int otp = generateOTP();
            if (!isDuplicate(otps, index, otp))
	    {
                otps[index] = otp;
                index++;
            }
        }

        return otps;
    }

    public static void main(String... args) 
    {
	// Declaring an array to store otps
        int[] otps = generateUniqueOTPs(10);
	// Displaying otps
        System.out.println("Generated 10 Unique OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

        // Verifying uniqueness manually
        boolean unique = true;
        for (int i = 0; i < otps.length; i++) 
	{
            for (int j = i + 1; j < otps.length; j++)
	    {
                if (otps[i] == otps[j])
		{
                    unique = false;
                    break;
                }
            }
        }

        System.out.println("Are all OTPs unique? " + unique);
    }
}
