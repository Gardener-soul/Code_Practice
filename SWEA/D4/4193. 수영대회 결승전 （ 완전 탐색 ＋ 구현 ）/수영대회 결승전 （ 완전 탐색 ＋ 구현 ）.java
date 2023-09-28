import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	
	int x, y, time;

	public Pair(int x, int y, int time) {
		super();
		this.x = x;
		this.y = y;
		this.time = time;
	}
	
}

public class Solution {
	
	static int N, sr, sc, ar, ac;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int[][] map;
	static boolean[][] chk;
	static Queue<Pair> q;
	
	public static int bfs(int startR, int startC, int toR, int toC, int time) {
		int t=0;
		chk[sr][sc] = true;
		q.offer(new Pair(startR, startC, 0));
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			t = tmp.time;
			
			// 이 부분이 문제가 있는 것 같음
			if(x == ar && y == ac) {
				return t;
			}
			
			for(int d=0; d<4; d++) {
				int tr = tmp.x + dr[d];
				int tc = tmp.y + dc[d];
				
				if(tr<N && tc<N && tr>=0 && tc>=0 && !chk[tr][tc]) {
					
					if(map[tr][tc]==0) {
						chk[tr][tc] = true;
						q.offer(new Pair(tr,tc,t+1));
					}
					
					if(map[tr][tc]==2) {
						
						if(t%3==0) {
							q.offer(new Pair(tmp.x,tmp.y,t+1));
						} else if(t%3==1) {
							q.offer(new Pair(tmp.x,tmp.y,t+1));
						} else if(t%3==2) {
							q.offer(new Pair(tr,tc,t+1));
							chk[tr][tc] = true;
						} 
						
					}
					
				}

			}
			
		}
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt();
			map = new int[N][N];
			chk = new boolean[N][N];
			q = new LinkedList<>();
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = scanner.nextInt();
				}
			}
			
			sr = scanner.nextInt();
			sc = scanner.nextInt();
			ar = scanner.nextInt();
			ac = scanner.nextInt();
			
			System.out.println("#" + testCase + " " + bfs(sr, sc, ar, ac, 0));
			
		}
	}
}
