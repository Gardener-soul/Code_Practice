package snail;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[][] arr = new int[N][N];
            int[] dr = { 0, 1, 0, -1 };
            int[] dc = { 1, 0, -1, 0 };
            int d = 0;
            int r = 0;
            int c = 0;
            for (int num = 1; num <= N*N; num++) {
                arr[r][c] = num;
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr >= N || nc >= N || nr < 0 || nc < 0 || arr[nr][nc] != 0) {
                    d = (d+1)%4;
                }
                r += dr[d];
                c += dc[d];
            }
            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
	} // main문
}
