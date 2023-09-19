import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static ArrayList<Integer>[] graph;
	static Queue<Integer> q = new LinkedList<>();
	static int[] res;
	static boolean[] chk;
	static int cnt = 2;
	
	public static void bfs(int level) {
		
		q.offer(level);
		chk[level] = true;
		
		while(!q.isEmpty()) {
			
			int t = q.poll();
			
			for(int i=0; i<graph[t].size(); i++) {
				
				int nextT = graph[t].get(i);
				if(!chk[nextT]) {
					q.offer(nextT);
					chk[nextT] = true;
					res[nextT] = cnt++;
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N+1];
		chk = new boolean[N+1];
		res = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st2= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i=1; i<=N; i++) {
			Collections.sort(graph[i]);
		}
		
		res[V]++;
		bfs(V);
		
		for(int i=1; i<=N; i++) {
			System.out.println(res[i]);
		}
		
	}
	
}