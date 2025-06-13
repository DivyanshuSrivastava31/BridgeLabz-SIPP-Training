//Calculating Earth Volume inn cubic kilometers and cubic miles
public class EarthVolume {
    public static void main(String[] args) {
        // Radius of the Earth in kilometers
        double radiusKm = 6378;

        // Conversion factor: 1 km = 0.621371 miles
        double kmToMiles = 0.621371;

        // Calculate volume in cubic kilometers using the formula (4/3) * pi * r^3
        double volumeKm3 = (4.0 / 3.0) * Math.PI * Math.pow(radiusKm, 3);

        // Convert cubic kilometers to cubic miles
        double volumeMiles3 = volumeKm3 * Math.pow(kmToMiles, 3);

        // Output the result
        System.out.println("The volume of earth in cubic kilometers is " + volumeKm3 +
                           " and cubic miles is " + volumeMiles3);
    }
}
