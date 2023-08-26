import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int C = scanner.nextInt();
		int R = scanner.nextInt();
		int[][] map = new int[R][C];
		
		//델타 상 우 하 좌
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		
		int r = R-1;
		int c = 0;
		int d = 0;
		
		for(int num=1; num<=R*C; num++) {
			map[r][c] = num;
			
			int nr = r + dr[d];
			int nc = c + dc[d];
			
			if (nr >= R || nc >= C || nr < 0 || nc < 0 || map[nr][nc]!=0) {
				d=(d+1)%4;
			}
			
			r += dr[d];
			c += dc[d];
		}
		
		int soo = scanner.nextInt();
		int ansr = 0;
		int ansc = 0;
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == soo) {
					ansr = j;
					ansc = i;
				} 
			}
		}
        
		if(soo>R*C) {
			System.out.println(0);
		} else {
			System.out.println((ansr+1) + " " + (R-ansc));
		}
		
	}
}