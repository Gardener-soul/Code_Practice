import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	
	int x, y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Solution {
	
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean[][] chk;
	static Queue<Pair> q;
	
	public static void bfs(int x, int y) {
		
		chk[x][y] = true;
		map[x][y] = '1';
		q.offer(new Pair(x,y));
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			for(int d=0; d<4; d++) {
				
				int tr = tmp.x + dr[d];
				int tc = tmp.y + dc[d];
				
				if(tr<16 && tc<16 && tr>=0 && tc>=0) {
					
					if(!chk[tr][tc] && map[tr][tc] == '0' || map[tr][tc] == '3') {
						
						chk[tr][tc] = true;
						map[tr][tc] = '1';
						q.offer(new Pair(tr, tc));
						
					}
					
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase <= 10; testCase++) {
			
			int T = scanner.nextInt(); // 의미없는 숫자 값.
			
			map = new char[16][16];
			chk = new boolean[16][16];
			q = new LinkedList<>();
			
			for(int i=0; i<16; i++) {
				map[i] = scanner.next().toCharArray();
			}
			
			int r = 0;
			int c = 0;
			
			outer : for(r = 0; r<16; r++) {
				for (c=0; c<16; c++) {
					if(map[r][c]=='3') {
						break outer;
					}
				}
			}
			
			bfs(1,1);
			
			int ans = 0;
			if(chk[r][c]) {
				ans=1;
			}
			
			System.out.println("#" + testCase + " " + ans);
			
		}
		
	}
	
}