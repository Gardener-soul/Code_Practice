package sudoku;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int[][] sudoku = new int[9][9];
			
			for(int i=0; i<9; i++) {
				for(int j=0; j<9; j++) {
					sudoku[i][j] = sc.nextInt();
				}
			} //sudoku배열 생성완료
		
			int cnt = 0; //만일 cnt가 0이면 정상 스도쿠, 0이 아니면 비정상 스도쿠
			
			//rsum = 45인가?
			for(int i=0; i<9; i++) {
				int rsum = 0;
				for(int j=0; j<9; j++) {
					rsum+=sudoku[i][j];
				}
				if(rsum!=45) {cnt++;}
			} //통과 ㅇㅇ

			//csum = 45인가?
			for(int i=0; i<9; i++) {
				int csum = 0;
				for(int j=0; j<9; j++) {
					csum+=sudoku[j][i];
				}
				if(csum!=45) {cnt++;}
			} //통과 ㅇㅇ
			
			//ssum = 45인가? (델타 활용) + , X 활용
			
			//델타 설정 (상,하,좌,우)
			int[] dr = {0,0,-1,1}; //행
			int[] dc = {-1,1,0,0,}; //열
			int[] dx = {-1,-1,1,1}; //곱하기 위아래
			int[] dy = {-1,1,-1,1}; //곱하기 좌우
			
			//i와 j의 시작점과 위치를 설정해줘야함, i = 1,4,7 j 도 1,4,7
			for(int i=1; i<9; i=i+3) {
				int ssum=0;
				for(int j=1; j<9; j=j+3) {
					ssum = sudoku[i][j]; //델타값을 활용할 것이기 때문에, 스도쿠 기준값 설정. 합은 이것부터 더하기

					for(int d=0; d<4; d++) {

						int nr = i + dr[d];
						int nc = j + dc[d];		
						int nx = i + dx[d];	
						int ny = j + dy[d];	
	
						ssum+=sudoku[nr][nc];
						ssum+=sudoku[nx][ny];
					}
					if (ssum!=45) {cnt++;}		
				}
			}
			
			int ans=0;
			if (cnt==0) {
				ans = 1;
			} else {ans = 0;}
			
			System.out.println("#" + tc + " " + ans);
			
		} // tc반복문
	}//main
}
