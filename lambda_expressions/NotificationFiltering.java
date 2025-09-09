// Lambda Example 3: Notification Filtering
import java.util.*;
import java.util.function.Predicate;

public class NotificationFiltering {
    public static void main(String[] args) {
        List<String> alerts = Arrays.asList(
                "Emergency: Heart Attack",
                "Normal: Appointment Reminder",
                "Critical: ICU Needed",
                "Info: General Checkup"
        );

        // Predicate for filtering only critical/emergency alerts
        Predicate<String> filter = alert -> alert.contains("Emergency") || alert.contains("Critical");

        System.out.println("Filtered Alerts:");
        alerts.stream()
              .filter(filter)
              .forEach(System.out::println);
    }
}