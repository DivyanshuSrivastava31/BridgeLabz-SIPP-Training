interface Vehicle {
    void displaySpeed();

    default void displayBattery() {
        System.out.println("Battery info not available.");
    }
}

class ElectricCar implements Vehicle {
    public void displaySpeed() { System.out.println("Speed: 80 km/h"); }
    public void displayBattery() { System.out.println("Battery: 75%"); }
}

class NormalCar implements Vehicle {
    public void displaySpeed() { System.out.println("Speed: 100 km/h"); }
}

public class SmartVehicleDemo {
    public static void main(String[] args) {
        Vehicle v1 = new ElectricCar();
        v1.displaySpeed();
        v1.displayBattery();

        Vehicle v2 = new NormalCar();
        v2.displaySpeed();
        v2.displayBattery();
    }
}