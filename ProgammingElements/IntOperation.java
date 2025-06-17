//Importing Scanner Class from util package
import java.util.Scanner;
//Computing Operations on the Integer numbers
public class IntOperation {
    public static void main(String[] args) {
	//Creating object of Scanner Class
        Scanner sc = new Scanner(System.in);
	//Taking input number one from user
        int a = sc.nextInt();
	//Taking input number two from user
        int b = sc.nextInt();
	//Taking input number three from user
        int c = sc.nextInt();
	//Performing all the four operations as mentioned on the three numbers
        int res1 = a + b * c;
        int res2 = a * b + c;
        int res3 = c + a / b;
        int res4 = a % b + c;
	//Printing results of all the four operations
        System.out.println("Results: " + res1 + ", " + res2 + ", " + res3 + ", " + res4);
    }
}
