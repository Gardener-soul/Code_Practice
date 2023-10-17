import java.util.Scanner;

public class Main {

	static int N;
	static int[] dr = {1,0};
	static int[] dc = {0,1};
	static int[][] map;
	static boolean[][] chk;
	
	public static void dfs(int r, int c, int cnt) {
	
		for(int d=0; d<2; d++) {
			
			int tr = r + dr[d] * map[r][c];
			int tc = c + dc[d] * map[r][c];
			
			if(tr<N && tc<N && tr>=0 && tc>=0 && !chk[tr][tc]) {
				chk[tr][tc] = true;
				dfs(tr,tc,map[tr][tc]);
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		map = new int[N][N];
		chk = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		chk[0][0] = true;
		dfs(0,0,map[0][0]);
		
		if(chk[N-1][N-1]) {
			System.out.println("HaruHaru");
		}else {
			System.out.println("Hing");
		}
	}
}