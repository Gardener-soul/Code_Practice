import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	
	int x;
	int y;
	
	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}

public class Solution {

	static char[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<Pair> q;
	
	public static void bfs(int x, int y) {
		
		q.offer(new Pair(x,y));
		map[x][y]='1';
		
		while(!q.isEmpty()) {
			
			Pair t = q.poll();
			
			for(int d=0; d<4; d++) {
				
				int tr = t.x + dr[d];
				int tc = t.y + dc[d];
				
				if(map[tr][tc]=='0') {
					q.offer(new Pair(tr,tc));
					map[tr][tc] = '1';
				}
				
				if(map[tr][tc]=='3') {
					System.out.println(1);
					return;
				}
				
			}
			
		}
		
		System.out.println(0);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase<=10; testCase++) {
			
			int T = scanner.nextInt();
			map = new char[16][16];
			q=new LinkedList<>();
			
			for(int r=0; r<16; r++) {
				map[r] = scanner.next().toCharArray();
			}
			
			System.out.print("#" + testCase + " ");
			bfs(1,1);
			
		}
		
	}
	
}