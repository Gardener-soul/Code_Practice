import java.util.Scanner;

public class Solution {
	
	static int R,C,max;
	static boolean[] chk;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	
	public static void dfs(int r, int c, int level) {
		
		for(int d=0; d<4; d++) {
			int tr = r + dr[d];
			int tc = c + dc[d];
			
			if(tr<R && tc<C && tr>=0 && tc>=0 && !chk[map[tr][tc]-'A']) {
				
				chk[map[tr][tc]-'A'] = true;
				dfs(tr,tc,level+1);
				chk[map[tr][tc]-'A'] = false;
				
			}
			
		}
		max = Math.max(max, level);
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			R = scanner.nextInt();
			C = scanner.nextInt();
			map = new char[R][C];
			chk = new boolean[26];
			
			for(int r=0; r<R; r++) {
				String tmp = scanner.next();
				for(int c=0; c<C; c++) {
					map[r][c] = tmp.charAt(c);
				}
			}
			max = 0;
			chk[map[0][0]-'A'] = true;
			dfs(0,0,1);
			
			System.out.println("#" + testCase + " " + max);
		}
		
	}
}