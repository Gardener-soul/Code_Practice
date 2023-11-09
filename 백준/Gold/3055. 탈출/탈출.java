import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int r, c, cnt;

	public Pair(int r, int c, int cnt) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
	}
}

public class Main {
	
	static int R,C, ar, ac, ans;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[][] map;
	static boolean[][] chk, gochk;
	static Queue<Pair> q = new LinkedList<>();
	static Queue<Pair> go = new LinkedList<>();
	
	public static void water() {
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int r = tmp.r;
			int c = tmp.c;
			int cnt = tmp.cnt +1;
			
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<R && nc<C && nr>=0 && nc>=0 && !chk[nr][nc]) {
					chk[nr][nc] = true;
					map[nr][nc] = cnt;
					q.offer(new Pair(nr,nc,map[nr][nc]));
				}
			}
		}
	}
	
	public static void run() {
		
		while(!go.isEmpty()) {
			
			Pair tmp = go.poll();
			int r = tmp.r;
			int c = tmp.c;
			int cnt = tmp.cnt;
			
			if(ar==r && ac==c) {
				ans = cnt;
				return;
			}
			
			for(int d=0; d<4; d++) {
				
				int nr = r + dr[d];
				int nc = c + dc[d];
				
				if(nr<R && nc<C && nr>=0 && nc>=0 && cnt+1<map[nr][nc] &&!gochk[nr][nc]) {
					gochk[nr][nc] = true;
					go.offer(new Pair(nr,nc,cnt+1));
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
		chk = new boolean[R][C];
		gochk = new boolean[R][C];
		ans=-1;
		for(int r=0; r<R; r++) {
			String tmp = br.readLine();
			for(int c=0; c<C; c++) {
				if(tmp.charAt(c)=='.') map[r][c] = Integer.MAX_VALUE;
				else if(tmp.charAt(c)=='D') {
					
					ar = r;
					ac = c;
					
					chk[r][c] = true;
					map[r][c] = Integer.MAX_VALUE;
				}
				else if(tmp.charAt(c)=='S') {
					chk[r][c] = true;
					gochk[r][c] = true;
					map[r][c] = -1;
					go.offer(new Pair(r,c,0));
				} 
				else if (tmp.charAt(c)=='X') {
					chk[r][c] = true;
					gochk[r][c] = true;
				}
				else if(tmp.charAt(c)=='*') {
					map[r][c] = -3;
					chk[r][c] = true;
					q.offer(new Pair(r,c,0));
				}
			}
		}
		
		water();
		
		run();
		
		if(ans==-1) System.out.println("KAKTUS");
		else System.out.println(ans);
		
	}
	
}