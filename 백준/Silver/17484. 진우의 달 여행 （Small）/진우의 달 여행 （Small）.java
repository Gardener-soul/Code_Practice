import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Pair{
	int r,c,cnt,go;

	public Pair(int r, int c, int cnt, int go) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.go = go;
	}
}

public class Main {
	
	static int N,M;
	static int ans = Integer.MAX_VALUE;
	static int[] dr = {1,1,1};
	static int[] dc = {-1,0,1};
	static int[][] map;
	
	public static void dfs(int r, int c, int cnt, int dir) {
		
		if(r==N-1) {
			if(ans>cnt) ans = cnt;
			return;
		}
	
		for(int d=0; d<3; d++) {
			if(dir==d) continue;
			int tr = r + dr[d];
			int tc = c + dc[d];
			
			if(tr<N && tc<M && tr>=0 && tc>=0) {
				
				dfs(tr,tc,cnt + map[tr][tc],d);
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			dfs(0,i,map[0][i],-1);
		}
		
		System.out.println(ans);
	}
}