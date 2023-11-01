import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int num,cnt;

	public Pair(int num, int cnt) {
		super();
		this.num = num;
		this.cnt = cnt;
	}
}

public class Main {
	
	static ArrayList<Integer>[] arr;
	static int N;
	static boolean[] chk;
	static Queue<Pair> q = new LinkedList<>();
	
	public static int bfs(int cnt, int start, int to) {
		
		q.offer(new Pair(start,0));
		chk[start] = true;
		
		while(!q.isEmpty()) {
			
			Pair tmp = q.poll();
			int nCnt = tmp.cnt;
			int nNum = tmp.num;
			
			if(nNum==to) {
				return nCnt;
			}
			
			for(int next : arr[nNum]) {
				
				if(chk[next]) continue;
				chk[next] = true;
				q.offer(new Pair(next,nCnt+1));
			}
			
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken()); // a에서
		int b = Integer.parseInt(st.nextToken()); // b로 갑니다.
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 전체 문자의 수
		int M = Integer.parseInt(st.nextToken()); // 치환하는 반복문 범위
		
		chk = new boolean[N+1];
		arr = new ArrayList[N+1];
		for(int i=1; i<=N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int no1 = Integer.parseInt(st.nextToken());
			int no2 = Integer.parseInt(st.nextToken());
			
			arr[no1].add(no2);
			arr[no2].add(no1);
		}
		System.out.println(bfs(0,a,b));
		
	}
	
}