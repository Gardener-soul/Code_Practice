import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int num, cnt;

	public Pair(int num, int cnt) {
		super();
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {

	static int N;
	static int[] res;
	static ArrayList<Integer>[] arr;
	static Queue<Pair> q = new LinkedList<>();
	
	public static int bfs(int start, int mem) {
		
		boolean[] chk = new boolean[N+1];
		q.offer(new Pair(start,mem));
		chk[start] = true;
		int min = 0;
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int now = tmp.num;
			int cnt = tmp.cnt;
			
			for(int next : arr[now]) {
				if(chk[next]) continue;
				chk[next] = true;
				q.offer(new Pair(next,cnt+1));
			}
			min = cnt;
		}
		
		return min;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		res = new int[N+1]; // 1부터 순회
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		while(true) {
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a==-1 && b==-1) break;
			
			arr[a].add(b);
			arr[b].add(a);
			
		}
		
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=N; i++) {
			res[i] = bfs(i,0);
			min = Math.min(min, res[i]);
		}
		
		StringBuilder sb = new StringBuilder();
		int minCnt = 0;
		for(int i=1; i<=N; i++) {
			if(res[i]==min) {
				sb.append(i + " ");
				minCnt++;
			}
		}
		
		System.out.print(min + " " + minCnt);
		System.out.println();
		System.out.println(sb);
		
	}
}