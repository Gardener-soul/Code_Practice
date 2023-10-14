import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	static int res, max;
	static boolean[] chk;
	static List<Integer>[] map;
	static Queue<Integer> q;
	
	public static void bfs(int start) {

		q.offer(start);
		chk[start] = true;
		
		while(!q.isEmpty()) {
			int len = q.size();
			max = 0;
			
			for(int a = 0; a<len; a++) {
				
				res = q.poll();
				max = Math.max(max, res);
				
				for(int i=0; i<map[res].size(); i++) {
					int nextS = map[res].get(i);
					
					if(!chk[nextS]) {
						chk[nextS] = true;
						q.offer(nextS);
					}
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int testCase = 1; testCase <=10; testCase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			q = new LinkedList<>();
			map = new ArrayList[101];
			chk = new boolean[101];
			
			for(int i=1; i<=100; i++) {
				map[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<num/2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				map[a].add(b);
			}
			bfs(start);
			System.out.println("#" + testCase + " " + max);
		}
		
	}
	
}