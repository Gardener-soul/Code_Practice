package omok;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
		int N = sc.nextInt();
		char[][] omok = new char[N][N];  ///
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				omok[i][j] = str.charAt(j);
			}
		} // 오목판 생성 완료
        
		int[] dx= {-1,1,0,0,-1,1,-1,1}; //
        int[] dy= {0,0,-1,1,-1,-1,1,1}; //
        
		boolean flag=false; //
		f1: for(int i=0; i<N; i++) { //
			for(int j=0; j<N; j++) {
				if(omok[i][j]=='o') {
					for(int d=0; d<8; d++) {
						int len=1;
						int si=i;
						int sj=j;
						while(true) {
							int nx = si + dx[d];
							int ny = sj + dy[d];
							
							if(nx>=0 && nx<N && ny>=0 && ny<N&&omok[nx][ny]=='o') {
								si=nx;
								sj=ny;
								len++;
								
							}else break;
							if(len==5) {
								flag=true;
								break f1;
							}
						}
					}
				}
			}
		}
		if(flag) { System.out.println("#"+tc+" "+"YES");}
			else {System.out.println("#"+tc+" "+"NO");}
        }// tc반복문
	}
}
