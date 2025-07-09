class PetrolPump {
    int petrol;
    int distance;

    public PetrolPump(int petrol, int distance) {
        this.petrol = petrol;
        this.distance = distance;
    }
}

public class CircularTour {

    public static int findStartingPoint(PetrolPump[] pumps) {
        int n = pumps.length;

        int start = 0;
        int totalSurplus = 0;
        int currentSurplus = 0;

        for (int i = 0; i < n; i++) {
            int gain = pumps[i].petrol - pumps[i].distance;
            totalSurplus += gain;
            currentSurplus += gain;

            // If currentSurplus is negative, can't travel from start to i
            if (currentSurplus < 0) {
                start = i + 1;         // Try next pump as starting point
                currentSurplus = 0;    // Reset surplus
            }
        }

        // If totalSurplus is negative, no solution exists
        return (totalSurplus >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };

        int startIndex = findStartingPoint(pumps);
        if (startIndex != -1) {
            System.out.println("Start at petrol pump index: " + startIndex);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
