import java.util.Scanner;
public class _3Celsius_to_Fahrenheit {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double celsius = sc.nextDouble(); 
        double fahrenheit = (celsius * 9/5) + 32;
        System.out.println(celsius + " degrees Celsius is equal to " + fahrenheit + " degrees Fahrenheit.");
    }
    
}