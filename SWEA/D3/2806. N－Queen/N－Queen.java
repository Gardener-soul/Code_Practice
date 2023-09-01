import java.util.Scanner;

public class Solution {

	static int cnt;
	static int[][] chess;
	static int N;
	static int[] dr = {-1,-1,-1};  //좌상, 상 , 우상
	static int[] dc = {-1,0,1};
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			N = scanner.nextInt();
			chess = new int[N][N];
			cnt = 0;
			
			nQueen(0);
			
			System.out.println("#" + testCase + " " + cnt);
			
		}
		
	}
	
	public static void nQueen(int idx) {
		
		if(idx == N) { // N은 크기
			cnt++;
			return;
		}
		
		loop : for(int i=0; i<N; i++) { //N의 길이만큼 판별
			for(int d=0; d<3; d++) { //델타만큼 판별
				
				for(int k=1;;k++) {
					
					int nr = idx + dr[d] * k;
					int nc = i + dc[d] * k;
					
					if(nr>=N || nc>=N || nr<0 || nc<0) {
						break;
					} else if (chess[nr][nc] == 1) {
						continue loop;
					}
				}				
			}
			
			chess[idx][i] = 1;
			nQueen(idx+1);
			chess[idx][i] = 0;
			
		}
	}
}