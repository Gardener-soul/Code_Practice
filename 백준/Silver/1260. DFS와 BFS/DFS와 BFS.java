import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,M,V;
	static ArrayList<Integer>[] graph;
	static boolean[] chk;
	static Queue<Integer> queue = new LinkedList<>();
	
	public static void dfs(int v) {
		
		chk[v] = true;
		System.out.print(v + " ");
		
		for(int nextV : graph[v]) {	
			if(!chk[nextV]) {
				dfs(nextV);
			}
		}
	}
	
	public static void bfs(int v) {
		
		queue.offer(v);
		chk[v] = true;
		
		while(!queue.isEmpty()) {
			
			int t = queue.poll();
			System.out.print(t + " ");
			
			for(int i=0; i<graph[t].size(); i++) {
				
				int nextT = graph[t].get(i);
				if(!chk[nextT]) {
					chk[nextT] = true;
					queue.offer(nextT);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt(); // 정점의 개수
		M = scanner.nextInt(); // 간선의 개수
		V = scanner.nextInt(); // 정점 시작 번호
		
		graph = new ArrayList[N+1];
		chk = new boolean[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			
			graph[a].add(b);
			graph[b].add(a);
		} // 그래프 생성 완료
		
		for(int i=1; i<graph.length; i++) {
			Collections.sort(graph[i]);
		}
		
		dfs(V);
		
		System.out.println();
		Arrays.fill(chk, false);
		
		bfs(V);
		
	}
}