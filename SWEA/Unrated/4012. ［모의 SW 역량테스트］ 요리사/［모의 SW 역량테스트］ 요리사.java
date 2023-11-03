import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int N;
	static int min;
	static boolean[] chk;
	static boolean[][] cookChk;
	static int[] res,ores,num;
	static int[][] map;
	
	
	public static void com(int idx, int sidx) {
		
		if(sidx==N/2) {
			div();
			cook();
			return;
		}
		
		if(idx==N) return;
		
		res[sidx] = num[idx];
		com(idx+1, sidx+1);
		com(idx+1, sidx);

	}

	public static void div() {
		chk = new boolean[N]; // 그걸 체크할 배열
		
		for(int i=0; i<N/2; i++) {
			chk[res[i]] = true;
		}
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(!chk[i]) ores[idx++] = i;
		}
	}
	
	public static void cook() {
		
		int Tsum = 0;
		int Fsum = 0;
		
		for(int i=0; i<N/2-1; i++) {
			for(int j=i; j<N/2; j++) {
				Tsum+=map[res[i]][res[j]]+map[res[j]][res[i]];
			}
		}
		
		for(int i=0; i<N/2-1; i++) {
			for(int j=i; j<N/2; j++) {
				Fsum+=map[ores[i]][ores[j]]+map[ores[j]][ores[i]];
			}
		}
		
		min = Math.min(min, Math.abs(Tsum-Fsum));
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tctmp = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase<=tctmp; testCase++) {	
			
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			map = new int[N][N]; // 음식 맛 배열
			res = new int[N/2];  // 조합의 결과 배열
			ores = new int[N/2]; // 조합의 결과를 토대로, 나머지 배열

			num = new int[N]; // 조합 돌리기 위한 숫자 배열
			
			for(int i=0; i<N; i++) {
				num[i] = i;
			}
			
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			com(0,0);
			
			System.out.println("#" + testCase + " " + min);
			
		} // tc
	} // main
}