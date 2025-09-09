import java.util.*;
import java.util.stream.*;

class Movie {
    String title;
    double rating;
    int year;

    Movie(String title, double rating, int year) {
        this.title = title;
        this.rating = rating;
        this.year = year;
    }

    public String toString() {
        return title + " (" + year + ") - Rating: " + rating;
    }
}

public class TrendingMovies {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
            new Movie("Movie A", 8.5, 2023),
            new Movie("Movie B", 9.0, 2024),
            new Movie("Movie C", 7.5, 2022),
            new Movie("Movie D", 9.2, 2024),
            new Movie("Movie E", 8.8, 2023),
            new Movie("Movie F", 9.1, 2024)
        );

        movies.stream()
              .sorted(Comparator.comparingDouble((Movie m) -> m.rating)
                      .thenComparingInt(m -> m.year).reversed())
              .limit(5)
              .forEach(System.out::println);
    }
}