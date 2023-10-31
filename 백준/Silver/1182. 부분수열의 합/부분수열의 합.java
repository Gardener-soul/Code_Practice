import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int N,S, cnt;
	static int[] nums;
	static boolean[] chk;
	
	public static void powerSet(int idx) {
		
		if(idx==N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(chk[i]) {
					sum+=nums[i];
				}
			}
			if(S==sum) cnt++;
			return;
		}
		
		chk[idx] = false;
		powerSet(idx+1);
		chk[idx] = true;
		powerSet(idx+1);
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		cnt = 0;
		nums = new int[N];
		chk = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		powerSet(0);
		if(S==0) cnt-=1;
		System.out.println(cnt);
	}
	
}