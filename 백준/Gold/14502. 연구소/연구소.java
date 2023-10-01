import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Main {
	
	static int N,M,max;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static boolean[][] chk;
	static Queue<Pair> q = new LinkedList<>();
	
	public static void makeWall(int level) {
		
		if(level == 3) {
			bfs();
			return;
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==0) {
					map[i][j]=1;
					makeWall(level+1);
					map[i][j]=0;
				}
			}
		}
		
	}
	
	public static void bfs() {
      
		for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(map[i][j] == 2) {
                    q.add(new Pair(i,j));
                }
            }
        }
		
		int[][] tmpMap = new int[N][M];
		
		for (int i = 0; i < N; i++) {
            tmpMap[i] = map[i].clone();
        }

		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			
			for(int d=0; d<4; d++) {
				int tr = tmp.x + dr[d];
				int tc = tmp.y + dc[d];
				
				if(tr<N && tc<M && tr>=0 && tc>=0 && tmpMap[tr][tc]==0) {

					q.offer(new Pair(tr,tc));
					tmpMap[tr][tc] = 2;
					
				}
			}
			
		}
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tmpMap[i][j]==0) cnt++;
			}
		}
		max = Math.max(cnt, max);
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		max = 0;
		
		map = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
//				if(map[i][j]==2) {
//					q.offer(new Pair(i,j));
//				}
			}
		}
		
		makeWall(0);
		
		System.out.println(max);
		
	}
	
}