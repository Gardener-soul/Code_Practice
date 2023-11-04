import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] arr, chk;
	static Queue<Integer> q = new LinkedList<>();
	
	public static int bfs(int start) {
		
		q.offer(start);
		
		while(true) {
			int visitNum = q.poll();
			
			for(int i=6; i>=1; i--) {
				int newNum = visitNum+i;
				
				if(newNum>100) continue;
				
				if(chk[arr[newNum]]==0) {
					q.offer(arr[newNum]);
					chk[arr[newNum]]=chk[visitNum]+1;
				}
				if(arr[newNum]==100){
					return chk[100];
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int lad = Integer.parseInt(st.nextToken());
		int sna = Integer.parseInt(st.nextToken());
		
		arr = new int[101];
		chk = new int[101];
		for(int i=1; i<=100; i++) {
			arr[i] = i;
		}
		for(int i=1; i<=lad; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a] = b;
		}
		for(int i=1; i<=sna; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a] = b;
		}
		
		int ans =bfs(1);
		System.out.println(ans);
	}
}