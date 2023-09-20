import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

	public static int N;
	public static int[] num;

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {

			N = scanner.nextInt(); // 섬의 개수
			int[][] land = new int[N][2];

			for (int i = 0; i < N; i++) {
				land[i][0] = scanner.nextInt();
			} // x좌표 넣기

			for (int i = 0; i < N; i++) {
				land[i][1] = scanner.nextInt();
			} // y좌표 넣기

			double E = scanner.nextDouble(); // 세율

			int len = N * (N - 1) / 2;
			double[][] res = new double[len][3];

			int idx = 0;

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {

					double L = Math.sqrt(Math.pow(Math.abs((land[i][0] - land[j][0])), 2)
							+ Math.pow(Math.abs((land[i][1] - land[j][1])), 2));

					res[idx][0] = i;
					res[idx][1] = j;
					res[idx][2] = E * Math.pow(L, 2);
					idx++;
				}
			} // 길이 구하기

			Arrays.sort(res, new Comparator<double[]>() {

				@Override
				public int compare(double[] o1, double[] o2) {
					if (o1[2] > o2[2]) return 1;
					else if (o1[2] < o2[2]) return -1;
					return 0;
				}

			});

			num = new int[N];

			for (int i = 0; i < N; i++) {
				num[i] = i;
			}

			double ans = 0;

			for (int i = 0; i < len; i++) {
				int a = findset((int)res[i][0]);
				int b = findset((int)res[i][1]);

				if (a != b) {
					union(a, b);
					ans += res[i][2];
				}
			}

			System.out.println("#" + testCase + " " + Math.round(ans));

		} // tc
	} // main

	public static int findset(int x) {
		if (num[x] == x)
			return x;
		return num[x] = findset(num[x]);
	}

	public static void union(int y, int x) {
		
		if (x > y) {
			num[x] = y;
		} else {
			num[y] = x;
		}

	}

}