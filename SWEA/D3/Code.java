package Two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution2 {

	static String[] num = { "0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011",
			"0110111", "0001011" };

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int T = scanner.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			int R = scanner.nextInt();
			int C = scanner.nextInt();
			char[][] map = new char[R][C];

			for (int r = 0; r < R; r++) {
				map[r] = scanner.next().toCharArray();
			} // 배열 잘 받아짐

			char[] code = new char[56];

			int idx = 55;	
			outer: for (int r = 0; r < R; r++) {
				for (int c = C - 1; c >= 0; c--) {
					if (map[r][c] == '1') {

						while (idx >= 0) {
							code[idx--] = map[r][c--];    //이 테크닉을 기억할 것.
						}

						break outer;

					}

				}
			}

			List<Integer> soo = new ArrayList<>();

			for (int i = 0; i < 56; i += 7) {
				StringBuilder sb = new StringBuilder();

				for (int j = i; j < i + 7; j++) {

					sb.append(code[j]);

				}

				for (int s = 0; s < 10; s++) {
					if (num[s].equals(sb.toString())) {  //String과 StringBuilder를 비교할 때 sb.toString() 메소드를 통해 스트링빌더를 스트링으로 변환시킨다음에 비교해주어야한다.
						soo.add(s);
					}
				}

			}

			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < soo.size(); i++) {
				if (i % 2 == 0) {
					sum += soo.get(i) * 3;
				} else if (i % 2 == 1) {
					sum += soo.get(i);
				}
				cnt+=soo.get(i);
			}
			
			if (sum % 10 == 0) {
				System.out.println("#" + testCase + " " + cnt);
			} else {
				System.out.println("#" + testCase + " " + 0);
			}

		}
	}
}
