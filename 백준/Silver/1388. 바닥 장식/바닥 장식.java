import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		char[][] map = new char[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j);
			}
		}

		int ans = 0;
		
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<M; j++) {
				if(map[i][j]=='-') {
					cnt++;
				} else cnt=0;
				
				if(cnt==1) ans++;
			}
		}
		
		for(int i=0; i<M; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if(map[j][i]=='|') {
					cnt++;
				} else cnt=0;
				
				if(cnt==1) ans++;
			}
		}
		
		System.out.println(ans);
	}
	
}