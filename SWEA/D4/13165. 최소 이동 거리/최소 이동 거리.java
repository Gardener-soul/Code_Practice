import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Pair{
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
}

public class Solution {
	
	static final int INF = Integer.MAX_VALUE;
	static int V,E; // V : 정점, E : 간선의 수
	static List<Pair>[] adjList; // 인접리스트
	static int[] dist; //최단 길이를 저장할 배열
	static boolean[] visited;
	
	static void dijkstra(int start) {
		visited = new boolean[V+1];
		
		dist[start] = 0; // 시작정점까지의 거리는 0으로 초기화
		
		for(int i=0; i<V; i++) {
			int min = INF;
			int idx = -1;
			
			// 선택하지 않은 정점 중 dist가 가장 작은 값을 골라
			
			for(int j=0; j<=V; j++) {
				if(!visited[j] && min>dist[j]) {
					min = dist[j];
					idx = j;
				}
			}
			
			if(idx==-1) break; // 선택할 수 있는 친구가 없다. (연결이 끊겨 있다.)
			visited[idx] = true; // 선택
			
			for(int j=0; j<adjList[idx].size(); j++) {
				Pair curr = adjList[idx].get(j);
				
				// 방문하지 않았고, 연결되어있으면서 (인접리스트라 확인하지 않아도 됨)
				// 이미 가지고 있는 값보다 갱신할 여지가 있으면 갱신
				if(!visited[curr.x] && dist[curr.x] > dist[idx] + curr.y) {
					dist[curr.x]= dist[idx] + curr.y; 
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			V = scanner.nextInt(); // 정점의 개수
			E = scanner.nextInt(); // 간선의 개수

			adjList = new ArrayList[V+1];
			for(int i=0; i<=V; i++) {
				adjList[i] = new ArrayList<>();
			}
			
			dist = new int[V+1];
			Arrays.fill(dist, INF);
			
			for(int i=0; i<E; i++) {
				
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				int c = scanner.nextInt();
				
				adjList[a].add(new Pair(b,c));
				
			}
			
			dijkstra(0);
			
			System.out.println("#" + testCase + " " + dist[V]);
			
		}
		
	}
	
}