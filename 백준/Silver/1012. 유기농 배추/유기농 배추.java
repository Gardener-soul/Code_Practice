import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static int[][] map;
	static boolean[][] chk;
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1}; 
	
	public static void dfs(int x, int y) {
		
		chk[x][y] = false;
		
		for(int d=0; d<4; d++) {
			
			int tr = x + dr[d];
			int tc = y + dc[d];
			
			if(tr<N && tc<M && tr>=0 && tc>=0) {
				
				if(chk[tr][tc]&&map[tr][tc]==1) {
					dfs(tr,tc);
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		for(int testCase = 1; testCase<=T; testCase++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st2.nextToken());
			M = Integer.parseInt(st2.nextToken());
			V = Integer.parseInt(st2.nextToken());
			int cnt = 0;
			
			map = new int [N][M];
			chk = new boolean[N][M];
			
			for(int i=0; i<V; i++) {
				
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st3.nextToken());
				int b = Integer.parseInt(st3.nextToken());
				
				map[a][b] = 1;
				chk[a][b] = true;
				
			}
		
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(chk[r][c]&&map[r][c]==1) {
						dfs(r,c);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
			
		}	
	}	
}