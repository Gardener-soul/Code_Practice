import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static boolean[] sosu;
	
	public static void sosu() {
		
		sosu[0] = sosu[1] = true;
		
		for(int i=2; i<=Math.sqrt(sosu.length); i++) {
			if(sosu[i]) continue;
			for(int j=i*i; j<sosu.length; j+=i) {
				sosu[j] = true;
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		
		sosu = new boolean[M+1];
		
		sosu();
		for(int i=N; i<=M; i++) {
			if(!sosu[i]) {
				System.out.println(i);
			}
		}
		
	}
	
}