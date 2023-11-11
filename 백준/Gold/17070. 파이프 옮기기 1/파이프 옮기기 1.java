import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, ans;
	static int[] dr = {0,1,1}; // 가로 , 세로, 대각선
	static int[] dc = {1,1,0};
	static int[][] map;
	static boolean[][] chk;
	static boolean[][] piChk = {{true,false,true},
								{false,true,true},
								{true,true,true}};
	
	static void dfs(int r, int c, int dir) {
		// dir = 가로 0 대각선 1 세로 2  
		if (r == N && c== N) {
			ans++;
		}
		
		// 가로 상태 -> 오 대
		// 대각선 상태 -> 오 대 아
		// 세로 상태 -> 대 아
		// 이것들만 체크하도록 조건 만들어서 조절해준다.
		for (int d = (dir == 2 ? 1 : 0); d < (dir == 0 ? 2 : 3); d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr <= N && nc <= N && map[nr][nc] != 1) { 
				if (d == 1) {
					// 대각선 방향으로 가는 경우 추가 체크
					if (map[r][nc] == 1 || map[nr][c] == 1) continue;
				}
				dfs(nr, nc, d);
			}
		}
	}
	
	public static void search(int pipe , int r, int c) {
		
		if(r==N && c==N) {
			ans++;
			return;
		}
		
		for(int d=0; d<3; d++) {
			
			if(!piChk[pipe][d]) continue;
			
			int tr = r + dr[d];
			int tc = c + dc[d];
			
			if(tr<=N && tc<=N && !chk[tr][tc]) {
				if(map[tr][tc]==1) continue;
				
				chk[tr][tc] = true;
				if(d==2) {
					
					if(map[tr-1][tc]==1 || map[tr][tc-1]==1) return;
					
					chk[tr-1][tc] = true;
					chk[tr][tc-1] = true;
				}
				
				search(d,tr,tc);
				
				chk[tr][tc] = false;
				if(d==2) {
					chk[tr-1][tc] = false;
					chk[tr][tc-1] = false;
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //(N-1,N-1)에 도달했을 때
		ans = 0;
		map = new int[N+1][N+1];
		chk = new boolean[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==1) chk[r][c] = true;
			}
		}
		
		
		chk[1][1] = true; 
		chk[1][2] = true;

		dfs(1,2,0);
		System.out.println(ans);
		
	}
	
}