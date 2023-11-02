import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int o;
	public static int[] res, num, ans;
	
	public static void perm(int idx) {
		
		if(idx == 10) {
			int cnt = 0;
			// 여기서 점수 5점 넘는지 체크
			for(int i=0; i<10; i++) {
				if(ans[i]==res[i]) cnt++; 
			}
			if(cnt>=5) o++;
			
			return;
		}
		
		for(int i=0; i<5; i++) {
			if(idx>=2 && res[idx-2]==res[idx-1]&&res[idx-2]==num[i]) continue;
			res[idx] = num[i];
			perm(idx+1);
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ans = new int[10];
		for(int i=0; i<10; i++) {
			ans[i] = Integer.parseInt(st.nextToken());
		}
		
		res = new int[10];
		num = new int[5];
		for(int i=0; i<5; i++) {
			num[i] = i+1;
		}
		o=0;
		perm(0);
		System.out.println(o);
	}
	
}