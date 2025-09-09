import java.util.*;

public class SensorReadings {
    public static void main(String[] args) {
        List<Integer> readings = Arrays.asList(30, 55, 70, 25, 80);
        readings.stream()
                .filter(r -> r > 50)
                .forEach(r -> System.out.println("High reading: " + r));
    }
}