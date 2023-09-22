import java.util.Scanner;

public class Solution {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][] chk;
	
	public static void dfs(int x, int y) {
		
		for(int d=0; d<4; d++) {
			int tr = x + dr[d];
			int tc = y + dc[d];
			
			if(tr<100 && tc<100 && tr>=0 && tc>=0) {
			
				if(!chk[tr][tc] && (map[tr][tc]== '0' || map[tr][tc] =='3')) {
					chk[tr][tc] = true;
					map[tr][tc] = '1';
					dfs(tr,tc);
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase <= 10; testCase++) {
			
			int T = scanner.nextInt(); // 의미없는 숫자 값.
			
			map = new char[100][100];
			chk = new boolean[100][100];
			
			for(int i=0; i<100; i++) {
				map[i] = scanner.next().toCharArray();
			}
			
			int r = 0;
			int c = 0;
			
			outer : for(r = 0; r<100; r++) {
				for (c=0; c<100; c++) {
					if(map[r][c]=='3') {
						break outer;
					}
				}
			}
			
			chk[1][1] = true;
			map[1][1] = '1';
			dfs(1,1);
			
			int ans = 0;
			if(chk[r][c]) {
				ans=1;
			}
			
			System.out.println("#" + testCase + " " + ans);
			
		}
		
	}
	
}