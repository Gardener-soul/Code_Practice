import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			char[][] map = new char[R][C]; //char 배열 입력
			
			for(int nr = 0; nr<R; nr++) {
				map[nr] = scanner.next().toCharArray(); // char배열로 받는다.
			}
			
			int minNeed = 2500; //최솟값의 범위 설정위해 최댓값으로 초기 변수 설정.
			
			// i는 흰색의 줄 위치를 결정하는 변수. 파란색과, 빨간색줄이 무조건 그어져야하기 때문에
			// 최종변수가 R-2보다 작아야함.
			for(int i=0; i<R-2; i++) {
				//j는 파란색 줄 위치를 결정하는 변수. 흰색줄보다 한 줄 아래에 있기 때문에 i+1, 아래 빨간색이
				//한 줄 필수적으로 있어야하기 때문에 R-1줄.
				
				//정리하자면 흰색 : 0~R-3 까지 가능, 파란색 i+1~ R-2까지 가능. 빨간색 j+R-1까지 가능.
				
				for(int j=i+1; j<R-1; j++) {
					
					// 빨간색은 흰색, 파란색의 위치만 결정되었다면, 나머지 범위이기 때문에, 이 아래에서 완전탐색 시작.
					// i,j 반복문이 돌 때마다 위치가 변경되기 때문에, 각 줄마다 need변수를 초기화 시켜 최솟값 구하기
					int need = 0;
					
					//흰색의 숫자를 구하는 반복문. r의 범위가 0부터 시작하기 때문에 0~i까지
					for(int r=0; r<=i; r++) {
						for(int c=0; c<C; c++) {
							if(map[r][c]!='W') {
								need++;
							}
						}
					}
					
					//파란색의 숫자를 구하는 반복문, r의 범위가 i+1~j까지
					for(int r=i+1; r<=j; r++) {
						for(int c=0; c<C; c++) {
							if(map[r][c]!='B') {
								need++;
							}
						}
					}
					
					//빨간색의 숫자를 구하는 반목문. j부터 <N까지
					for(int r=j+1; r<R; r++) {
						for(int c=0; c<C; c++) {
							if(map[r][c]!='R') {
								need++;
							}
						}
					}
					
					minNeed = Math.min(minNeed, need);
					
				}
			}
			System.out.println("#" + testCase+ " " + minNeed);
		} //tc
	}
}
