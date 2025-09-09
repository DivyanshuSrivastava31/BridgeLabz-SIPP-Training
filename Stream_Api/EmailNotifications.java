import java.util.*;

public class EmailNotifications {
    public static void main(String[] args) {
        List<String> emails = Arrays.asList("a@mail.com", "b@mail.com", "c@mail.com");

        emails.forEach(email -> sendEmailNotification(email));
    }

    static void sendEmailNotification(String email) {
        System.out.println("Notification sent to: " + email);
    }
}