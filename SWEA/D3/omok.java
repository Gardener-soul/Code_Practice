package Omok;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();//테스트 케이스 개수
		for(int testCase = 1; testCase <= T; testCase++) {
			int N = scanner.nextInt(); // 오목판 크기
			char[][] map = new char [N][N]; 
			for(int i=0; i<N; i++) {
				String str = scanner.next(); //한줄씩 받고
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j); //그 줄의 문자 인덱스만큼 분류해서 넣기
				}
			} //omok 잘 받아짐
			
			//delta 만들기 우 , 하 ,대우하, 대좌하
			int[] dr = {0,1,1,1};
			int[] dc = {1,0,1,-1};
			
			String ans = "NO"; //오목이 만들어지면 Yes로 바꿀거임.
			
			out : for(int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if(map[r][c]=='o') { //만약 o를 만났을 때 시작한다.
						
						for(int d = 0; d<4; d++) { //델타값을 반복문으로 주고 그 안에서 (ex cnt값 주기)를 통해 설정한 delta 방향으로 순회 가능
							
							int cnt = 1;
							int nr = r + dr[d]; //nr과 nc 는 d값이 변경될때마다 다시 초기화가 되어야함.
							int nc = c + dc[d];
							
							while(nr>=0&&nc>=0&&nr<N&&nc<N&&map[nr][nc]=='o') { //nr nc 위치에서도 o가 나왔다면 이제 본격적으로 확인해보기 시작.
								nr+=dr[d]; // 현재 순회하고 있는 d 반복문 내에서 계속해서 확인할거임.
								nc+=dc[d];
								cnt++;
							}
							
							if(cnt==5) {
								ans = "YES";
								break out; //오목이 한 번 완성되면 굳이 더 확인할 필요가 없기 때문에 반복문을 아예 탈출
							}
							
						}
					}
				}
			}
			System.out.println("#" + testCase + " " + ans);
			
		} //tc
	}
}
