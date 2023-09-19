import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N,M,V;
	static ArrayList<Integer>[] map;
	static boolean[] chk;
	static int[] res;
	static int cnt = 1;
	
	public static void dts(int level) {
		
		chk[level] = true;
		res[level] = cnt++;
		
		for(int nextLevel : map[level]) {
			
			if(!chk[nextLevel]) {
				dts(nextLevel);
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 정점
		M = Integer.parseInt(st.nextToken()); // 간선
		V = Integer.parseInt(st.nextToken()); // 시작 정점
		
		map = new ArrayList[N+1];
		chk = new boolean[N+1];
		res = new int [N+1];
		
		for(int i=1; i<=N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st1.nextToken());
			int b = Integer.parseInt(st1.nextToken());
		
			map[a].add(b);
			map[b].add(a);
		} // 그래프 잘 받아짐.
		
		for(int i=1; i<=N; i++) {
			Collections.sort(map[i],Collections.reverseOrder());
		}
		
		dts(V);
		
		for(int i=1; i<=N; i++) {
			System.out.println(res[i]);
		}
	}	
}