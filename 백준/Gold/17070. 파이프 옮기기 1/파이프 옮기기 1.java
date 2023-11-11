import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, ans;
	static int[] dr = {0,1,1}; // 가로 , 세로, 대각선
	static int[] dc = {1,1,0};
	static int[][] map;
	
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

    public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //(N-1,N-1)에 도달했을 때
		ans = 0;
		map = new int[N+1][N+1];
		
		for(int r=1; r<=N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1; c<=N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(1,2,0);
		System.out.println(ans);
		
	}
	
}