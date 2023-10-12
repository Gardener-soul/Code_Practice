import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int R, C, K, ans;
	static int[] zero, one;
	static int[][] map;

	static boolean chk() {
		int pass = 0;
		for (int c = 0; c < C; c++) {
			int cnt = 1;
			for (int r = 1; r < R; r++) {
				if (map[r][c] == map[r - 1][c]) {
					cnt++;
				} else {
					cnt = 1;
				}

				if (cnt == K) {
					pass++;
					break;
				}
			}

		}
		if (pass == C) {
			return true;
		} else {
			return false;
		}
	}

	public static void com(int level, int start) {

		if (ans <= level) {
			return;
		}

		if (start == R) {
			if (chk()) {
				ans = Math.min(ans, level);
			}
			return;
		}
		  
		int[] tmp = map[start];
		com(level, start+1);
		map[start] = zero;
		com(level + 1, start + 1);
		map[start] = one;
		com(level + 1, start + 1);
		map[start] = tmp;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); // 조건

			zero = new int[C];
			one = new int[C];
			map = new int[R][C];

			for (int i = 0; i < C; i++) {
				one[i] = 1;
			}

			for (int r = 0; r < R; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			ans = Integer.MAX_VALUE;
			com(0, 0);
			System.out.println("#" + testCase + " " + ans);

		} // tc
	}
}