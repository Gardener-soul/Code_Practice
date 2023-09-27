import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			
			int N = scanner.nextInt(); // N개의 물건
			int K = scanner.nextInt(); // K의 부피
			
			int[] wei = new int[N+1]; // 부피
			int[] pri = new int[N+1]; // 가치
			
			for(int i=1; i<=N; i++) {
				wei[i] = scanner.nextInt(); 
				pri[i] = scanner.nextInt();
			}
			
			int[][] dp = new int[N+1][K+1];
			
			for(int i=1; i<=N; i++) {
				for(int w=0; w<=K; w++) {
					if(wei[i]<=w) {
						dp[i][w] = Math.max(dp[i-1][w],dp[i-1][w-wei[i]] + pri[i]);
					} else {
						dp[i][w] = dp[i-1][w];
					}
				}
			}
			System.out.println("#" + testCase + " " + dp[N][K]);
		}
		
	}
}