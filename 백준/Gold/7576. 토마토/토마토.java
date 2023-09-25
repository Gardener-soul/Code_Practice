import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}

public class Main {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int R,C;
	static int[][] map;
	static boolean[][] chk;
	static Queue<Pair> q;
	static int cnt = 0;
	
	public static void bfs() {
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			for(int d=0; d<4; d++) {
			
				int tr = tmp.x + dr[d];
				int tc = tmp.y + dc[d];
				
				if(tr<R && tc<C && tr>=0 && tc>=0 && !chk[tr][tc] && map[tr][tc]!=-1) {
					
					chk[tr][tc] = true;
					map[tr][tc] = map[tmp.x][tmp.y]+1;
					q.offer(new Pair(tr,tc));
				}
				
			}
		}
		
	}
	
	public static boolean zero() {
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				if(map[r][c]==0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static int max() {
		int max = 0;
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				max = Math.max(max, map[r][c]);
			}
		}
		return max-1;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		C = scanner.nextInt();
		R = scanner.nextInt();
		map = new int[R][C];
		chk = new boolean[R][C];
		q = new LinkedList<>();
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				map[r][c] = scanner.nextInt();
				
				if(map[r][c] == 1) {
					chk[r][c] = true;
					q.offer(new Pair(r,c));
				}
				
			}
		}
		
		int ans = 0;
		
		if(zero()) { // 시작했는데 0이 있으면 bfs 한 번 해봐.
			bfs();
			ans = max();
		} else { // 시작했는데 0 없는 경우
			ans = 0;
		}

		if(zero()) { // bfs를 완료했는데도 0이 있으면 ans=-1;
			ans = -1;
		}
		
		System.out.println(ans);
		
	}
	
}