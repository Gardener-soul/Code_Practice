import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner s = new Scanner(System.in);

		String str = s.next();	// 팰린드롬인지 판별할 문자열
		boolean check = true;	// 팰린드롬인지 구분하는 불리언 변수

		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {	// 만약 각각의 문자가 일치하지 않는다면
				check = false;	// 불리언 변수를 false로 설정
				break;
			}
		}

		if (check) {	// 불리언 변수를 통한 결과 출력
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
}