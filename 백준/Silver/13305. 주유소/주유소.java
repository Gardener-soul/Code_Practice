import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 도시의 개수
		int[] dist = new int[N-1]; // 도시 간 거리
		int[] pri = new int[N]; // 가격
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			pri[i] = Integer.parseInt(st.nextToken());
		}

		long ans = 0;
		
		ans = dist[0] * pri[0];
		int tmp = pri[0];
		
		for(int i=1; i<N-1; i++) {
			if(tmp<=pri[i]) {
				ans+=tmp*dist[i];
			} else {
				tmp = pri[i];
				ans+=tmp*dist[i];
			}
		}
		
		System.out.println(ans);
		
	}
}