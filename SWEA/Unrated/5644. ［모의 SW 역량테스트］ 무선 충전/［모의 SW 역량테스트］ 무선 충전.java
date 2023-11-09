import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	
	static int ans, M, A;
	static int dar, dac, dbr, dbc;
	static int[] runA, runB;
	static int[] dr = {0,-1,0,1,0};
	static int[] dc = {0,0,1,0,-1};
	static int[][] map, BC;
	
	public static void move(int ar, int ac, int br, int bc) {
		
		dar = ar;
		dac = ac;
		dbr = br;
		dbc = bc;
		
		for(int i=0; i<=M; i++) {
			dar+=dr[runA[i]];
			dac+=dc[runA[i]];
			dbr+=dr[runB[i]];
			dbc+=dc[runB[i]];
			
			ans += charge();
		}
		
	}

	public static int chk(int bc, int nr, int nc) {
				
		if(BC[bc][2] >= Math.abs(nr-BC[bc][1]) + Math.abs(nc-BC[bc][0])) {
			return BC[bc][3];
		} else {
			return 0;
		}
		
	}
	
	public static int charge() {
		
		int max = 0;
		// A : BC 개수		
		for(int a=0; a<A; a++) {
			for(int b=0; b<A; b++) {
				int sum = 0;
				int nowA = chk(a, dar, dac);
				int nowB = chk(b, dbr, dbc);
				
				if(a!=b) {
					sum = nowA + nowB;
				} else if (a==b) {
					sum = Math.max(nowA, nowB);
				}
				
				if(max<sum) max = sum;
			}
		}
		return max;
	}

	
	
public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		for(int testCase = 1; testCase<=tc; testCase++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 이동시간
			A = Integer.parseInt(st.nextToken()); // BC 개수
			ans = 0;
			
			runA = new int[M+1];
			runB = new int[M+1];
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				runA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i=1; i<=M; i++) {
				runB[i] = Integer.parseInt(st.nextToken());
			}
	
			BC = new int[A][4]; // 0 c , 1 r , 2: D , 3 power
			for(int i=0; i<A; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					BC[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			move(1,1,10,10);
			System.out.println("#" + testCase + " " + ans);
		}// tc
		
	}
}