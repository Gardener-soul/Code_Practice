package ladder;

import java.util.Scanner;

public class Solution5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<=1; tc++) {
			int N = sc.nextInt();
			int[][] ladder = new int[100][100];
			int[][] visit = new int[100][100];
			for(int r=0; r<100; r++) {
				for(int c=0; c<100; c++) {
					ladder[r][c] = sc.nextInt();
				}
			} // 사다리 배열 생성 완료
			
			int r = 99;
			int c;
			
			for(c=0; c<100; c++) {
				if(ladder[r][c]==2) break;
			} //2인 숫자 찾기 완료
			
			int[] dr = {-1,0,0};
			int[] dc = {0,-1,1};
			
			int d;
			while(r>=0) {
				visit[r][c]=1;
				
				if(c<99&&ladder[r][c+1]==1&&visit[r][c+1]==0) {
					d=2;
				} else if (c>=1&&ladder[r][c-1]==1&&visit[r][c-1]==0) {
					d=1;
				} else {d=0;}
				c=c+dc[d];
				r=r+dr[d];
			}
			System.out.println("#" + tc + " " + c);
		} //tc 배열 완료
	} //main
}
