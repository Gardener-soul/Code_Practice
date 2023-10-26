import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
	int r, c;

	public Pair(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
}

public class Main {

	static int N;
	static boolean[] chk;
	static int[][] map;
	static boolean flag;

	public static void tf(int level) {
		if(flag) return;
		
		if (Math.abs(map[level][0] - map[N + 1][0]) + Math.abs(map[level][1] - map[N + 1][1]) <= 1000) {
			flag = true;
			return;
		}

		for (int i = 1; i <= N; i++) {
			if(!chk[i]) {
				if (Math.abs(map[level][0] - map[i][0]) + Math.abs(map[level][1] - map[i][1]) <= 1000) {
					chk[i] = true;
					tf(i);
				}
				
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());

			chk = new boolean[N+1];
			map = new int[N + 2][2];

			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 2; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			flag = false;
			tf(0);

			if (flag) {
				System.out.println("happy");
			} else {
				System.out.println("sad");
			}

		}

	}

}