import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int n=scanner.nextInt();
		long sum = Facto(n);
		
		System.out.println(sum);
		
	}
	
	static long Facto(int n) {
		
		if(n<=1) return 1;
		
		return n*Facto(n-1);
		
	}
	
}
