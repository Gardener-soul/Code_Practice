import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	//델타, 상 우 하 좌
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int T = scanner.nextInt();
		for(int testCase = 1; testCase<=T; testCase++) {
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			char[][] map = new char[R][C];
			for(int r=0; r<R; r++) {
				map[r] = scanner.next().toCharArray();
			} //배열 잘 받아짐
			
			int S = scanner.nextInt();
			char[] joy = new char[S];
			joy = scanner.next().toCharArray(); //조이스틱 배열 잘 받아짐.

			int tr = 0;
			int tc = 0;
			
			for(int r=0; r<R; r++) {
				for(int c=0; c<C; c++) {
				
					if(map[r][c] == '<' || map[r][c] == 'v' || map[r][c] == '^' ||map[r][c] == '>') {
						
						tr=r;
						tc=c;
						
					} // 탱크 위치 찾기
				} //c
			} // r
					
			
			for(int s=0; s<joy.length; s++) {
				
				if(joy[s]=='U') {
					int nr = tr + dr[0];
					int nc = tc + dc[0];
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && map[nr][nc]!='-' && map[nr][nc]!='#' && map[nr][nc] != '*') {
						map[tr][tc] = '.';
						tr=nr;
						tc=nc;
					}
					map[tr][tc] = '^';
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && (map[nr][nc]=='-' || map[nr][nc]=='#' || map[nr][nc] == '*')) {
						map[tr][tc] = '^';
					}
					 
				} else if(joy[s]=='R') {
					int nr = tr + dr[1];
					int nc = tc + dc[1];
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && map[nr][nc]!='-' && map[nr][nc]!='#' && map[nr][nc] != '*') {
						map[tr][tc] = '.';
						tr=nr;
						tc=nc;
					}
					map[tr][tc] = '>';
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && (map[nr][nc]=='-' || map[nr][nc]=='#' || map[nr][nc] == '*')) {
						map[tr][tc] = '>';
					}
					
				} else if(joy[s]=='D') {
					int nr = tr + dr[2];
					int nc = tc + dc[2];
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && map[nr][nc]!='-' && map[nr][nc]!='#' && map[nr][nc] != '*') {
						map[tr][tc] = '.';
						tr=nr;
						tc=nc;
					}
					map[tr][tc] = 'v';
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && (map[nr][nc]=='-' || map[nr][nc]=='#' || map[nr][nc] == '*')) {
						map[tr][tc] = 'v';
					}
					
				} else if(joy[s]=='L') {
					int nr = tr + dr[3];
					int nc = tc + dc[3];
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && map[nr][nc]!='-' && map[nr][nc]!='#' && map[nr][nc] != '*') {
						map[tr][tc] = '.';
						tr=nr;
						tc=nc;
					}
					map[tr][tc] = '<';
					
					if(nr<R && nc<C && nr>=0 && nc>=0 && (map[nr][nc]=='-' || map[nr][nc]=='#' || map[nr][nc] == '*')) {
						map[tr][tc] = '<';
					}
					
				} else if(joy[s]=='S') {
					
					if(map[tr][tc]=='^') {
						
						int sr = tr + dr[0];
						while(sr>=0 && map[sr][tc]!='#') {
							if(map[sr][tc]=='*') {
								map[sr][tc]='.';
								break;
							}
							sr+=dr[0];
						}
						
					} else if(map[tr][tc]=='>') {
						
						int sc = tc + dc[1];
						while(sc<C && map[tr][sc]!='#') {
							if(map[tr][sc]=='*') {
								map[tr][sc]='.';
								break;
							}
							sc+=dc[1];
						}
						
					} else if(map[tr][tc]=='v') {
						
						int sr = tr + dr[2];
						while(sr<R && map[sr][tc]!='#') {
							if(map[sr][tc]=='*') {
								map[sr][tc]='.';
								break;
							}
							sr+=dr[2];
						}
						
					} else if(map[tr][tc]=='<') {
						
						int sc = tc + dc[3];
						while(sc>=0 && map[tr][sc]!='#') {
							if(map[tr][sc]=='*') {
								map[tr][sc]='.';
								break;
							}
							sc+=dc[3];
						}
						
					}
				
				} //S				
			}
			
			System.out.print("#" + testCase + " ");
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} //tc
	}
}
