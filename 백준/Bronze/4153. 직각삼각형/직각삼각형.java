import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[3];
		String ans = "wrong";

		while (true) {
			arr[0] = scanner.nextInt();
			arr[1] = scanner.nextInt();
			arr[2] = scanner.nextInt();

			if (arr[0] == 0)
				break;

			Arrays.sort(arr);

			if (arr[0] + arr[1] < arr[2]) {
				ans = "wrong";
				System.out.println(ans);
			}

			if (Math.pow(arr[0], 2) + Math.pow(arr[1], 2) == Math.pow(arr[2], 2)) {
				ans = "right";
			} else {
				ans = "wrong";
			}

			System.out.println(ans);
			ans = "wrong";

		}
	}
}