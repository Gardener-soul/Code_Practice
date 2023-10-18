import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, no, to;
    static int[] time, degree, res;
	static ArrayList<Integer>[] map;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void bfs() {
		
		res = new int[N+1];
		for(int i=1; i<=N; i++) {
			if(degree[i]==0) {
				res[i] = time[i];
				q.offer(i);
			}
		}
		
		
		while(!q.isEmpty()) {
			
			int tmp = q.poll();
			
			for(int i = 0; i<map[tmp].size(); i++) {
				int pic = map[tmp].get(i);
				res[pic] = Math.max(res[pic], res[tmp] + time[pic]);
				degree[pic]--;
				
				if(degree[pic]==0) {
					q.offer(pic);
				}
				
			}
			
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int testCase=1; testCase<=T; testCase++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			no = Integer.parseInt(st.nextToken()); //반복문 몇 번 도는지
			
			map = new ArrayList[N+1];
			for(int i=1; i<=N; i++) {
				map[i] = new ArrayList<>();
			}
			
			time = new int [N+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=N; i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			degree = new int[N+1];
			for(int i=1; i<=no; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a].add(b);			
				
				degree[b]++;
				
			}
			to = Integer.parseInt(br.readLine()); // 최종 목적지
			
			bfs();
			
			System.out.println(res[to]);
			
		} // tc
		
	}
}