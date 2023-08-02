import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = sc.nextInt();
		
		n=Math.abs(n);
		
		System.out.println(s.charAt(n-1));
	}
}