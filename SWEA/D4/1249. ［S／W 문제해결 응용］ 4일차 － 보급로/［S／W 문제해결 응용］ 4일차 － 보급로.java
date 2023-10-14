import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
	int cnt, r, c;

	public Pair(int cnt, int r, int c) {
		super();
		this.cnt = cnt;
		this.r = r;
		this.c = c;
	}
		
}

public class Solution {
	
	static int N;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map, chk;
	static Queue<Pair> q;
	
	public static void bfs(int cnt, int qr, int qc) {
		
		q.offer(new Pair(cnt,qr,qc));
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int res = tmp.cnt;
			int r = tmp.r;
			int c = tmp.c;
			
			for(int d=0; d<4; d++) {
				
				int tr = r + dr[d];
				int tc = c + dc[d];
				
				if(!(tr<N && tc<N && tr>=0 && tc>=0)) continue;
				if(chk[tr][tc] <= res + map[tr][tc]) continue;
				
				chk[tr][tc] = res + map[tr][tc];
				q.offer(new Pair(chk[tr][tc],tr,tc));
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			chk = new int[N][N];
			q = new LinkedList<>();
			
			for(int i=0; i<N; i++) {
				String tmp = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = tmp.charAt(j) - '0' ;
					chk[i][j] = Integer.MAX_VALUE;
				}
			}
			
			chk[0][0] = 0;
			bfs(0,0,0);
			
			System.out.println("#" + testCase + " " + chk[N-1][N-1]);
			
		} // tc
	}// main
}
