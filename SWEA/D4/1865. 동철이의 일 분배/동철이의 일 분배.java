import java.util.Scanner;

public class Solution {
	
	static int N;
	static double max;
	static boolean[] chk;
	static int[][] map;
	
	public static void perm(int idx, double sum) {
		
		if(max>=sum)return;
		
		if(idx == N) {
			
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(chk[i]) continue;
			chk[i] = true;
			perm(idx+1, sum*map[idx][i]*0.01);
			chk[i] = false;
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt();
			map = new int[N][N];
			chk = new boolean[N];
			max = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = scanner.nextInt();
				}
			}
			
			perm(0,100);
			
			System.out.printf("#" + testCase + " "+ "%.6f",max);
			System.out.println();
		}
	}
}