import java.util.function.Predicate;

public class TemperatureAlert {
    public static void main(String[] args) {
        Predicate<Double> highTemp = temp -> temp > 40.0;
        double current = 42.5;
        if (highTemp.test(current)) {
            System.out.println("ALERT: High Temperature!");
        }
    }
}