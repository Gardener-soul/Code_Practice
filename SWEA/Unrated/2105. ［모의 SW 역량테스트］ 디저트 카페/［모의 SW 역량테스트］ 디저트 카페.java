import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N, max, stR, stC;
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static boolean[] dessert;
	static int[][] map;
	static boolean[][] chk;
	
	public static void dfs(int cnt, int r, int c, int stR, int stC, int prevD) {

		for(int d=prevD; d<4; d++) {
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if(nr>=0 && nc>=0 && nr<N && nc<N) {
				
				if(nr==stR && nc==stC && cnt>2) {
					max = Math.max(max, cnt);
					return;
				}
				
				if(!chk[nr][nc] && !dessert[map[nr][nc]]) {
					chk[nr][nc] = true;
					dessert[map[nr][nc]] = true;
					dfs(cnt+1,nr,nc,stR,stC,d);
					chk[nr][nc] = false;
					dessert[map[nr][nc]] = false;
				}
				
			}	
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			max = 0;
			map = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
		
			for(int i=0; i<N-2; i++) {
				for(int j=1; j<N-1; j++) {
					chk = new boolean[N][N];
					dessert = new boolean[101];
					chk[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(1,i,j,i,j,0);					
				}
			}
			
			if(max==0) {
				System.out.println("#" + testCase + " " + -1);
			} else {
				System.out.println("#" + testCase + " " + max);
			}
			
		} // tc
	}// main
}