import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int N, M, answer;
	static ArrayList<Integer>[] graph;
	static int[] chk;
	
	public static void dfs(int level, int Node) {
		
		if(level == N) {
			answer = N;
		} else {
			
			for(int nextNode : graph[Node]) {
				
				if(chk[nextNode]==0) {
					
					chk[nextNode] = 1;
					dfs(level+1, nextNode);
					chk[nextNode] = 0;
					
				}
			}
			
			answer = Math.max(level, answer);
			
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		for(int testCase = 1; testCase<=T; testCase++) {
			
			N = scanner.nextInt(); // 정점의 개수
			M = scanner.nextInt(); // 간선의 개수
			answer = -1;
			
			graph = new ArrayList[N+1];
			chk = new int[N+1];
			
			for(int i=1; i<=N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i=0; i<M; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				
				graph[a].add(b);
				graph[b].add(a);
			} // 그래프 생성 완료
			
			for(int i=1; i<=N; i++) {
				
				chk[i] = 1;
				dfs(1,i);
				chk[i]=0;
				
			}
			
			System.out.println("#" + testCase + " " + answer);
			
		} // tc
	}
}