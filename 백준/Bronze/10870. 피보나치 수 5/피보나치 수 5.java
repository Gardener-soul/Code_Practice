import java.util.Scanner;

public class Main {
	
	static int n;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		System.out.println(sum(n));
		
	}
	
	static int sum(int n) {
		
		if(n==1) return 1;
		if(n==0) return 0;
		
		return sum(n-1) + sum(n-2);
		
	}
	
}