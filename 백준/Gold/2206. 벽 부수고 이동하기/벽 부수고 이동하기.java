import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int r, c, cnt;
	boolean punch;
	
	public Pair(int r, int c, int cnt, boolean punch) {
		super();
		this.r = r;
		this.c = c;
		this.cnt = cnt;
		this.punch = punch;
	}
}

public class Main {
	
	static int R,C;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static boolean[][][] chk;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void bfs(int r, int c, int cnt, boolean punch) {
		
		q.offer(new Pair(r,c,cnt,punch));
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int qr = tmp.r;
			int qc = tmp.c;
			int qcnt = tmp.cnt;

			if(qr==R-1 && qc==C-1) {
				System.out.println(qcnt);
				return;
			}
			
			for(int d=0; d<4; d++) {
				
				int tr = qr + dr[d];
				int tc = qc + dc[d];
				
				if(tr<R && tc<C && tr>=0 && tc>=0) {
					
					if(map[tr][tc]==0) {
						
						if(!tmp.punch && !chk[tr][tc][0]) {
							q.offer(new Pair(tr,tc,qcnt+1,false));
							chk[tr][tc][0] = true;
						}else if(tmp.punch && !chk[tr][tc][1]) {
							q.offer(new Pair(tr,tc,qcnt+1,true));
							chk[tr][tc][1] = true;
						}
						
					} else if (map[tr][tc]==1) {
						if(!tmp.punch) {
							q.offer(new Pair(tr,tc,qcnt+1,true));
							chk[tr][tc][1] = true;
						}
					}
					
				}
				
			}
			
		}
		System.out.println(-1);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];	
		chk = new boolean[R][C][2];
		
		for(int r=0; r<R; r++) {
			String tmp = br.readLine();
			for(int c=0; c<C; c++) {
				map[r][c] = tmp.charAt(c)-'0';
			}
		}
			
		bfs(0,0,1,false);
		
	}
	
}