import java.util.*;
import java.util.stream.*;

class Claim {
    String type;
    double amount;

    Claim(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }
}

public class ClaimAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("Health", 5000),
            new Claim("Car", 2000),
            new Claim("Health", 7000),
            new Claim("Car", 4000),
            new Claim("Home", 10000)
        );

        Map<String, Double> avgClaims = claims.stream()
            .collect(Collectors.groupingBy(c -> c.type,
                    Collectors.averagingDouble(c -> c.amount)));

        avgClaims.forEach((type, avg) -> 
            System.out.println(type + " Avg Claim: " + avg));
    }
}