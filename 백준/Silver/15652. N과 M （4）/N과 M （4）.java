import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static int[] res, num;
	static boolean[] chk;
	static BufferedWriter bw;
	
	public static void perm(int idx) throws IOException {
		
		if(idx==M) {
			for(int i=0; i<M-1; i++) {
				if(res[i]>res[i+1]) {
					return;
				}
			}
			
			for(int i=0; i<M; i++) {
				bw.write(res[i]+" ");
			}
			bw.write("\n");
			return;
		}
		
		for(int i=0; i<N; i++) {
			chk[i] = true;
			res[idx] = num[i];
			perm(idx+1);
			chk[i] = false;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		chk = new boolean[N];
		res = new int[M];
		
		int idx=1;
		for(int i=0; i<N; i++) {
			num[i] = idx++;
		}
		
		perm(0);
		
		bw.close();
	}
}