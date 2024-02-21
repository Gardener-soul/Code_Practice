import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String N = sc.nextLine();

		int index = 10;
		for (int i = 0; i < N.length(); i++) {
			System.out.print(N.charAt(i));

			if (i % 10 == 9) { // 길이는 백을 넘지 않으므로 9일때마다 한줄
				System.out.println();
			}
		}
	}

}