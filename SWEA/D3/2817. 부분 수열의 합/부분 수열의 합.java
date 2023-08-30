import java.util.Scanner;

public class Solution {
	
	static int[] num;
	static int k;
	static boolean[] chk;
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase <= T; testCase++) {
		
			int N = scanner.nextInt();
			int K = scanner.nextInt();
			
			cnt = 0;
			num = new int [N];
			k = K;
			chk = new boolean [N];
			
			for(int i=0; i<N; i++) {
				num[i] = scanner.nextInt();
			}
			
			sum(0);
			System.out.println("#" + testCase + " " + cnt);
				
			}
			
		}
	
	static void sum(int idx) {
		
		
		if(idx==num.length) {			
			int sum=0;
			for(int i=0; i<num.length; i++) {
				if(chk[i]) {
					sum+=num[i];
				}
			}
			
			if(sum==k) {
				cnt++;
			}
			
			return;
		}
		
		chk[idx] = false;
		sum(idx+1);
		
		chk[idx] = true;
		sum(idx+1);
		
	}
}