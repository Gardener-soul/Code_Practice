import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		String word = "";
		String find = sc.nextLine();
		for (int i = 0; i < str.length(); i++) {
			if (!(str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9))
				word += str.charAt(i);
		}
		System.out.println(word.indexOf(find) != -1 ? 1 : 0);
	}
}
