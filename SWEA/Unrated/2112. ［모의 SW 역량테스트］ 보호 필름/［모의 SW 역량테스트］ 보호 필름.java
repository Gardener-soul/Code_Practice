import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	
	static int R, K, C, Kcnt, iCnt, cnt, ans;
	static boolean[] sel;
	static int[] A, B;
	static int[][] map, copyMap;

	static boolean chk() {
		
		Kcnt=0;
		
		for(int c=0; c<C; c++) {
			cnt = 0; //열이 바뀔 때마다 cnt 초기화
			for(int r=0; r<R-1; r++) {
				if((copyMap[r][c]==1&&copyMap[r+1][c]==1)||(copyMap[r][c]==0&&copyMap[r+1][c]==0)) { //
					cnt++;
				} else {cnt = 0;}
				
				if(cnt == K-1) {
					Kcnt++;
					break;
				}
			}
		} // 0과 1을 잘 셀 수 있게 되었음
		
		if(Kcnt == C) {
			return true;
		} else {
			return false;
		}
		
    }
	// injection(0);
	public static void injection(int idx, int iCnt) {
		// 백트래킹으로 무언갈 한다.
		if(ans<=iCnt) {
			return;
		}
		
		
		if(idx==R) {
			if(chk()) {	
				ans=iCnt;
			}
			return;
		}
		
		injection(idx+1, iCnt);
		
		copyMap[idx] = A;
		injection(idx+1, iCnt+1);
		
		copyMap[idx] = B;
		injection(idx+1, iCnt+1);
		
		copyMap[idx] = map[idx];
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			
			R = scanner.nextInt();
			C = scanner.nextInt();
			K = scanner.nextInt(); //연속해야 하는 수의 개수
			map = new int[R][C];
			copyMap = new int[R][C];
			A = new int[C];
			B = new int[C];
			Arrays.fill(B, 1);
			
			ans = K;
			cnt = 0;
			Kcnt = 0;
			sel = new boolean[R];
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
					map[r][c] = scanner.nextInt();
					copyMap[r][c] = map[r][c];
				}
			}
			
			injection(0,0);

			System.out.println("#" + testCase + " " + ans);
			
		} //tc		
	} //main
	
}