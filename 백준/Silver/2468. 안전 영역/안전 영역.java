import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static boolean[][] chk;
	
	public static void dfs(int day, int r, int c) {
		
		for(int d=0; d<4; d++) {
			
			int tr = r + dr[d];
			int tc = c + dc[d];
			
			if(tr<N && tc<N && tr>=0 && tc>=0 && !chk[tr][tc] && map[r][c] > day) {
				chk[tr][tc] = true;
				dfs(day, tr,tc);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int max = 0;
		
		map = new int[N][N];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				max = Math.max(max, map[r][c]);	
			}
		}
		
		int ans = 1;
		
		for(int a=1; a<=max; a++) {
			
			chk = new boolean[N][N];
			int cnt = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(map[r][c]>a && !chk[r][c]) {
						chk[r][c] = true;
						dfs(a,r,c);
						cnt++;
					}
				}
			}
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}
