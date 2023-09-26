import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	
	int x, y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Solution {
	
	static Queue<Pair> q = new LinkedList<>();
	static int N;
	static boolean[][] chk;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void bfs(int r, int c) {
		q.offer(new Pair(r,c));
		chk[r][c] = true;
		
		while(!q.isEmpty()) {
			Pair tmp = q.poll();

			for(int d=0; d<4; d++) {
				
				int tr = tmp.x + dr[d];
				int tc = tmp.y + dc[d];
				
				if(tr<N && tc<N && tr>=0 && tc>=0 && !chk[tr][tc] && map[tr][tc]==0) {
					chk[tr][tc] = true;
					map[tr][tc] = map[tmp.x][tmp.y] + 1;
					q.offer(new Pair(tr, tc));
					
				}
	
			}

		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			N = scanner.nextInt();
			map = new int[N][N];
			chk = new boolean[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					map[r][c] = scanner.nextInt();
				}
			}
			
			int sr = scanner.nextInt();
			int sc = scanner.nextInt();
			int ar = scanner.nextInt();
			int ac = scanner.nextInt();
			
			bfs(sr,sc);
			
			if(map[ar][ac]==0) {
				System.out.println("#" + testCase + " " + -1);
			} else {
				System.out.println("#" + testCase + " " + map[ar][ac]);
			}
		}
	}
}