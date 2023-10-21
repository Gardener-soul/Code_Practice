import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, con, from, to;// 사람 수, 연결 횟수
	static int res= -1;
	static int[] num; // 사람 배열
	static boolean chk[]; // chk 배열
	static int[][] map; // 전체 관계 배열 (안되면 인접리스트로)
	
	public static void dfs(int from, int to, int cnt) {
		chk[from] = true;
		if(from==to) {
			res=cnt;
			return;
		}
		
		for(int i=1; i<=N; i++) {
			if(map[from][i]==1 && !chk[i]) {
				dfs(i,to,cnt+1);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		from = Integer.parseInt(st.nextToken());
		to = Integer.parseInt(st.nextToken());
		con = Integer.parseInt(br.readLine());
		
		map = new int[N+1][N+1];
		chk = new boolean[N+1];
		
		for(int i=0; i<con; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		dfs(from,to,0);
		System.out.println(res);
	}
}