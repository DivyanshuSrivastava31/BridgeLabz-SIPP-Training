interface SecurityUtils {
    static boolean isStrongPassword(String pwd) {
        return pwd.length() >= 8 && pwd.matches(".*[0-9].*") && pwd.matches(".*[A-Z].*");
    }
}

public class PasswordTest {
    public static void main(String[] args) {
        System.out.println(SecurityUtils.isStrongPassword("Weak1")); 
        System.out.println(SecurityUtils.isStrongPassword("StrongPass1")); 
    }
}