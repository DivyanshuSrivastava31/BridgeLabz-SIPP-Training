//Import Scanner Class from util Package
import java.util.Scanner;
//Computing distance into yards and miles from feet
public class DistanceConverter {
    public static void main(String[] args) {
	//Object of Scanner class
        Scanner sc = new Scanner(System.in);
	//Taking Distance input in feet from user
        double distanceInFeet = sc.nextDouble();
	//Converting Distance in feet to Distance in yards
        double distanceInYards = distanceInFeet / 3;
	//Converting Distance in feet to Distance in miles
        double distanceInMiles = distanceInFeet / 5280;
	//Printing Distance in yards
        System.out.println("Distance in yards: " + distanceInYards);
	//Printing Distance in miles
        System.out.println("Distance in miles: " + distanceInMiles);
    }
}
