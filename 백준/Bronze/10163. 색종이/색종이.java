import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] map = new int[1001][1001];
		int[] answer = new int[N+1];
		int cpn = 1; //색종이 넘버
		for(int test = 1; test<=N; test++) {
			int cnt = 0;
			int i=scanner.nextInt();
			int j=scanner.nextInt();
			int a=scanner.nextInt();
			int b=scanner.nextInt();
			
			for(int r = i; r < i+a; r++) {
				for(int c = j; c<j+b; c++) {
					map[r][c] = cpn;
				}
			}
			cpn++;
		} 
		for(int i=0; i<1001; i++) {
			for(int b=0; b<1001; b++) {
				answer[map[i][b]]++;
			}
		}
		for(int i=1; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}