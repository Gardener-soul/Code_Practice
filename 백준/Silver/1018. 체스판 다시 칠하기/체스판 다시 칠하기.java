import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, cnt;
	static char[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		cnt = 64;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int Wcnt = 0;
				int Bcnt = 0;
				int res = 0;
				for (int r = i; r < i + 8; r++) {
					for (int c = j; c < j + 8; c++) {
						if ((r + c) % 2 == 0 && map[r][c] == 'W')
							Wcnt++;
						if ((r + c) % 2 == 1 && map[r][c] == 'B')
							Wcnt++;
						if ((r + c) % 2 == 0 && map[r][c] == 'B')
							Bcnt++;
						if ((r + c) % 2 == 1 && map[r][c] == 'W')
							Bcnt++;
					}
				}
				res= Math.min(Wcnt, Bcnt);
				cnt = Math.min(cnt, res);
			}
		}
		System.out.println(cnt);
	}
}