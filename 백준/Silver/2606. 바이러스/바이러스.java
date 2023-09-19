import java.util.Scanner;

public class Main {
	
	static int N;
	static int cnt=0;
	static boolean[] chk = new boolean[N+1];
	static int[][] map;
	
	public static void dfs(int level) {
		
		chk[level] = true;
		cnt++;
		for(int i=1; i<=N; i++) {
			if(!chk[i]&&map[level][i]==1) {
				dfs(i);
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 정점의 개수
		int M = scanner.nextInt(); // 간선의 개수
		
		map = new int[N+1][N+1];
		chk = new boolean[N+1];
		for(int i=1; i<=M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		dfs(1);
		
		System.out.println(cnt-1);
		
	}
	
}