import java.util.*;
public class _5VolumeOfcylinder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int radius = sc.nextInt();
        int height = sc.nextInt();
        double volume = Math.PI * radius * radius * height;
        System.out.println("The volume of the cylinder with radius " + radius + " and height " + height + " is: " + volume);
    }
}
