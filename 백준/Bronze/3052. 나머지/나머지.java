import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[] arr = new int[10];
		
		//숫자 입력
		for(int tc = 0; tc<10; tc++) {
			arr[tc]=scanner.nextInt()%42;
		}
		arr = Arrays.stream(arr).distinct().toArray(); //리스트 중복값 제거
		
		System.out.println(arr.length);
	} //main문
}