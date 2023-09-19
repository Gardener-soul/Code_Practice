import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] chk;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int idx = 0, cnt = 0;
	
	public static void dfs(int level, int x, int y) {
		
		chk[x][y] = true;
		map[x][y] += idx;
		
		for(int d=0; d<4; d++) {
			
			int tr = x + dr[d];
			int tc = y + dc[d];
			if(tr<N && tc<N && tc>=0 && tr>=0) {
				
				if(!chk[tr][tc]&&map[tr][tc]==1) {
					dfs(level+1,tr,tc);
					cnt +=1;
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N][N];
		chk = new boolean[N][N];
		
		for(int r=0; r<N; r++) {
			String input = scanner.next();
			for(int c=0; c<N; c++) {
				map[r][c] = input.charAt(c)-'0';
			}
		}
		
		List<Integer> cntarr = new ArrayList<>();
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				if(!chk[r][c]&&map[r][c]==1) {
					cnt = 1;
					dfs(1,r,c);
					idx++;
					cntarr.add(cnt);
				}
			}
		}
		
		Collections.sort(cntarr);
		
		System.out.println(idx);
		for(int i=0; i<cntarr.size(); i++) {
			System.out.println(cntarr.get(i));
		}
	}
	
}