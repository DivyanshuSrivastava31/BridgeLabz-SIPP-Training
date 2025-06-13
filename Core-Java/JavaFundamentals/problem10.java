import java.util.Scanner;

public class _10_Kilometers_to_Miles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double kilometers = sc.nextDouble();
        double miles = kilometers * 0.621371;
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");
    }
}
