import java.util.Scanner;

public class Solution {
	static int N,A, cnt;
	static int[] num;
	static boolean[] chk;
	
	public static void powerset(int idx) {
		
		int sum = 0;
		
		if(idx==N) {
			
			for(int i=0; i<N; i++) {
				if(chk[i]) {
					
					sum+=num[i];
					
				}
			}
			
			if(sum==A) cnt++;
			
			return;
		}
		
		chk[idx] = false;
		powerset(idx+1);
		
		chk[idx] = true;
		powerset(idx+1);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt();
			A = scanner.nextInt(); // 나와야 하는 수
			num = new int[N];
			chk = new boolean[N];
			cnt = 0;
			
			for(int i=0; i<N; i++) {
				num[i] = scanner.nextInt();
			}
			powerset(0);
			System.out.println("#" + testCase+" " + cnt);
		}
	}
}