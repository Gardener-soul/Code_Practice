import java.util.Arrays;
import java.util.Scanner;
	
public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int K = scanner.nextInt(); // 나오는 값
		int[] num = new int[N];
			
		for(int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
			
		int[] pri = new int[K+1];
		Arrays.fill(pri, 10001);
		pri[0] = 0;
			
		for(int i=0; i<N; i++) {
			
			for(int j=num[i]; j<=K; j++) {
					
				pri[j] = Math.min(pri[j], pri[j-num[i]] + 1);
				
			}
				
		}
			
		if(pri[K]==10001) {
			System.out.println(-1);
		}else {
			System.out.println(pri[K]);
		}
	}
}