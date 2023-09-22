import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static int N;
	static ArrayList<Integer>[] map;
	static boolean[] chk;
	static int max;
	
	public static void dfs(int level , int cnt) {
		

		for(int i=0; i<map[level].size(); i++) {
			
			int nextLevel = map[level].get(i);
			
			if(!chk[nextLevel]) {
				chk[nextLevel] = true;
				dfs(nextLevel, cnt+1);
				chk[nextLevel] = false;
			}
			
		}
		
		max = Math.max(max, cnt);
//		System.out.println(max);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			
			N = scanner.nextInt(); // 정점
			int M = scanner.nextInt(); // 간선
			map = new ArrayList[N+1];
			chk = new boolean[N+1];
			max = 0;
			
			for(int i=1; i<=N; i++) {
				map[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				map[a].add(b);
				map[b].add(a);
				
			}
			
			for(int i=1; i<=N; i++) {
				chk[i] = true;
				dfs(i,1);
				chk[i] = false;
			}
			
			System.out.println("#" + testCase + " " + max);
			
		} // tc
		
	}
}
