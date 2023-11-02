import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] rank;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		rank = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
		}
		
		int max = 0;
		for(int i=1; i<N+1; i++) {
			bfs(i);
		}
		
		for(int i=1; i<N+1; i++) {
			max = Math.max(rank[i], max);
		}
		
		for(int i=1; i<N+1; i++) {
			if(max == rank[i]) {
				bw.write(i+" ");
			}
		}
		bw.flush();
		bw.close();
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] chk = new boolean[N+1];
		q.add(start);
		chk[start] = true;
		while(!q.isEmpty()) {
			
			int num = q.poll();
			
			for(int next : list[num]) {
				if(!chk[next]) {
					chk[next] = true;
					rank[next]++;
					q.add(next);
				}
			}
		}
	}
}