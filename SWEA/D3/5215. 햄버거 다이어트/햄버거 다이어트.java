import java.util.Scanner;

public class Solution {
	
	static int N,L,ans;
	static boolean[] chk;
	static int[] score, kcal;
	
	public static void powerset(int idx) {
		
		if(idx == N) {
			
			int ksum = 0;
			int ssum = 0;
			
			for(int i=0; i<N; i++) {
				if(chk[i]) {
					ksum+=kcal[i];	
					ssum+=score[i];
				}
			}
			
			if(ksum<=L) {
				ans = Math.max(ans, ssum);
			}
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
			N = scanner.nextInt(); // 재료 개수
			L = scanner.nextInt(); // 허용되는 칼로리
			ans=0;
			score = new int[N];
			kcal = new int[N];
			chk = new boolean[N];
			
			for(int i=0; i<N; i++) {
				score[i] = scanner.nextInt();
				kcal[i] = scanner.nextInt();
			}
			powerset(0);
			System.out.println("#" + testCase + " " + ans);
		}
		
	}
	
}