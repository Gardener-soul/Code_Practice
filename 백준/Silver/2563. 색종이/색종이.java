import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		int[][] map = new int[100][100];
		
		for(int cp = 1; cp <= T; cp ++) {
			int a = scanner.nextInt(); //색종이 가로
			int b = scanner.nextInt(); //색종이 세로
			
			for(int i=a; i<a+10; i++) {
				for(int j=b; j<b+10; j++) {
					map[i][j] = 1;
				}
			}
		} //색종이 덧대기
		
		int cnt = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(map[i][j] == 1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	
}