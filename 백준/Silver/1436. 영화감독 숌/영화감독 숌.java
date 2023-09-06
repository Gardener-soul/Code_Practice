import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		
		int n = 666;
		int cnt = 1;
		
		while(cnt!=N) {
			
			n++;
			
			if(String.valueOf(n).contains("666")) {
				cnt++;
			}
		}
		System.out.println(n);
	}
	
}