import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int[][] map = new int[100][100];
		int cnt=0;
		for(int cp = 1; cp<=4; cp++) {
			
			int ax = scanner.nextInt();
			int ay = scanner.nextInt();
			int bx = scanner.nextInt();
			int by = scanner.nextInt();
			
			for(int r=ax; r<bx; r++) {
				for(int c=ay; c<by; c++) {
					map[r][c]=1;
				}
			}			
		}
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(map[r][c] == 1) {
				    cnt++;
				}
			}
		}
		
		System.out.println(cnt);
	}	
}