import java.util.*;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		
		if(a>b) {
			System.out.println(a-b);
		} else if (a==b) {
			System.out.println(0);
		} else if (a<b) {
		System.out.println(Math.abs(a-b));
		}
	}
}