
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		Long[] minArr = new Long[101];
		Arrays.fill(minArr, Long.MAX_VALUE);
		minArr[2] = 1L;
		minArr[3] = 7L;
		minArr[4] = 4L;
		minArr[5] = 2L;
		minArr[6] = 6L;
		minArr[7] = 8L;

		String[] Add = { "1", "7", "4", "2", "0", "8" };

		for (int i = 8; i <= 100; i++) {
			String str = "";
			for (int k = 2; k <= 7; k++) {
				if (i - k == 1)
					break;
				str = minArr[i - k] + Add[k - 2];
				minArr[i] = Math.min(minArr[i], Long.parseLong(str));

			}

		}

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			sb.append(minArr[N] + " ");
			String s = "";
			if (N % 2 == 1) {
				N -= 3;
				s += "7";
				for (int i = 0; i < N / 2; i++) {
					s += "1";
				}
			} else {
				for (int i = 0; i < N / 2; i++) {
					s += "1";
				}
			}
			sb.append(s).append("\n");

		}
		System.out.println(sb);
	}
}
