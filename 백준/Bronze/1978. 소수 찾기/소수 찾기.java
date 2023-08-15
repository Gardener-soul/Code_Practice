import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int ans = 0;
		for(int testCase = 1; testCase <=N; testCase++) {
			int sosu = scanner.nextInt();
			int cnt=0;
			for(int i=1; i<=1000; i++) {
				if(sosu%i==0) {
					cnt++;
				}
			}
			if(cnt==2) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
