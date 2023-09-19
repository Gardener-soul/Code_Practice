import java.util.Arrays;
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

	static int N,M;
	static int[][] map;
	static int[][] res;
	static int cnt = 1; // res 배열에 1씩 세고 싶음. 이게 아니라, 51번째 기믹, 너가 하려고 했던건 길이를 구하는 거였음, 연결된 부분의.
	static Queue<Pair> q = new LinkedList<>();
	static boolean[][] chk;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	
	public static void bfs(int x, int y) {
		
		chk[x][y] = true;
		res[x][y] = 1;
		
		q.offer(new Pair(x,y));
		
		while(!q.isEmpty()) {
			
			Pair t = q.poll();
			
			for(int d=0; d<4; d++) {
				int tr = t.x + dr[d];
				int tc = t.y + dc[d];
				
				if(tr<N && tc<M && tr>=0 && tc>=0) {
					
					if(!chk[tr][tc] && map[tr][tc]!=0) {
						q.offer(new Pair(tr,tc));
						
						res[tr][tc] = res[t.x][t.y] +1;
						chk[tr][tc] = true;
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		N = scanner.nextInt();
		M = scanner.nextInt();
		map = new int[N][M];
		res = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String input = scanner.next();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(res[N-1][M-1]);
		
	}
	
}