import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.stream.*;

class Member {
    String name;
    LocalDate expiry;

    Member(String name, LocalDate expiry) {
        this.name = name;
        this.expiry = expiry;
    }

    public String toString() {
        return name + " (Expires: " + expiry + ")";
    }
}

public class ExpiringMemberships {
    public static void main(String[] args) {
        List<Member> members = Arrays.asList(
            new Member("Alice", LocalDate.now().plusDays(10)),
            new Member("Bob", LocalDate.now().plusDays(40)),
            new Member("Charlie", LocalDate.now().plusDays(20))
        );

        members.stream()
               .filter(m -> ChronoUnit.DAYS.between(LocalDate.now(), m.expiry) <= 30)
               .forEach(System.out::println);
    }
}