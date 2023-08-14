import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase <=10; testCase++) {
			int N = scanner.nextInt(); // 회문의 길이
			char[][] map = new char[8][8];
			
			for(int i=0; i<8; i++) {
				map[i] = scanner.next().toCharArray();
			} //map 배열 생성
			
			int ans = 0;
			for(int i=0; i<8; i++) {
				for(int j=0; j<8-N+1; j++) {
					StringBuilder sb = new StringBuilder();
					for(int k=0; k<N; k++) {
						sb.append(map[i][j+k]);
					}
					String str1 = String.valueOf(sb);
					sb.reverse();
					String str2 = String.valueOf(sb);
					
					if(str1.equals(str2)) {
						ans++;
					}
				}
			}
			
			for(int j=0; j<8; j++) {
				for(int i=0; i<8-N+1; i++) {
					StringBuilder sb2 = new StringBuilder();
					for(int k=0; k<N; k++) {
						sb2.append(map[i+k][j]);
					}
					String str1 = String.valueOf(sb2);
					sb2.reverse();
					String str2 = String.valueOf(sb2);
					
					if(str1.equals(str2)) {
						ans++;
					}
				}
			}
			System.out.println("#" + testCase + " " +ans);
		}//tc	
	}
}