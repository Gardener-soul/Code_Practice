import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int r, c;

	public Pair(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {
	
	static int R,C,zero;
	static int res,max = 0;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void bfs() {
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==2) q.offer(new Pair(r,c));
			}
		}
		
		int[][] tmpMap = new int[R][C];
		for(int r=0; r<R; r++) {
			tmpMap[r] = map[r].clone();
		}
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			
			for(int d=0; d<4; d++) {
				int tr = tmp.r + dr[d];
				int tc = tmp.c + dc[d];
				
				if(tr<R && tc<C && tr>=0 && tc>=0 && tmpMap[tr][tc]==0) {
					q.offer(new Pair(tr,tc));
					tmpMap[tr][tc]=2;
				}
				
			}
			
		}
		res = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(tmpMap[r][c]==0) res++;
			}
		}
		max = Math.max(max, res);
	}
	
	public static void dfs(int idx) {
		
		if(idx==3) {
			bfs();
			return;
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==0) {
					map[r][c]=1;
					dfs(idx+1);
					map[r][c]=0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int r=0; r<R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // 배열 입력 완료
		
		dfs(0);
		
		System.out.println(max);
	}
}