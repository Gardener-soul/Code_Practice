import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int res = 0;
	static boolean[] chk;
	static int[][] map;
	
	public static void dfs(int level, int start, int cnt) {
		
		if(level==2) {
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(map[start][i]==1) {
				chk[i] = true;
				dfs(level+1, i, cnt+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		int line = Integer.parseInt(br.readLine());
		
		chk = new boolean[N+1];
		map = new int[N+1][N+1];
		res = 0;
		
		for(int i=0; i<line; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		chk[1] = true;
		dfs(0,1,0);
		for(int i=2; i<=N; i++) {
			if(chk[i]) res++;
		}
		System.out.println(res);
	}
}