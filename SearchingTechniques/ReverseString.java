import java.util.Scanner;
// Reversing a string using StringBuilder
public class ReverseString
{
	public static void main(String... args)
	{
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		// Stringbuilder
		StringBuilder sb = new StringBuilder(text);
		sb.reverse();
		System.out.println(sb);
	}
}