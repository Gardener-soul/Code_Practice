import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static int[][] map;
	static boolean[][] chk;
	static int cnt;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	static void dfs(int day, int x, int y) {
		
		chk[x][y] = true;
		
		for(int d=0; d<4; d++) {
			
			int tx = x + dr[d];
			int ty = y + dc[d];
			if(tx<N && ty<N && tx>=0 && ty>=0) {
				if(!chk[tx][ty]&&map[tx][ty]>day) {
					dfs(day, tx,ty);
				}
			}			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			
			N = scanner.nextInt();
			map = new int[N][N];
			
			int datmax = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = scanner.nextInt();
					datmax = Math.max(map[r][c], datmax);
				}
			}

			int max = 0;
			
			for(int day=0; day<=datmax; day++) {
				chk = new boolean[N][N];
				cnt = 0;
				for(int r=0; r<N; r++) {
					for(int c=0; c<N; c++) {
						if(!chk[r][c]&&map[r][c]>day) {
							dfs(day,r,c);
							cnt++;
						}
					}
				}
				max = Math.max(max, cnt);
			}
			
			System.out.println("#" + testCase + " " + max);
			
		}
		
	}
}